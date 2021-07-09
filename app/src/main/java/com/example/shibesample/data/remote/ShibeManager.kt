package com.example.shibesample.data.remote

import com.example.shibesample.data.models.ShibeResponse
import retrofit2.Response

object ShibeManager {

    private val service: ShibeService
    private val retrofit = RetrofitService.providesRetrofitService()

    init {
        service = retrofit.create(ShibeService::class.java)
    }

    suspend fun getShibes(count: Int = 100): Response<ShibeResponse> {
        return service.getShibes(count)
    }
}