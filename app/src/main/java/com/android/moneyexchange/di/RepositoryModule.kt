package com.android.moneyexchange.di

import com.android.moneyexchange.network.ApiService
import com.android.moneyexchange.network.FormRemoteDataSource
import com.google.gson.Gson
import dagger.hilt.components.SingletonComponent
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun providesFormRemoteDataSource(
        api: ApiService,
        gson: Gson,
    ): FormRemoteDataSource {
        return FormRemoteDataSource(api, gson)
    }
}
