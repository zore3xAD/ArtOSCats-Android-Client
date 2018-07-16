package com.android.zore3x.artoscats.activity

import android.opengl.Visibility
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.android.zore3x.artoscats.R
import com.android.zore3x.artoscats.adapter.CatAdapter
import com.android.zore3x.artoscats.model.Cat
import com.android.zore3x.artoscats.presenter.CatsListPresenter
import com.android.zore3x.artoscats.view.ICatListView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

import kotlinx.android.synthetic.main.activity_cats_list.*
import kotlinx.android.synthetic.main.content_cats_list.*

class CatsListActivity : MvpAppCompatActivity(), ICatListView {

    @InjectPresenter
    lateinit var presenter: CatsListPresenter

    private val adapter: CatAdapter = CatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cats_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            startActivity(EditableCatActivity.getIntent(applicationContext))
        }
        adapter.setOnClickListener(object : CatAdapter.CatClickListener {
            override fun OnClick(view: View, position: Int) {
                startActivity(EditableCatActivity.getIntent(applicationContext, position))
            }
        })
        catList_recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        catList_recyclerView.adapter = adapter

    }

    override fun onStart() {
        super.onStart()
        presenter.loadData()
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun showCats(data: MutableList<Cat>) {
        adapter.data = data
    }

    override fun showProgress() {
        progressBar.visibility = VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = GONE
    }
}
