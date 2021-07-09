package com.example.shibesample.data.remote

import com.example.shibesample.data.models.ShibeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ShibeService {

    @GET("api/shibes")
    suspend fun getShibes(
        @Query("count") count: Int
    ) : Response<ShibeResponse>

}