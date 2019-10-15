package com.theapache64.h2x.ui.activities.payment

import androidx.databinding.ObservableFloat
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.theapache64.h2x.data.remote.getprefs.GetPrefsRequest
import com.theapache64.h2x.data.remote.getprefs.Pref
import com.theapache64.h2x.data.repositories.ServerPrefRepository
import com.theapache64.h2x.models.FormItem
import com.theapache64.h2x.utils.DateUtils
import javax.inject.Inject

class PaymentViewModel @Inject constructor(
    private val serverPrefRepository: ServerPrefRepository
) : ViewModel() {

    var totalDays = ObservableInt(0)
    var totalSections = ObservableInt(0)
    var perDay = ObservableFloat(0f)
    var perSection = ObservableFloat(0f)
    var totalPayable = ObservableFloat()

    fun init(
        formItems: ArrayList<FormItem>,
        pref: Pref
    ) {

        // Sections
        this.totalSections.set(formItems.size)
        var totalDays = 0L
        for (formItem in formItems) {
            val formTotalDays = DateUtils.getDaysDifference(formItem.fromDate!!, formItem.toDate!!)
            totalDays += formTotalDays
        }

        // Total days
        this.totalDays.set(totalDays.toInt())

        // Per day
        this.perDay.set(pref.perDay)
        this.perSection.set(pref.perSection)

        val total =
            (this.totalDays.get() * this.perDay.get()) + (this.totalSections.get() * this.perSection.get())

        this.totalPayable.set(total)
    }

    private val getPrefsRequest = MutableLiveData<GetPrefsRequest>()
    private val getPrefs = Transformations.switchMap(getPrefsRequest) {
        serverPrefRepository.getPrefs()
    }

    fun getPrefs() = getPrefs

    fun loadPrefs() {
        this.getPrefsRequest.value = GetPrefsRequest()
    }
}