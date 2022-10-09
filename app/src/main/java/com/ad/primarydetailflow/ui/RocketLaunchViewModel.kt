package com.ad.primarydetailflow.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ad.primarydetailflow.data.model.Launch
import com.ad.primarydetailflow.repository.RocketLaunchRepository
import com.ad.primarydetailflow.util.NetworkUtil
import com.ad.primarydetailflow.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.IOException
import java.util.concurrent.CancellationException
import javax.inject.Inject

@HiltViewModel
class RocketLaunchViewModel @Inject constructor(
  private val launchesRepository: RocketLaunchRepository,

  ) : ViewModel() {
  val launchList: MutableLiveData<Resource<Launch>> = MutableLiveData()

  suspend fun getLaunchList(context: Context) {
    launchList.postValue(Resource.Loading())
    try {
      if (NetworkUtil.hasInternetConnection(context)) {

        val response = launchesRepository.getLaunchApi()

        if (response.isSuccessful) {

          response.body()?.let {
            launchList.postValue(Resource.Success(it))
          }

        } else launchList.postValue(Resource.Error(response.message()))
      }

    } catch (ex: Exception) {
      when (ex) {
        is CancellationException -> {}
        is IOException -> launchList.postValue(Resource.Error("Network Failure:${ex.message}"))
        else -> launchList.postValue(Resource.Error(ex.message.toString()))
      }
    }
  }

}