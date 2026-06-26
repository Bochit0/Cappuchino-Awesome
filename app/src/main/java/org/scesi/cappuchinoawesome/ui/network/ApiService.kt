package org.scesi.cappuchinoawesome.ui.network

import org.scesi.cappuchinoawesome.ui.network.data.Carreer
import retrofit2.http.GET

interface ApiService {
    @GET("index.json")
    suspend fun getCarreers(): List<Carreer>
}