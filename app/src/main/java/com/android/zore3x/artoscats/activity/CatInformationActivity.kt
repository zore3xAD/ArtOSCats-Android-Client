package com.android.zore3x.artoscats.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.zore3x.artoscats.R
import com.android.zore3x.artoscats.model.Cat
import com.android.zore3x.artoscats.presenter.CatInformationPresenter
import com.android.zore3x.artoscats.view.ICatInformationView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_cat_information.*

class CatInformationActivity : MvpAppCompatActivity(), ICatInformationView {

    @InjectPresenter
    lateinit var presenter: CatInformationPresenter

    companion object {
        val EXTRA_CAT_ID = "com.android.zore3x.artoscats.activity.extra_cat_id"

        fun getIntent(packageContext: Context, catId: Int): Intent {
            var intent = Intent(packageContext, CatInformationActivity::class.java)
            intent.putExtra(EXTRA_CAT_ID, catId)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_information)

        presenter.getCat(intent.getIntExtra(EXTRA_CAT_ID, -1))
    }

    override fun showCatInformation(cat: Cat) {
        informationCatName_textView.text = cat.name
        informationCatAge_textView.text = cat.age.toString()
    }

    override fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
