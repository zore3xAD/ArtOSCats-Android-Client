package com.android.zore3x.artoscats.model.endpoints

import com.android.zore3x.artoscats.model.Cat
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface CatsEndpoint {

    @GET("all")

    fun getAllCats(): Observable<MutableList<Cat>>
}