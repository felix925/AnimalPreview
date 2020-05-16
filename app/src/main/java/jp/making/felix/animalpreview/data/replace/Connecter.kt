package jp.making.felix.animalpreview.data.replace

import jp.making.felix.animalpreview.data.response.DogApiService

internal interface Connecter {
    fun getApiService(): DogApiService
}