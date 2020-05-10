package jp.making.felix.animalpreview.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import jp.making.felix.animalpreview.MainActivity
import jp.making.felix.animalpreview.ui.HomeFragment

@Module
abstract class AppModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeHomeFragment(): HomeFragment

    @Binds
    abstract fun bindContext(app: App): Context
}