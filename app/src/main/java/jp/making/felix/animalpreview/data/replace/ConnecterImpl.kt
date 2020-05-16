package jp.making.felix.animalpreview.data.replace

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import jp.making.felix.animalpreview.data.response.DogApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

internal class ConnecterImpl() : Connecter {
    private fun getRetrofit(): Retrofit {
        val okHttpClient = OkHttpClient.Builder()
            .apply {
                connectTimeout(120, TimeUnit.SECONDS)
                readTimeout(60, TimeUnit.SECONDS)
                writeTimeout(60, TimeUnit.SECONDS)
            }
            .addInterceptor(
                HttpLoggingInterceptor()
                    .apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
            .build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://dog.ceo/api/breeds/image/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    override fun getApiService(): DogApiService {
        val retrofit = getRetrofit()
        return retrofit.create(DogApiService::class.java)
    }
}