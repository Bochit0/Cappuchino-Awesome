package org.scesi.cappuchinoawesome.ui.network

import org.scesi.cappuchinoawesome.ui.network.data.Career
import retrofit2.http.GET

interface ApiService {
    @GET("index.json")
    suspend fun getCareers(): List<Career>
}