package com.theapache64.h2x.ui.activities.form

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.theapache64.h2x.R
import com.theapache64.h2x.databinding.ActivityFormBinding
import com.theapache64.h2x.ui.activities.login.LogInActivity
import com.theapache64.h2x.ui.adapters.formitems.FormItemsAdapter
import com.theapache64.h2x.ui.adapters.formitems.FormItemsCallback
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import dagger.android.AndroidInjection
import javax.inject.Inject

class FormActivity : BaseAppCompatActivity(), FormHandler, FormItemsCallback {


    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var viewModel: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        val binding = bindContentView<ActivityFormBinding>(R.layout.activity_form)
        setSupportActionBar(binding.toolbar)

        this.viewModel = ViewModelProviders.of(this, factory).get(FormViewModel::class.java)
        binding.viewModel = viewModel
        binding.handler = this

        val formItemsAdapter = FormItemsAdapter(
            this,
            viewModel.getFormItems()
            , this
        )

        binding.iContentForm.rvFormItems.adapter = formItemsAdapter


        // Watching logout
        viewModel.getLoggedOut().observe(this, Observer { isLoggedOut ->

            if (isLoggedOut) {
                startActivity(LogInActivity.getStartIntent(this))
                finish()
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_form, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_logout -> {

                val dialog =
                    getConfirmDialog(R.string.title_confirm, R.string.message_logout_confirm) {
                        viewModel.logout()
                    }

                dialog.show()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDeleteClicked(position: Int) {
        viewModel.onDeleteClicked(position)
    }

    override fun onSetFromDateClicked(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSetToDateClicked(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        const val ID = R.id.MAIN_ACTIVITY_ID

        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, FormActivity::class.java)
            return intent
        }
    }
}
