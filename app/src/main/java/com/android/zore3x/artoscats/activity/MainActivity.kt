package com.android.zore3x.artoscats.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.zore3x.artoscats.App
import com.android.zore3x.artoscats.R
import com.android.zore3x.artoscats.model.Cat
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var cats: MutableList<Cat>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
