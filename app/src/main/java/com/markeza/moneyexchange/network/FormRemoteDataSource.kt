package com.markeza.moneyexchange.network

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


    companion object {
        private fun currentISODate(): String {
            return SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'", Locale.US).apply {
                timeZone = TimeZone.getTimeZone("UTC")
            }.format(Date())
        }
    }
}
