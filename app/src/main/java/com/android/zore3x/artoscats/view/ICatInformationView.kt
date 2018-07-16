package com.android.zore3x.artoscats.view

import com.android.zore3x.artoscats.model.Cat
import com.arellomobile.mvp.MvpView

interface ICatInformationView: MvpView {

    fun showCatInformation(cat: Cat)
    fun showMessage(message: String)

}