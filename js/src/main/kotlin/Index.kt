import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.js.tr
import kotlinx.html.td
import org.w3c.dom.*
import kotlin.browser.document

fun main() {

    println("Hello World")
    val firstPage = document.getElementById("firstPage") as HTMLDivElement
    val secondPage = document.getElementById("secondPage") as HTMLDivElement

    firstPage.hidden = false
    secondPage.hidden = true

    // First page
    val iXpId = document.getElementById("xp_id") as HTMLInputElement
    val iFunPerc = document.getElementById("fun_perc") as HTMLInputElement
    val taSwipeData = document.getElementById("swipe_data") as HTMLTextAreaElement

    val fh2x = document.getElementById("fh2x") as HTMLFormElement
    fh2x.addEventListener("submit", {

        // Getting data
        val xpId = iXpId.value
        val funPerc = iFunPerc.value
        val swipeData = taSwipeData.value

        console.log(
            """
            XPID: $xpId
            funPerc : $funPerc
            swipeData : $swipeData
        """.trimIndent()
        )

        // Preventing form submission
        it.preventDefault()

        firstPage.hidden = true
        secondPage.hidden = false

        val swipeRows = H2X.getSwipeRows(xpId, swipeData, funPerc)
        val dates = StringBuilder()

        swipeRows?.let { rows ->

            val tbSwipeRows = document.getElementById("tbSwipeDetails")

            var totalWorkedHours = 0f
            var totalFunHours = 0f
            var netWorkedHours = 0f

            for (swipeRow in rows) {

                if (swipeRow.getfNetWorkedHours() > 0) {
                    dates.append("{ \"date\": \"${swipeRow.requestedDate}\", \"durs\": ${swipeRow.getfNetWorkedHours()} },");
                }

                totalWorkedHours += swipeRow.getfWorkedHours();
                totalFunHours += swipeRow.getfFunHours();
                netWorkedHours += swipeRow.getfNetWorkedHours();

                val tr = document.create.tr {
                    td { +CU.hyphenIfNull(swipeRow.slNo) }
                    td { +CU.hyphenIfNull(swipeRow.requestedDate) }
                    td { +CU.hyphenIfNull(swipeRow.inDate) }
                    td { +CU.hyphenIfNull(swipeRow.inTime) }
                    td { +CU.hyphenIfNull(swipeRow.outDate) }
                    td { +CU.hyphenIfNull(swipeRow.outTime) }
                    td { +CU.hyphenIfNull(swipeRow.workedHours) }
                    td { +"${swipeRow.funPerc}%" }
                    td { +swipeRow.getfFunHours() }
                    td { +swipeRow.getfNetWorkedHours() }
                    td { +CU.hyphenIfNull(swipeRow.dayStatus) }
                    td { +CU.hyphenIfNull(swipeRow.temporaryCardId) }
                }

                tbSwipeRows!!.appendChild(tr)
            }
        }


    })

}