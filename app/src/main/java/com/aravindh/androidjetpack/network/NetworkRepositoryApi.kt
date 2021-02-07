package com.aravindh.androidjetpack.network

import com.aravindh.androidjetpack.network.ApiConstant.GET_EMPLOYEES
import com.aravindh.androidjetpack.ui.login.WorldDataResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface NetworkRepositoryApi {

    @GET(GET_EMPLOYEES)
    suspend fun getEmployees(): WorldDataResponse?


}