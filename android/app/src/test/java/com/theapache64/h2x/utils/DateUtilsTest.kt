package com.theapache64.h2x.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class DateUtilsTest {

    @Test
    fun getDatesBetween() {
        val fromDate = Calendar.getInstance().time
        val toDate = Calendar.getInstance().apply {
            add(Calendar.DATE, 10)
        }.time
        val dates = DateUtils.getDatesBetween(fromDate, toDate)
        dates.map {
            println("Date is ${it.time}")
        }
        assertEquals(10, dates.size)
    }
}