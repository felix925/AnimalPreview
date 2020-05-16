package jp.making.felix.animalpreview.di

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import jp.making.felix.animalpreview.data.response.DogApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
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
    }

    @Provides
    @Singleton
    @Named("dog")
    internal fun provideRetrofit(
        oktHttpClient: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .client(oktHttpClient)
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
        .build()

    @Provides
    @Singleton
    internal fun provideDogApiService(
        @Named("dog") retrofit: Retrofit
    ): DogApiService {
        return retrofit.create(DogApiService::class.java)
    }
}
