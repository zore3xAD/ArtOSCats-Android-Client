package com.android.zore3x.artoscats.presenter

import com.android.zore3x.artoscats.App
import com.android.zore3x.artoscats.view.ICatInformationView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class CatInformationPresenter: MvpPresenter<ICatInformationView>() {

    fun getCat(catId: Int) {
        App.catsApi.getCat(catId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { viewState.showCatInformation(it)},
                        {viewState.showMessage(it.localizedMessage)})
    }

}