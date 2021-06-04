package com.android.moneyexchange.models

import java.io.Serializable

data class Currency(val name: String, val code: String, val flag: String, val rate: Double) :
    Serializable {
    fun getRateString(): String {
        return rate.toString()
    }
}