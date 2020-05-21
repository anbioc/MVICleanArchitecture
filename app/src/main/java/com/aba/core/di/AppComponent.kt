package com.aba.core.di

import android.app.Application
import com.aba.core.scope.PerApplication
import com.aba.domain.di.MapperModule
import com.aba.domain.di.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton


@Singleton
@PerApplication
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        MapperModule::class,
        SearchFragmentBinding::class
    ]
)
interface AppComponent : AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(instance: DaggerApplication)
}