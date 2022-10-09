package com.ad.primarydetailflow.data

import com.ad.primarydetailflow.data.model.Launch
import retrofit2.Response
import retrofit2.http.GET

interface LaunchApi {
  @GET("launches")
  suspend fun getLaunches(): Response<Launch>
}