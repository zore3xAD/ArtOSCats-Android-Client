package com.android.zore3x.artoscats.view

import com.android.zore3x.artoscats.model.Cat
import com.arellomobile.mvp.MvpView

interface ICatEditableView: MvpView {

    fun showCat(cat: Cat)
    fun showMessage(message: String)
    fun close()

}