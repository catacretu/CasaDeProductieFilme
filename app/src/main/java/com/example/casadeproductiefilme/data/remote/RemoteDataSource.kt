package com.example.casadeproductiefilme.data.remote

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val gson: Gson) {

    companion object {
        private const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    fun <Api> buildApi(
        api: Class<Api>
    ): Api = Retrofit.Builder().baseUrl(BASE_URL).client(OkHttpClient().newBuilder().build())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build().create(api)

}