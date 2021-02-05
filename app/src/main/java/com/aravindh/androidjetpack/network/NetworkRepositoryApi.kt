package com.aravindh.androidjetpack.network

import com.aravindh.androidjetpack.network.ApiConstant.GET_EMPLOYEES
import com.aravindh.androidjetpack.ui.login.EmployeesResponse
import retrofit2.Call
import retrofit2.http.GET

interface NetworkRepositoryApi {

    @GET(GET_EMPLOYEES)
    suspend fun getEmployees(): List<EmployeesResponse>?


}