package com.theah64.h2x


import java.util.*

object SwipeRowUtils {

    private val MIN_THINKPALM_WORK_HOUR = 6f

    fun parseRows(swipeData: String, funPerc: Float): List<SwipeRow> {
        val swipeRows = ArrayList<SwipeRow>()
        val swipeRowStrings = swipeData.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (swipeRow in swipeRowStrings) {
            val sr = parseRow(swipeRow, funPerc)
            println(sr)
            swipeRows.add(sr)
        }
        return swipeRows
    }

    private fun parseRow(swipeRow: String, funPerc: Float): SwipeRow {
        val columns = swipeRow.split("\t".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (columns.size == 9) {

            //Sl.No	Requested Date	In Date	In Time	Out Date	Out Time	Worked Hours	Day Status	Temporary Card ID
            val slNo = nullIfInvalidOrThrow(columns[0])
            val requestedDate = convertToXPlannerDateFormat(nullIfInvalidOrThrow(columns[1]))
            val inDate = nullIfInvalid(columns[2])
            val inTime = nullIfInvalid(columns[3])
            val outDate = nullIfInvalid(columns[4])
            val outTime = nullIfInvalid(columns[5])
            val workedHours = nullIfInvalid(columns[6])
            val dayStatus = nullIfInvalidOrThrow(columns[7])
            val tempCardId = nullIfInvalid(columns[8])

            return SwipeRow(
                    slNo,
                    requestedDate,
                    dayStatus,
                    inDate,
                    inTime,
                    outDate,
                    outTime,
                    workedHours,
                    tempCardId,
                    funPerc
            )

        } else {
            throw IllegalArgumentException("Invalid swipe lab. Column name must be 9 but got " + columns.size)
        }
    }

    private fun convertToXPlannerDateFormat(_date: String): String {
        var date = _date
        date = date.replace("/".toRegex(), "-")
        val chunks = date.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val chunkList = Arrays.asList(*chunks)
        Collections.reverse(chunkList)
        return chunkList.joinToString("-")

    }

    private fun nullIfInvalidOrThrow(data: String?): String {
        var newData = data
        newData = nullIfInvalid(newData!!)
        if (newData == null) {
            throw IllegalArgumentException("Data shouldn't be null")
        }
        return newData
    }

    private fun nullIfInvalid(_data: String): String? {
        val data = _data.trim { it <= ' ' }
        return if (data == "-" || data == "--:--") {
            null
        } else data
    }

    internal fun calcWorkedHours(workedHours: String?): Float {

        if (workedHours == null) {
            return 0f
        }

        val chunks = workedHours.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

        if (chunks.size == 2) {

            val hours = Integer.parseInt(chunks[0].trim { it <= ' ' })
            val minutes = Integer.parseInt(chunks[1].trim { it <= ' ' })
            val minutesInPerc = if (minutes > 0) toMinutePerc(minutes) else 0

            return java.lang.Float.parseFloat("$hours.$minutesInPerc")

        } else {
            throw IllegalArgumentException("Worked hours time format in wrong format $workedHours")
        }
    }

    private fun toMinutePerc(minutes: Int): Int {
        val x = minutes / 60f
        return Math.round(x * 100)
    }

    internal fun calcFunHours(fWorkedHours: Float, _funPerc: Float): Float {
        var funPerc = _funPerc

        if (fWorkedHours < MIN_THINKPALM_WORK_HOUR) {
            // less time worked so throttling fun perc to 50%
            funPerc = funPerc - funPerc * 50 / 100
        }

        return fWorkedHours * funPerc / 100
    }
}
