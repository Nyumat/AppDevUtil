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
import retrofit2.http.PUT
import retrofit2.http.POST
import retrofit2.http.DELETE

private const val BASE_URL = "https://hu5nnerv6b.execute-api.us-west-2.amazonaws.com/Prod"


private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit =
    Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .baseUrl(BASE_URL)
        .build()

interface CatApiService {
    @GET("/devices")
    fun getDevices(

    );

    @POST("/devices")
    fun postDevices(

    );

    @GET("/devices/{deviceid}")
    fun getDeviceById(
        @Path("deviceid") id: String

    );

    @PUT("/devices/{deviceid}")
    fun updateDeviceById(
        @Path("deviceid") id: String

    );

    @DELETE("/devices/{deviceid}")
    fun deleteDeviceById(
        @Path("deviceid") id: String

    );
}

object CatApi {
    val retrofitService: CatApiService by lazy { retrofit.create(CatApiService::class.java) }
}