package com.android.moneyexchange.network

import com.android.moneyexchange.app.API_KEY
import com.android.moneyexchange.network.response.CurrenciesListResponse
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import java.text.SimpleDateFormat
import java.util.*

/* TODO: Use Interface */
class FormRemoteDataSource(
    private val service: ApiService,
    override val gson: Gson,
    override val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : SafeNetworkRequestCaller {


    suspend fun getCurrencies(): Result<CurrenciesListResponse> {
        return request { service.getCurrencies(API_KEY) }
    }


    companion object {
        private fun currentISODate(): String {
            return SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US).apply {
                timeZone = TimeZone.getTimeZone("UTC")
            }.format(Date())
        }
    }
}
