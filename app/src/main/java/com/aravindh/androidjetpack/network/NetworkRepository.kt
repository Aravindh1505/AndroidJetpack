package com.aravindh.androidjetpack.network

import com.aravindh.androidjetpack.ui.login.WorldDataResponse
import com.aravindh.androidjetpack.utils.Logger

class NetworkRepository(api: NetworkRepositoryApi) {

    var networkRepositoryApi = api

    suspend fun getEmployees(): WorldDataResponse? = networkRepositoryApi.getEmployees()


}