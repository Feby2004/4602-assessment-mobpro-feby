package org.d3if0079.assessmentmobpro.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0079.assessmentmobpro.model.Bunga
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/Feby2004/Bunga-Json/main/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface BungaApiService {
    @GET("static-api.Json")
    suspend fun getBunga(): List<Bunga>
}

object BungaApi {
    val service: BungaApiService by lazy {
        retrofit.create(BungaApiService::class.java)
    }

    fun getBungaUrl(imageId: String): String {
        return "$BASE_URL$imageId.jpg"
    }
}