package com.android.zore3x.artoscats.presenter

import com.android.zore3x.artoscats.App
import com.android.zore3x.artoscats.model.Cat
import com.android.zore3x.artoscats.model.api.CatsApi
import com.android.zore3x.artoscats.view.ICatEditableView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class CatEditablePresenter: MvpPresenter<ICatEditableView>() {

    fun saveCat(cat: Cat) {
        var catsApi = App.catsApi
        catsApi.saveCat(cat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { viewState.showMessage("Ok")
                            viewState.close() },
                        {viewState.showMessage(it.localizedMessage)
                            viewState.close()} )
    }

    fun loadCat(catId: Long) {
        App.catsApi.getCat(catId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { viewState.showCat(it) },
                        {viewState.showMessage(it.localizedMessage)})
    }

    fun updateCat(cat: Cat) {
        App.catsApi.updateCat(cat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            viewState.showMessage("Update")
                            viewState.close()},
                        {
                            viewState.showMessage("Error")
                            viewState.close()})

    }

    fun deleteCat(catId: Long) {
        App.catsApi.deleteCat(catId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            viewState.showMessage("Delete")
                            viewState.close()},
                        {
                            viewState.showMessage("Error")
                            viewState.close()}
                )
    }
}