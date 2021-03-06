package com.android.zore3x.artoscats.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.android.zore3x.artoscats.R
import com.android.zore3x.artoscats.model.Cat
import com.android.zore3x.artoscats.presenter.CatEditablePresenter
import com.android.zore3x.artoscats.view.ICatEditableView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_editable_cat.*

class EditableCatActivity : MvpAppCompatActivity(), ICatEditableView {

    var catId: Long = -1
    @InjectPresenter
    lateinit var presenter: CatEditablePresenter

    var isEditable = false
    companion object {
        val EXTRA_CAT_ID = "com.android.zore3x.artoscats.extra_cat_id"
        fun getIntent(context: Context) = Intent(context, EditableCatActivity::class.java)
        fun getIntent(context: Context, catId: Long): Intent {
            val intent = Intent(context, EditableCatActivity::class.java)
            intent.putExtra(EXTRA_CAT_ID, catId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editable_cat)

        if(intent.hasExtra(EXTRA_CAT_ID)) {
            isEditable = true
            catId = intent.getLongExtra(EXTRA_CAT_ID, -1)
            presenter.loadCat(catId)
        }

        editableSave_button.setOnClickListener {
            if (!isEditable) {
                presenter.saveCat(
                        Cat(editableCatName_editText.text.toString(),
                                editableCatAge_editText.text.toString().toInt()))
            } else {
                presenter.updateCat(Cat(catId,
                        editableCatName_editText.text.toString(),
                        editableCatAge_editText.text.toString().toInt()))
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_editable, menu)
        if(isEditable) {
            menu?.findItem(R.id.action_delete)?.isVisible = true
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.action_delete) {
            presenter.deleteCat(catId)
        }
        return super.onOptionsItemSelected(item)
    }

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
}
