package org.hogwarts.harrypotter.di

import org.hogwarts.harrypotter.core.CoroutineDispatcherProvider
import org.hogwarts.harrypotter.core.CoroutineDispatcherProviderImpl
import org.hogwarts.harrypotter.core.StringProvider
import org.hogwarts.harrypotter.data.mapper.HPMapper
import org.hogwarts.harrypotter.data.remote.api.HPApi
import org.hogwarts.harrypotter.data.remote.config.ApiBaseUrl
import org.hogwarts.harrypotter.data.remote.config.HttpClientEngineProvider
import org.hogwarts.harrypotter.data.remote.config.HttpClientProvider
import org.hogwarts.harrypotter.data.repository.HPRepository
import org.hogwarts.harrypotter.presentation.home.HomeViewModel
import org.hogwarts.harrypotter.presentation.list.CharactersViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    factoryOf(::CoroutineDispatcherProviderImpl).bind(CoroutineDispatcherProvider::class)
    factoryOf(::StringProvider)

    viewModelOf(::HomeViewModel)
    viewModelOf(::CharactersViewModel)
}

val dataModule = module {
    // remote
    singleOf(::HPApi)
    factoryOf(::HPRepository)
    factoryOf(::HPMapper)
}

val networkModule = module {
    single { ApiBaseUrl("hp-api.onrender.com/api") }
    singleOf(HttpClientEngineProvider::provide)
    singleOf(::HttpClientProvider)
    singleOf(HttpClientProvider::provide)
}
