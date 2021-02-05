package com.aravindh.androidjetpack.network

import com.aravindh.androidjetpack.ui.login.EmployeesResponse
import io.reactivex.Observable
import retrofit2.Call

class NetworkRepository(api: NetworkRepositoryApi) {

    var networkRepositoryApi = api

    suspend fun getEmployees(): List<EmployeesResponse>? {
        return networkRepositoryApi.getEmployees()
    }


}