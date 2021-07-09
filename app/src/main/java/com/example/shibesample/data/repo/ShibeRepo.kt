package com.example.shibesample.data.repo

import com.example.shibesample.data.models.ShibeResponse
import com.example.shibesample.data.remote.ShibeManager
import com.example.shibesample.utils.Resource

object ShibeRepo {

    suspend fun getShibes(count: Int): Resource<ShibeResponse> {
        return try {
            val shibesResponse = ShibeManager.getShibes(count)
            if (shibesResponse.isSuccessful && shibesResponse.body() != null
            ) {
                Resource.Success(shibesResponse.body()!!)
            } else {
                Resource.Error(null, errorMsg = "No Shibes found")
            }
        } catch (ex: Exception) {
            Resource.Error(exception = ex, "Unexpected Error")
        }
    }
}