package jp.making.felix.animalpreview.data.repository

import jp.making.felix.animalpreview.data.replace.Connecter
import jp.making.felix.animalpreview.data.replace.ConnecterImpl
import jp.making.felix.animalpreview.data.response.*
import jp.making.felix.animalpreview.data.response.DogApiService
import javax.inject.Inject
import javax.inject.Singleton

@ExperimentalStdlibApi
@Singleton
internal class DogRepository: DogDataSource {
    // TODO: DIする...
    private val connect:Connecter = ConnecterImpl()
    private val dogApi: DogApiService = connect.getApiService()
    override suspend fun getDogs(
        count: Int
    ): List<Dog> {
        return buildList {
            dogApi.getDogs(count = count).message.forEach {
                this.add(Dog(it))
            }
        }
    }
}