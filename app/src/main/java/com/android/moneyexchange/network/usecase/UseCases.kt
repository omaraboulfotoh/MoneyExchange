package com.android.moneyexchange.network.usecase

import com.android.moneyexchange.network.FormRemoteDataSource
import com.android.moneyexchange.network.Result
import com.android.moneyexchange.network.response.CurrenciesListResponse
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UseCases(
    repository: FormRemoteDataSource,
    coroutineContext: CoroutineContext = Dispatchers.IO
) {
    private var job: Job = SupervisorJob()
    private val scope = CoroutineScope(coroutineContext) + job


    class GetCurrenciesUseCase internal constructor(
        private val repository: FormRemoteDataSource,
        override val scope: CoroutineScope
    ) : UseCase<GetCurrenciesUseCase.Params, CurrenciesListResponse>() {

        override suspend fun doWork(params: Params): Result<CurrenciesListResponse> {
            return repository.getCurrencies()
        }

        data class Params(val name: String)
    }


    val getCurrencies: GetCurrenciesUseCase by lazy {
        GetCurrenciesUseCase(repository, scope)
    }
}
