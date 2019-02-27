import org.w3c.dom.*
import kotlin.browser.document

fun main() {

    println("Hello World")
    val firstPage = document.getElementById("firstPage") as HTMLDivElement
    val secondPage = document.getElementById("secondPage") as HTMLDivElement

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


    })

    secondPage.hidden = true
}