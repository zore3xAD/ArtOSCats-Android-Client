package com.android.zore3x.artoscats.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.zore3x.artoscats.R
import com.android.zore3x.artoscats.model.Cat
import com.android.zore3x.artoscats.presenter.CatEditablePresenter
import com.android.zore3x.artoscats.view.ICatEditableView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_editable_cat.*

class EditableCatActivity : MvpAppCompatActivity(), ICatEditableView {
    override fun close() {
        finish()
    }

    override fun showCat(cat: Cat) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    @InjectPresenter
    lateinit var presenter: CatEditablePresenter

    companion object {
        fun getIntent(context: Context) = Intent(context, EditableCatActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editable_cat)


        editableSave_button.setOnClickListener { presenter.saveCat(
                Cat(editableCatName_editText.text.toString(),
                        editableCatAge_editText.text.toString().toInt())) }
    }
}
