package com.android.zore3x.artoscats.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Cat(
        @SerializedName("id")
        var id: Integer,
        @SerializedName("name")
        var name: String,
        @SerializedName("age")
        var age: Integer)