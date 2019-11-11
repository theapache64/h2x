import kotlinx.html.dom.create
import kotlinx.html.js.div
import kotlinx.html.js.tr
import kotlinx.html.td
import org.w3c.dom.*
import kotlin.browser.document
import kotlin.browser.window

fun main() {

    println("Hello World")
    val firstPage = document.getElementById("firstPage") as HTMLDivElement
    val secondPage = document.getElementById("secondPage") as HTMLDivElement

    firstPage.hidden = false
    secondPage.hidden = true

    // Setting home click listener
    val aHome = document.getElementById("aHome") as HTMLAnchorElement
    aHome.addEventListener("click", {
        firstPage.hidden = false
        secondPage.hidden = true
    })

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


        try {

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
                        td { +"${swipeRow.getfFunHours()}" }
                        td { +"${swipeRow.getfNetWorkedHours()}" }
                        td { +CU.hyphenIfNull(swipeRow.dayStatus) }
                        td { +CU.hyphenIfNull(swipeRow.temporaryCardId) }
                    }

                    tbSwipeRows!!.appendChild(tr)
                }

                // Stats
                document.getElementById("pTotalWorkedHours")!!.innerHTML =
                        "Total Worked Hours: <b>$totalWorkedHours</b>"
                document.getElementById("pTotalFunHours")!!.innerHTML = "Total Fun Hours: <b>$totalFunHours</b>"
                document.getElementById("pNetWorkedHours")!!.innerHTML = "Net Worked Hours: <b>$netWorkedHours</b>"

                // Final script
                (document.getElementById("taScript") as HTMLTextAreaElement).value =
                        getAddScript(dates.toString(), xpId)

                (document.getElementById("dScript") as HTMLTextAreaElement).value =
                        getDeleteScript(dates.toString(), xpId)

                // at last showing page two
                firstPage.hidden = true
                secondPage.hidden = false
            }

        } catch (e: IllegalArgumentException) {
            window.alert(e.message!!)
        }


    })

}

fun getDeleteScript(dates: String, xpId: String): String {
    return """
        // load jquery

var myForm = document.getElementsByName('timelog')[0];
myForm.onsubmit = function () {
    var popUpId = 'PopUp' + Math.random();
    var w = window.open('', popUpId, 'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0,width=400,height=300,left = 312,top = 234');
    this.target = popUpId;
};


var jq = document.createElement('script');
jq.src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js";
document.getElementsByTagName('head')[0].appendChild(jq);

var key = setInterval(function () {
    if (jq) {
        start();
        clearInterval(key);
    }
}, 1000);


function start() {

      // date and duration
  var dateAndDurs = [
    $dates
  ];

    // my id
    var myXPlannerID = $xpId


    ${'$'}("form[name='timelog'] div#editObject table tbody tr").each(function (index, item) {

        var iReportedDate = ${'$'}(item).find('td:nth-child(3) input');
                        var iPerson1 = ${'$'}(item).find('td:nth-child(6) select');

        var repDate = ${'$'}(iReportedDate).val();
                        var personId = parseInt(${'$'}(iPerson1).val());

        // looping each date
        ${'$'}(dateAndDurs).each(function (index, item2) {
            if (repDate === item2.date && personId=== myXPlannerID) {
                ${'$'}(item).find("input[type='checkbox']").attr('checked', true);
            }
        });


    });

    // submit
    ${'$'}("input[name='submit']").click();


}
    """
}

fun getAddScript(dates: String, xpId: String): String {
    return """
        // load jquery
var myForm = document.getElementsByName('timelog')[0];
myForm.onsubmit = function () {
    var popUpId = 'PopUp' + Math.random();
    var w = window.open('', popUpId, 'toolbar=0,scrollbars=0,location=0,statusbar=0,menubar=0,resizable=0,width=400,height=300,left = 312,top = 234');
    this.target = popUpId;
};


var jq = document.createElement('script');
jq.src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js";
document.getElementsByTagName('head')[0].appendChild(jq);

var key = setInterval(function () {
    if (jq) {
        start();
        clearInterval(key);
    }
}, 1000);


function start() {

    // date and duration
    var dateAndDurs = [ ${dates}];


    // find second last row
    var secondLastRow = ${'$'}("form[name='timelog'] div#editObject table tbody tr:last").prev();

    // my id
    var myXPlannerID = ${xpId};

    // Selecting user
    ${'$'}(secondLastRow).find(":nth-child(6) select").val(myXPlannerID);


    // looping through
    ${'$'}(dateAndDurs).each(function (index, item) {

        // Set date
        ${'$'}(secondLastRow).find(":nth-child(3) input").val(item.date);

        // Set duration
        ${'$'}(secondLastRow).find(":nth-child(4) input").val(item.durs);

        console.log('Submitting with ', item);

        // submit
        ${'$'}("input[name='submit']").click();

    });

    location.reload();


}

    """
}