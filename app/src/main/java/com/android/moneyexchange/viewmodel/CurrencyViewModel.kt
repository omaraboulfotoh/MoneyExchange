package com.android.moneyexchange.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.android.moneyexchange.di.IODispatcher
import com.android.moneyexchange.models.CURRENCIES
import com.android.moneyexchange.models.Currency
import com.android.moneyexchange.network.data
import com.android.moneyexchange.network.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getCurrenciesUseCase: UseCases.GetCurrenciesUseCase,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    fun loadCurrencies() =
        liveData {
            val result = getCurrenciesUseCase(UseCases.GetCurrenciesUseCase.Params("")).await()
            val homeList = mutableListOf<Currency>()
            result.data?.let {
                homeList.addAll(CURRENCIES.filter { currency ->
                    it.rates[currency.code] != null
                })
                homeList.forEach { currency -> currency.rate = it.rates[currency.code] }
            }
            emit(homeList)
        }
}