package com.theapache64.h2x.ui.activities.form


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.theapache64.h2x.R
import com.theapache64.h2x.data.repositories.UserPrefRepository
import com.theapache64.h2x.models.FormItem
import com.theapache64.twinkill.logger.info
import com.theapache64.twinkill.utils.livedata.SingleLiveEvent
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

    private val snackBarMessage = SingleLiveEvent<Int>()
    fun getSnackBarMessage(): LiveData<Int> = snackBarMessage

    /**
     * Add new form item and return it's position
     */
    fun addFormItem(): Int {
        val newItem = FormItem()
        formItems.add(newItem)
        return formItems.indexOf(newItem)
    }
}