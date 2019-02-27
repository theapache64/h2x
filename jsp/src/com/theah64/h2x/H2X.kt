package com.theah64.h2x

import java.io.IOException
import javax.servlet.http.HttpServletResponse

object H2X {
    const val KEY_XP_ID = "xp_id"
    const val KEY_SWIPE_DATA = "swipe_data"
    const val KEY_FUN_PERC = "fun_perc"

    @Throws(IOException::class)
    @JvmStatic
    fun getSwipeRows(response: HttpServletResponse, xpId: String?, swipeData: String?, funPerc: String?): List<SwipeRow>? {

        if (xpId == null || xpId.trim { it <= ' ' }.isEmpty() ||
                swipeData == null || swipeData.trim { it <= ' ' }.isEmpty() ||
                funPerc == null || funPerc.trim { it <= ' ' }.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters")
            return null
        }

        val funPercFloat = java.lang.Float.parseFloat(funPerc)
        return SwipeRowUtils.parseRows(swipeData, funPercFloat)
    }
}
