package com.example.dogs.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

private const val BASE_URL="https://dog.ceo/api/breed/"
//private const val BASE_URL="https://mars.udacity.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory( MoshiConverterFactory.create(moshi))
    //.addConverterFactory(GsonConverterFactory.create( ))
    .baseUrl(BASE_URL)
    .build()

interface DogsApiService{
    //@GET("hound/images")
    //suspend fun getListPerros(): Dogs

    @GET()
    suspend fun getListPerros(@Url url:String): Dogs
}

object DogsApi {
    val retrofitService: DogsApiService by lazy {
        retrofit.create(DogsApiService::class.java)
    }
}