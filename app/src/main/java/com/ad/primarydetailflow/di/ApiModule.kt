package com.ad.primarydetailflow.di

import com.ad.primarydetailflow.data.LaunchApi
import com.ad.primarydetailflow.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
  @Provides
  @Singleton
  fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
  }

  @Provides
  @Singleton
  fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
    return OkHttpClient.Builder()
      .addInterceptor(loggingInterceptor)
      .build()
  }

  @Provides
  @Singleton
  fun provideRetrofit(client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .build()
  }

  @Provides
  @Singleton
  fun provideRocketLaunchApi(retrofit: Retrofit): LaunchApi {
    return retrofit.create(LaunchApi::class.java)
  }
}