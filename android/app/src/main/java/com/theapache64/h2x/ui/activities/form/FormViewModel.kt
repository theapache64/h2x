package com.theapache64.h2x.ui.activities.form


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.theapache64.h2x.data.repositories.UserPrefRepository
import com.theapache64.h2x.models.FormItem
import javax.inject.Inject

class FormViewModel @Inject constructor(
    private val userPrefRepository: UserPrefRepository
) : ViewModel() {


    private val formItems = mutableListOf<FormItem>(
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
    fun onDeleteClicked(position: Int) {

    }

}