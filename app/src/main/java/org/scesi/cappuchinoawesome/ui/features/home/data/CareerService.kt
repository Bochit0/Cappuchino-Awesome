package org.scesi.cappuchinoawesome.ui.features.home.data

import org.scesi.cappuchinoawesome.ui.network.ApiService
import org.scesi.cappuchinoawesome.ui.network.RetrofitClient
import org.scesi.cappuchinoawesome.ui.network.data.Career

class CareerService{
    private val api: ApiService = RetrofitClient.retrofit

    suspend fun getCareers(): List<Career> {
        return api.getCareers()
    }
}