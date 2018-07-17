package com.android.zore3x.artoscats.model.api

import com.android.zore3x.artoscats.model.Cat
import com.android.zore3x.artoscats.model.endpoints.CatsEndpoint
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CatsApi() {

//    val BASE_URL = "localhost:8080/catsApi/"
    val BASE_URL = "http://192.168.232.120:8080/catsApi/"

    val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val catsService = retrofit.create(CatsEndpoint::class.java);

    fun getAllCats() = catsService.getAllCats();

    fun getCat(catId: Long) = catsService.getCat(catId)

    fun saveCat(cat: Cat) = catsService.saveCat(cat.name, cat.age)

    fun updateCat(cat: Cat) = catsService.updateCat(cat.id, cat.name, cat.age)

    fun deleteCat(catId: Long) = catsService.deleteCat(catId)
}