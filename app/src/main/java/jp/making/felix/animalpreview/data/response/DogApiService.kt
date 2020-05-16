package jp.making.felix.animalpreview.data.response

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface DogApiService {
    @GET("random/{count}")
    suspend fun getDogs(
        @Path("count") count: Int
    ): DogResponse
}