package org.scesi.cappuchinoawesome.ui.features.schedule.data

import org.scesi.cappuchinoawesome.ui.network.ApiService
import org.scesi.cappuchinoawesome.ui.network.RetrofitClient
import org.scesi.cappuchinoawesome.ui.network.data.DetailCareer

class ScheduleService {
    private val api: ApiService = RetrofitClient.retrofit

    suspend fun getDetailCareer(code: Int): DetailCareer {
        return api.getDetailCareer(code)
    }
}