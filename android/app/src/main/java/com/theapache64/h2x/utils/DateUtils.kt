package com.theapache64.h2x.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateUtils {

    /**
     * Sample  : Tuesday July 24, 2012
     */
    private val FORMAT_MONTH_DATE by lazy { SimpleDateFormat("MMMM dd", Locale.US) }


    fun getDatesBetween(_fromDate: Date, _toDate: Date): List<Calendar> {

        val fromDate = Calendar.getInstance().apply {
            time = _fromDate
        }

        val toDate = Calendar.getInstance().apply {
            time = _toDate
        }

        val dates = mutableListOf<Calendar>()
        while (!fromDate.after(toDate)) {
            val newCal = Calendar.getInstance().apply {
                time = fromDate.time
            }
            dates.add(newCal)
            fromDate.add(Calendar.DATE, 1)
        }
        return dates
    }

    fun formatDateAndMonth(date: Date): String {
        return FORMAT_MONTH_DATE.format(date)
    }

    fun getDaysDifference(fromDate: Date, toDate: Date): Long {
        val diff = toDate.time - fromDate.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1
    }
}