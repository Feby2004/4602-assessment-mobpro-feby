package org.d3if0079.assessmentmobpro.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.d3if0079.assessmentmobpro.model.Bunga
import org.d3if0079.assessmentmobpro.model.OpStatus
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

private const val BASE_URL = "https://unspoken.my.id/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface BungaApiService {
    @GET("api_feby.php")
    suspend fun getBunga(): List<Bunga>

    @Multipart
    @POST("api_feby.php")
    suspend fun postBunga(
        @Header("Authorization") userId: String,
        @Part("nama") nama: RequestBody,
        @Part("namaLatin") namaLatin: RequestBody,
        @Part image: MultipartBody.Part
    ): OpStatus
}

object BungaApi {
    val service: BungaApiService by lazy {
        retrofit.create(BungaApiService::class.java)
    }

    fun getBungaUrl(imageId: String): String {
        return "${BASE_URL}image.php?id=$imageId"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }