package com.android.zore3x.artoscats.model.endpoints

import com.android.zore3x.artoscats.model.Cat
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import retrofit2.http.*
import java.util.*

interface CatsEndpoint {

    @GET("all")
    fun getAllCats()
            : Observable<MutableList<Cat>>

    @GET("getCat")
    fun getCat(@Query("catId") catId: Long)
            : Single<Cat>

    @POST("insert")
    fun saveCat(@Query("name") name: String,
                @Query("age") age: Int)
            : Completable

    @PUT("update")
    fun updateCat(@Query("catId") catId: Long,
                  @Query("name") name: String,
                  @Query("age") age: Int)
            : Completable

    @DELETE("delete")
    fun deleteCat(@Query("catId") catId: Long)
            : Completable
}