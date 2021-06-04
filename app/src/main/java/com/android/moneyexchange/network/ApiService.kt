package com.android.moneyexchange.network

import com.android.moneyexchange.network.response.CurrenciesListResponse
import retrofit2.http.GET


interface ApiService {

    @GET("/home/home")
    suspend fun getCurrencies(): CurrenciesListResponse

}