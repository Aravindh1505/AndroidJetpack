package com.aravindh.androidjetpack.network

import io.reactivex.Observable
import retrofit2.http.POST

interface NetworkRepositoryApi {

    @POST(ApiConstant.SIGN_IN)
    fun getSignIn(): Observable<String>?

    fun getData() = "This is sample data"
}