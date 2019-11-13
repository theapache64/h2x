class SwipeRow(
        val slNo: String,
        val requestedDate: String,
        val dayStatus: String,
        val inDate: String?,
        val inTime: String?,
        val outDate: String?,
        val outTime: String?,
        val workedHours: String?,
        val temporaryCardId: String?,
        funPerc: Float
) {
    private val fWorkedHours: Float = SwipeRowUtils.calcWorkedHours(workedHours)
    private val fFunHours: Float
    private val fNetWorkedHours: Float
    val funPerc: Float = if (inDate == null && outDate == null) 0F else funPerc


    init {
        this.fFunHours = SwipeRowUtils.calcFunHours(fWorkedHours, this.funPerc)
        this.fNetWorkedHours = fWorkedHours - fFunHours
    }

    fun getfWorkedHours(): Float {
        return fWorkedHours
    }

    fun getfFunHours(): Float {
        return fFunHours
    }

    fun getfNetWorkedHours(): Float {
        return fNetWorkedHours
    }

    override fun toString(): String {
        return "SwipeRow{" +
                "slNo='" + slNo + '\''.toString() +
                ", requestedDate='" + requestedDate + '\''.toString() +
                ", dayStatus='" + dayStatus + '\''.toString() +
                ", inDate='" + inDate + '\''.toString() +
                ", inTime='" + inTime + '\''.toString() +
                ", outDate='" + outDate + '\''.toString() +
                ", outTime='" + outTime + '\''.toString() +
                ", workedHours='" + workedHours + '\''.toString() +
                ", temporaryCardId='" + temporaryCardId + '\''.toString() +
                ", fWorkedHours=" + fWorkedHours +
                ", fFunHours=" + fFunHours +
                ", fNetWorkedHours=" + fNetWorkedHours +
                '}'.toString()
    }
}
