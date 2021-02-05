package com.aravindh.androidjetpack.di

import com.aravindh.androidjetpack.network.ApiConstant.BASE_URL
import com.aravindh.androidjetpack.network.NetworkRepository
import com.aravindh.androidjetpack.network.NetworkRepositoryApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient.Builder()
            .connectTimeout((180).toLong(), TimeUnit.SECONDS)
            .readTimeout((180).toLong(), TimeUnit.SECONDS)
            .writeTimeout((180).toLong(), TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideNetworkRepositoryApi(retrofit: Retrofit): NetworkRepositoryApi? {
        return retrofit.create(NetworkRepositoryApi::class.java)
    }

    @Singleton
    @Provides
    fun provideNetworkRepository(networkRepositoryApi: NetworkRepositoryApi): NetworkRepository {
        return NetworkRepository(networkRepositoryApi)
    }
}