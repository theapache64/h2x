package com.theapache64.h2x.ui.activities.payment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.theapache64.h2x.R
import com.theapache64.h2x.databinding.ActivityPaymentBinding
import com.theapache64.h2x.models.FormItem
import com.theapache64.twinkill.network.utils.Resource
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import dagger.android.AndroidInjection
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class PaymentActivity : BaseAppCompatActivity(), PaymentHandler {

    companion object {

        private const val KEY_FORM_ITEMS = "form_items"

        fun getStartIntent(
            context: Context,
            formItems: ArrayList<FormItem>
        ): Intent {
            return Intent(context, PaymentActivity::class.java).apply {
                // data goes here
                putExtra(KEY_FORM_ITEMS, formItems)
            }
        }
    }


    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var binding: ActivityPaymentBinding
    private lateinit var viewModel: PaymentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        binding = bindContentView(R.layout.activity_payment)
        setSupportActionBar(binding.toolbar)
        viewModel = ViewModelProviders.of(this, factory).get(PaymentViewModel::class.java)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.handler = this
        binding.viewModel = viewModel

        val formItems = intent.getSerializableExtra(KEY_FORM_ITEMS) as ArrayList<FormItem>

        viewModel.getPrefs().observe(this, Observer {
            val iContentPayment = binding.iContentPayment
            when (it.status) {
                Resource.Status.LOADING -> {
                    iContentPayment.mcvPayment.visibility = View.GONE
                    iContentPayment.lvPrefs.showLoading(R.string.loading)
                }
                Resource.Status.SUCCESS -> {

                    iContentPayment.mcvPayment.visibility = View.VISIBLE
                    iContentPayment.lvPrefs.hideLoading()


                    viewModel.init(formItems, it.data!!.first())
                }
                Resource.Status.ERROR -> {
                    iContentPayment.mcvPayment.visibility = View.GONE
                    iContentPayment.lvPrefs.showError(it.message!!)
                }
            }
        })


        viewModel.loadPrefs()
    }

    override fun onPayClicked() {

    }
}



