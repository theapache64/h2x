package com.theapache64.h2x.ui.activities.form


import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.theapache64.h2x.R
import com.theapache64.h2x.data.repositories.UserPrefRepository
import com.theapache64.h2x.models.FormItem
import com.theapache64.h2x.utils.DateUtils.getDatesBetween
import com.theapache64.twinkill.logger.info
import com.theapache64.twinkill.utils.livedata.SingleLiveEvent
import java.util.*
import javax.inject.Inject

class FormViewModel @Inject constructor(
    private val userPrefRepository: UserPrefRepository
) : ViewModel() {


    private val formItems = mutableListOf(
        FormItem()
    )
    private val isLoggedOut = MutableLiveData<Boolean>()
    fun getLoggedOut(): LiveData<Boolean> = isLoggedOut

    /**
     * Clears preference and logout user
     */
    fun logout() {
        userPrefRepository.clearUser()
        isLoggedOut.value = true
    }

    fun getFormItems(): List<FormItem> = formItems

    /**
     * Delete item from form items. Returns false if failed.
     */
    fun onDeleteClicked(position: Int): Boolean {
        info("Deleted")
        if (formItems.size == 1) {
            snackBarMessage.value = R.string.error_delete_form_item_empty
            return false
        }


        formItems.removeAt(position)
        return true
    }

    private val snackBarMessage = SingleLiveEvent<Any>()
    fun getSnackBarMessage(): LiveData<Any> = snackBarMessage

    /**
     * Add new form item and return it's position
     */
    fun addFormItem(): Int {

        // Checking if all other form items field are filled
        return if (isAllItemsAreValid()) {
            val newItem = FormItem()
            formItems.add(newItem)
            formItems.indexOf(newItem)
        } else {
            -1
        }
    }

    fun isAllItemsAreValid(): Boolean {
        for (itemWithIndex in formItems.withIndex()) {
            val item = itemWithIndex.value
            if (item.fromDate == null || item.toDate == null || item.projectName.isNullOrBlank()) {
                snackBarMessage.value = "Please fill #${itemWithIndex.index + 1} first"
                return false
            }
        }
        return true
    }

    fun getDisabledDays(position: Int): List<Calendar> {
        val dates = mutableListOf<Calendar>()
        for (item in formItems.withIndex()) {
            // not selecting current one
            if (item.index != position) {
                val formItem = item.value
                val dateRange = getDatesBetween(formItem.fromDate!!, formItem.toDate!!)
                dates.addAll(dateRange)
            }
        }
        return dates
    }

    fun setFromDate(position: Int, pickedDate: Date) {
        this.formItems[position].fromDate = pickedDate
    }

    fun setToDate(position: Int, pickedDate: Date) {
        this.formItems[position].toDate = pickedDate
    }

    fun isFromDateSet(position: Int): Boolean {
        return formItems[position].fromDate != null
    }

    fun setSnackBarMessage(@StringRes message: Int) {
        snackBarMessage.value = message
    }

    fun getFromDate(position: Int): Calendar {
        return Calendar.getInstance().apply {
            time = formItems[position].fromDate!!
        }
    }


}