package com.theapache64.h2x.ui.activities.payment

import androidx.databinding.ObservableFloat
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.theah64.safemail.SafeMail
import com.theapache64.h2x.data.remote.getprefs.GetPrefsRequest
import com.theapache64.h2x.data.remote.getprefs.Pref
import com.theapache64.h2x.data.repositories.ServerPrefRepository
import com.theapache64.h2x.data.repositories.UserPrefRepository
import com.theapache64.h2x.models.FormItem
import com.theapache64.h2x.utils.DateUtils
import com.theapache64.openupi.TransactionResult
import com.theapache64.twinkill.network.utils.Resource
import com.theapache64.twinkill.utils.livedata.SingleLiveEvent
import javax.inject.Inject
import kotlin.math.roundToInt

class PaymentViewModel @Inject constructor(
    private val serverPrefRepository: ServerPrefRepository,
    private val userPref: UserPrefRepository
) : ViewModel() {

    private lateinit var formItems: java.util.ArrayList<FormItem>
    var totalDays = ObservableInt(0)
    var totalSections = ObservableInt(0)
    var perDay = ObservableFloat(0f)
    var perSection = ObservableFloat(0f)
    var totalPayable = ObservableInt()

    fun init(
        formItems: ArrayList<FormItem>,
        pref: Pref
    ) {
        this.formItems = formItems

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

        this.totalPayable.set(total.roundToInt())
    }

    private val getPrefsRequest = MutableLiveData<GetPrefsRequest>()
    private val getPrefs = Transformations.switchMap(getPrefsRequest) {
        serverPrefRepository.getPrefs()
    }

    fun getPrefs() = getPrefs

    fun loadPrefs() {
        this.getPrefsRequest.value = GetPrefsRequest()
    }


    private val placeOrderResponse = SingleLiveEvent<Resource<Boolean>>()
    fun getPlaceOrderResponse() = placeOrderResponse


    fun placeOrder(transactionResult: TransactionResult) {

        val user = userPref.getUser()
        val msg = """
            Hey, 
            
            We got one order from ${user!!.email}. 
            
            Transaction Details:
            --------------------
            amount : ${transactionResult.amount}
            txnId : ${transactionResult.transactionId}
            txnRefId : ${transactionResult.transactionRefId}
            status : ${transactionResult.status}
            statusCode : ${transactionResult.statusCode}
            responseCode : ${transactionResult.responseCode}
            
            Order Details :
            ---------------
            ${genOrderDetails()}
        
        """.trimIndent().replace("\n", "<br/>")

        placeOrderResponse.value = Resource.loading()

        SafeMail.sendMail(
            "h2x.thinkpalm@gmail.com",
            "theapache64@gmail.com",
            "h2x Order!!",
            msg,
            object : SafeMail.SafeMailCallback {
                override fun onSuccess() {
                    placeOrderResponse.postValue(
                        Resource.success(true)
                    )
                }

                override fun onFailed(throwable: Throwable?) {
                    placeOrderResponse.postValue(
                        Resource.error(
                            throwable?.message
                                ?: "Something went wrong while placing order."
                        )
                    )
                }

            }
        )
    }

    private fun genOrderDetails(): String {
        val sb = StringBuilder()
        for (item in formItems) {
            sb.append(
                """
                    
                #####################################
                - from : ${item.getFromDateFormatted()}
                - to : ${item.getToDateFormatted()}
                - projectName : ${item.projectName}
                ######################################
                
            """.trimIndent()
            )
        }
        return sb.toString()
    }
}