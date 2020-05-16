package jp.making.felix.animalpreview.data.response

interface DogDataSource {

    suspend fun getDogs(
        count: Int
    ): List<Dog>
}