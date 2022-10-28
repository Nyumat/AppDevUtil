package com.example.playgroundappdev.Shared.Utils

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.thecatapi.com/v1/images/search"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit =
                Retrofit.Builder()
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(MoshiConverterFactory.create(moshi))
                                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                                .baseUrl(BASE_URL)
                                .build()

interface CatApiService {
        @GET("/cats")
        fun getCats(): Deferred<Response<ResponseBody>>
}

object CatApi {
        val retrofitService: CatApiService by lazy { retrofit.create(CatApiService::class.java) }
}

<<<<<<< HEAD
//private const val BASE_URL = "https://api.thecatapi.com/v1/images/search";
private const val BASE_URL = "https://api.thecatapi.com";

val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

interface HttpService {
        @GET("/v1/images/search")
        //fun getImagesAsync():

        //@POST("")
        //@HEADERS("")
        //fun createImagesAsync()
}

object HttpApi {
        val retrofitService: HttpService by lazy {
                retrofit.create(HttpService::class.java)
        }
}
=======

>>>>>>> 0d48ff54a7adf25414548cd2e53c3bd3d7e6a74d
