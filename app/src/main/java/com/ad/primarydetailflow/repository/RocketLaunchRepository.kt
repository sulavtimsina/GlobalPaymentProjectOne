package com.ad.primarydetailflow.repository

import com.ad.primarydetailflow.data.LaunchApi
import javax.inject.Inject

class RocketLaunchRepository @Inject constructor(
  private val launchApi: LaunchApi,
) {
  suspend fun getLaunchApi() = launchApi.getLaunches()

}