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

private const val BASE_URL = "https://api.thecatapi.com";

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit =
                Retrofit.Builder()
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .addConverterFactory(MoshiConverterFactory.create(moshi))
                                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                                .baseUrl(BASE_URL)
                                .build()

interface CatApiService {
        @GET("/v1/images/search")
        fun getCats(): Deferred<Response<ResponseBody>>
}

object CatApi {
        val retrofitService: CatApiService by lazy { retrofit.create(CatApiService::class.java) }
}
