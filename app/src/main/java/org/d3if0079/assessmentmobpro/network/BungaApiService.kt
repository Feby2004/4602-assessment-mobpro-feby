package org.d3if0079.assessmentmobpro.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/Feby2004/Bunga-Json/main/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()
interface BungaApiService {
    @GET("static-api.Json")
    suspend fun getBunga(): String
}

object BungaApi {
    val service: BungaApiService by lazy {
        retrofit.create(BungaApiService::class.java)
    }
}