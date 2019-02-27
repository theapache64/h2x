object H2X {
    const val KEY_XP_ID = "xp_id"
    const val KEY_SWIPE_DATA = "swipe_data"
    const val KEY_FUN_PERC = "fun_perc"

    fun getSwipeRows(
        xpId: String?,
        swipeData: String?,
        funPerc: String?
    ): List<SwipeRow>? {

        if (xpId == null || xpId.trim { it <= ' ' }.isEmpty() ||
            swipeData == null || swipeData.trim { it <= ' ' }.isEmpty() ||
            funPerc == null || funPerc.trim { it <= ' ' }.isEmpty()
        ) {
            return null
        }

        val funPercFloat = funPerc.toFloat()
        return SwipeRowUtils.parseRows(swipeData, funPercFloat)
    }
}
