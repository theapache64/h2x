package com.theapache64.h2x.models

import com.theapache64.h2x.utils.DateUtils
import java.io.Serializable
import java.util.*

class FormItem(
    var fromDate: Date? = null,
    var toDate: Date? = null,
    var projectName: String? = null
) : Serializable {

    fun getFromDateFormatted(): String? {
        return DateUtils.formatDateAndMonth(fromDate!!)
    }


    fun getToDateFormatted(): String? {
        return DateUtils.formatDateAndMonth(toDate!!)
    }

    fun getDaysCount(): String {
        if (fromDate != null && toDate != null) {
            val numOfDays = DateUtils.getDaysDifference(fromDate!!, toDate!!)
            return " - $numOfDays ${getDayOrDays(numOfDays)}"
        }
        return ""
    }

    companion object {
        private fun getDayOrDays(numOfDays: Long): String {
            return if (numOfDays == 1L) "day" else "days"
        }
    }


}