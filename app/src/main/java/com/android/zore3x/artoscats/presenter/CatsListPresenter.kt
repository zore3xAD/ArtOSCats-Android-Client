package com.android.zore3x.artoscats.presenter

import com.android.zore3x.artoscats.App
import com.android.zore3x.artoscats.model.Cat
import com.android.zore3x.artoscats.view.ICatListView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class CatsListPresenter: MvpPresenter<ICatListView>() {

    fun loadData() {
        App.catsApi.getAllCats()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { viewState.showCats(it) },
                        { viewState.showMessage(it.localizedMessage) },
                        { viewState.hideProgress()},
                        { viewState.showProgress()})
    }
}