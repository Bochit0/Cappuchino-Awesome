package org.scesi.cappuchinoawesome.network

import org.scesi.cappuchinoawesome.network.data.Career
import org.scesi.cappuchinoawesome.network.data.DetailCareer
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("index.json")
    suspend fun getCareers(): List<Career>

    @GET("2026-01/{code}.json")
    suspend fun getDetailCareer(@Path("code") code : Int): DetailCareer
}