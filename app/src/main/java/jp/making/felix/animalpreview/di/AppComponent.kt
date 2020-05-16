package jp.making.felix.animalpreview.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App>{
    @Component.Builder
    interface Builder {
        fun application(@BindsInstance application: App): Builder
        fun build():AppComponent
    }
}