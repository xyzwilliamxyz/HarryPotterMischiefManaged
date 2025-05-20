package org.hogwarts.harrypotter

import android.app.Application
import org.hogwarts.harrypotter.di.appModule
import org.hogwarts.harrypotter.di.dataModule
import org.hogwarts.harrypotter.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin

class HPMMApplication : Application(), KoinComponent {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HPMMApplication)
            modules(
                appModule,
                dataModule,
                networkModule,
            )
        }
    }
}
