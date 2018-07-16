package com.android.zore3x.artoscats.model.endpoints

import com.android.zore3x.artoscats.model.Cat
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface CatsEndpoint {

    @GET("all")

    fun getAllCats(): Observable<MutableList<Cat>>
    fun getCat(@Query("catId") catId: Int): Single<Cat>
}