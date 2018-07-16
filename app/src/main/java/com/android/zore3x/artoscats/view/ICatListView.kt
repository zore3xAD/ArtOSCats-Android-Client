package com.android.zore3x.artoscats.view

import com.android.zore3x.artoscats.model.Cat
import com.arellomobile.mvp.MvpView

interface ICatListView : MvpView {

    fun showMessage(message: String)
    fun showCats(data: MutableList<Cat>)
    fun showProgress()
    fun hideProgress()
    fun openCatInformationActivity(catId: Int)
}