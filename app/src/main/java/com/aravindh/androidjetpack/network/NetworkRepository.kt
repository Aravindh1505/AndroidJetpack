package com.aravindh.androidjetpack.network

class NetworkRepository(api: NetworkRepositoryApi) {

    var networkRepositoryApi = api

    fun getSampleData(): String {
        return networkRepositoryApi.getData()
    }
}