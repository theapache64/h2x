package com.theapache64.h2x.ui.activities.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.theapache64.h2x.R
import com.theapache64.h2x.databinding.ActivityLogInBinding
import com.theapache64.h2x.ui.activities.form.FormActivity
import com.theapache64.twinkill.network.utils.Resource
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import com.theapache64.twinkill.utils.extensions.toast
import dagger.android.AndroidInjection
import javax.inject.Inject

class LogInActivity : BaseAppCompatActivity(), LogInHandler {


    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var viewModel: LogInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        // binding
        val binding = bindContentView<ActivityLogInBinding>(R.layout.activity_log_in)

        // hides progress for the first time
        binding.clpbLogin.hide()

        // getting viewModel
        this.viewModel = ViewModelProviders.of(this, factory).get(LogInViewModel::class.java)

        // binding viewModel and clickHandler to layout
        binding.viewModel = viewModel
        binding.handler = this

        // watching for getUser
        viewModel.getUser().observe(this, Observer {

            Log.e("X", "Status is ${it.status}")

            when (it.status) {

                Resource.Status.LOADING -> {
                    // showing progress
                    binding.clpbLogin.show()
                }

                Resource.Status.SUCCESS -> {
                    // hide loading
                    binding.clpbLogin.hide()

                    // staring main activity
                    startActivity(FormActivity.getStartIntent(this))
                    finish()
                }

                Resource.Status.ERROR -> {
                    // hide loading
                    binding.clpbLogin.hide()

                    toast(it.message!!)
                }
            }
        })

    }

    override fun onLogInClicked() {
        viewModel.doLogIn()
    }

    companion object {
        const val ID = R.id.LOG_IN_ACTIVITY_ID

        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, LogInActivity::class.java)
            return intent
        }
    }
}
