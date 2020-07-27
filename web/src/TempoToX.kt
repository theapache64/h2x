/**
 * Created by theapache64 : Jul 27 Mon,2020 @ 19:09
 */
object TempoToX {
    fun getSwipeRows(swipeData: String): List<SwipeRow> {
        val csvLines = swipeData.split("\"\n")
        val dateMap = mutableMapOf<String, Float>()
        for (i in 1 until csvLines.size) {
            val csvRow = csvLines[i]
            val csvColumns = csvRow.split("\",\"")
            println(csvColumns)
            val hour = csvColumns[2].trim().toFloat()
            val workDate = csvColumns[3].split(" ")[0].trim()
            dateMap[workDate] = if (dateMap[workDate] == null) {
                hour
            } else {
                dateMap[workDate]!! + hour
            }
        }
        var index = 1
        return dateMap.map {
            SwipeRow(
                    SOURCE_TEMPO,
                    "${index++}",
                    it.key,
                    "Present",
                    it.key,
                    "00:00",
                    it.key,
                    "00:00",
                    it.value.toString(),
                    null,
                    0f
            )
        }
    }


}