package com.example.movil_pc3_josueflorian.network

import com.example.movil_pc3_josueflorian.model.BooksResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {
    @GET("volumes")
    suspend fun getBooks(@Query("q") query: String): BooksResponse
}
