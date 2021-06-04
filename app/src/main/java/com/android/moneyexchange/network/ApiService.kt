package com.android.moneyexchange.network

import com.android.moneyexchange.network.response.CurrenciesListResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("latest")
    suspend fun getCurrencies(@Query("access_key") accessKey: String): CurrenciesListResponse

}