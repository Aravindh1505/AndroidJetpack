package com.aravindh.androidjetpack.di

import android.app.Application
import com.aravindh.androidjetpack.connectivity.ConnectivityManager
import com.aravindh.androidjetpack.network.ApiConstant.BASE_URL
import com.aravindh.androidjetpack.network.NetworkRepository
import com.aravindh.androidjetpack.network.NetworkRepositoryApi
import com.aravindh.androidjetpack.utils.Logger
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
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
            .retryOnConnectionFailure(true)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        Logger.d("okHttpClient : $okHttpClient")
        Logger.d("gson : $gson")

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideNetworkRepositoryApi(retrofit: Retrofit): NetworkRepository {
        return NetworkRepository(retrofit.create(NetworkRepositoryApi::class.java))
    }

    @Singleton
    @Provides
    fun provideConnectivityManager(application: Application): ConnectivityManager {
        return ConnectivityManager(application)
    }



}