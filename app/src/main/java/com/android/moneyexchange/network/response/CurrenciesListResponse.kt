package com.android.moneyexchange.network.response

import java.io.Serializable

data class CurrenciesListResponse(
    val success: Boolean,
    val base:String,
    val rates: Map<String,Double>
) : Serializable