package jp.making.felix.animalpreview.di

import dagger.Binds
import dagger.Module
import jp.making.felix.animalpreview.data.repository.DogRepository
import jp.making.felix.animalpreview.data.response.DogDataSource

@Module
internal interface RepositoryModule {

    @Binds
    fun bindDogRepository(repository: DogRepository): DogDataSource
}