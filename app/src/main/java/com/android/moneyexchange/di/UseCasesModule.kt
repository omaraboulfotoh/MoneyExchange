package com.android.moneyexchange.di

import com.android.moneyexchange.network.FormRemoteDataSource
import com.android.moneyexchange.network.usecase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun providesUseCases(remote: FormRemoteDataSource): UseCases {
        return UseCases(remote)
    }

    @Provides
    fun providesGetCurrenciesUseCase(useCases: UseCases): UseCases.GetCurrenciesUseCase {
        return useCases.getCurrencies
    }
}
