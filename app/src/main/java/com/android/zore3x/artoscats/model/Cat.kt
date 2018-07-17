package com.android.zore3x.artoscats.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Cat(
        @Expose
        @SerializedName("id")
        var id: Long,
        @SerializedName("name")
        var name: String,
        @SerializedName("age")
        var age: Int) {
        constructor(name: String, age: Int) : this(1, name, age)
}