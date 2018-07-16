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
        editableCatAge_editText.setText(cat.age.toString())
        editableCatName_editText.setText(cat.name)
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    @InjectPresenter
    lateinit var presenter: CatEditablePresenter

    companion object {
        val EXTRA_CAT_ID = "com.android.zore3x.artoscats.extra_cat_id"
        fun getIntent(context: Context) = Intent(context, EditableCatActivity::class.java)
        fun getIntent(context: Context, catId: Int): Intent {
            val intent = Intent(context, EditableCatActivity::class.java)
            intent.putExtra(EXTRA_CAT_ID, catId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editable_cat)

        if(intent.hasExtra(EXTRA_CAT_ID)) {
            presenter.loadCat(intent.getIntExtra(EXTRA_CAT_ID, -1))
        }

        editableSave_button.setOnClickListener { presenter.saveCat(
                Cat(editableCatName_editText.text.toString(),
                        editableCatAge_editText.text.toString().toInt())) }
    }
}
