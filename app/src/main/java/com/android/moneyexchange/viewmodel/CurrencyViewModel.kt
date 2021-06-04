package com.android.moneyexchange.viewmodel

import androidx.lifecycle.ViewModel
import com.android.moneyexchange.di.IODispatcher
import com.android.moneyexchange.network.usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject


@HiltViewModel
class CurrencyViewModel @Inject constructor(
    private val getCurrenciesUseCase: UseCases.GetCurrenciesUseCase,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) : ViewModel() {


}