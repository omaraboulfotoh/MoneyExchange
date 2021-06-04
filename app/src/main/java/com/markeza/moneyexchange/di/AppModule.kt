package com.markeza.moneyexchange.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import com.markeza.moneyexchange.di.AppCoroutineDispatchers

@InstallIn(SingletonComponent::class)
@Module(
    includes = [
        NetworkModule::class,
        RepositoryModule::class
    ]
)
object AppModule {
}
