package com.soulsensei.app.data.remote

import com.soulsensei.app.data.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("sanjeevworkstation/c27e6cc85b7d4bcaf8ec73d96a0ae25b/raw/4a2ce8c5215f2d7a7201338a6af49a77c0f81f6a/assignment.json")
                suspend fun getAssignment(): Response<ApiResponse>

}