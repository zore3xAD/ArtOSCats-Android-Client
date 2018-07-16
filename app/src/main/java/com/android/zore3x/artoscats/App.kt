package com.android.zore3x.artoscats

import android.app.Application
import com.android.zore3x.artoscats.model.api.CatsApi

class App: Application() {

    companion object {
        lateinit var catsApi: CatsApi
            private set
            get
    }

    override fun onCreate() {
        super.onCreate()
        catsApi = CatsApi();
    }

}