package com.theapache64.h2x.ui.activities.form

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.theapache64.h2x.R
import com.theapache64.h2x.databinding.ActivityFormBinding
import com.theapache64.h2x.ui.activities.login.LogInActivity
import com.theapache64.h2x.ui.activities.payment.PaymentActivity
import com.theapache64.h2x.ui.adapters.formitems.FormItemsAdapter
import com.theapache64.h2x.ui.adapters.formitems.FormItemsCallback
import com.theapache64.twinkill.ui.activities.base.BaseAppCompatActivity
import com.theapache64.twinkill.utils.extensions.bindContentView
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import dagger.android.AndroidInjection
import java.util.*
import javax.inject.Inject

class FormActivity : BaseAppCompatActivity(), FormHandler, FormItemsCallback {


    private lateinit var binding: ActivityFormBinding
    private lateinit var formItemsAdapter: FormItemsAdapter
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var viewModel: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        this.binding = bindContentView(R.layout.activity_form)
        setSupportActionBar(binding.toolbar)

        this.viewModel = ViewModelProviders.of(this, factory).get(FormViewModel::class.java)
        binding.viewModel = viewModel
        binding.handler = this

        this.formItemsAdapter = FormItemsAdapter(
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

        // Watching for any SnackBar error
        viewModel.getSnackBarMessage().observe(this, Observer {
            when (it) {
                is String -> {

                    Snackbar.make(
                        binding.iContentForm.bNext,
                        it,
                        Snackbar.LENGTH_LONG
                    )
                        .show()
                }
                is Int -> {

                    Snackbar.make(binding.iContentForm.bNext, it, Snackbar.LENGTH_LONG)
                        .show()
                }

                else -> throw IllegalArgumentException("TSH : Snackbar message type should be either String or Int")
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

            R.id.action_add_form_item -> {
                val newItemPosition = viewModel.addFormItem()
                if (newItemPosition != -1) {
                    formItemsAdapter.notifyDataSetChanged()
                    binding.iContentForm.rvFormItems.scrollToPosition(newItemPosition)
                }
                true
            }


            else -> super.onOptionsItemSelected(item)
        }


    }

    override fun onDeleteClicked(position: Int) {
        if (viewModel.onDeleteClicked(position)) {
            // Deleted
            formItemsAdapter.notifyDataSetChanged()
        }
    }

    override fun onSetFromDateClicked(position: Int) {

        showDatePicker(position) { pickedDate ->
            viewModel.setFromDate(position, pickedDate)
            formItemsAdapter.notifyItemChanged(position)
        }

    }


    override fun onSetToDateClicked(position: Int) {
        if (viewModel.isFromDateSet(position)) {
            val fromDate = viewModel.getFromDate(position)
            showDatePicker(position, fromDate) { pickedDate ->
                viewModel.setToDate(position, pickedDate)
                formItemsAdapter.notifyItemChanged(position)
            }
        } else {
            viewModel.setSnackBarMessage(R.string.error_date_from_first)
        }
    }

    private fun showDatePicker(position: Int, minDate: Calendar? = null, callback: (Date) -> Unit) {

        val onDatePicked: (DatePickerDialog, Int, Int, Int) -> Unit =
            { _, year, monthOfYear, dayOfMonth ->
                val pickedDate = Calendar.getInstance().apply {
                    set(Calendar.YEAR, year)
                    set(Calendar.MONTH, monthOfYear)
                    set(Calendar.DAY_OF_MONTH, dayOfMonth)
                }.time

                callback(pickedDate)

            }

        val dpd = if (minDate == null) {
            DatePickerDialog.newInstance(onDatePicked)
        } else {
            DatePickerDialog.newInstance(onDatePicked, minDate).apply {
                this.minDate = minDate
            }
        }


        dpd.maxDate = Calendar.getInstance()
        dpd.disabledDays = viewModel.getDisabledDays(position).toTypedArray()
        dpd.show(supportFragmentManager, null)
    }

    override fun onNextClicked() {
        if (viewModel.isAllItemsAreValid()) {
            startActivity(
                PaymentActivity.getStartIntent(this, ArrayList(viewModel.getFormItems()))
            )
        }
    }


    companion object {
        const val ID = R.id.MAIN_ACTIVITY_ID

        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, FormActivity::class.java)
            return intent
        }
    }
}
