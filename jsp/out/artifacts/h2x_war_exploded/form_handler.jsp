<%@ page import="com.theah64.h2x.H2X" %>
<%@ page import="com.theah64.h2x.SwipeRow" %>
<%@ page import="java.util.List" %>
<%@ page import="com.theah64.h2x.CU" %><%--
  Created by IntelliJ IDEA.
  User: theapache64
  Date: 2/11/18
  Time: 9:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    final String xplannerId = request.getParameter(H2X.KEY_XP_ID).trim();

    final List<SwipeRow> swipeRows = H2X.getSwipeRows(
            response,
            xplannerId,
            request.getParameter(H2X.KEY_SWIPE_DATA),
            request.getParameter(H2X.KEY_FUN_PERC)
    );

    final StringBuilder dates = new StringBuilder();
%>
<html>
<head>
    <title>h2x</title>
    <jsp:include page="common_headers.jsp"/>
</head>
<body>
<jsp:include page="nav_bar.jsp"/>
<div class="container">

    <%--Table --%>

    <%--
        private final @NotNull String slNo;
    private final @NotNull String requestedDate;
    private final @NotNull String dayStatus;

    private final @Nullable String inDate;
    private final @Nullable String inTime;
    private final @Nullable String outDate;
    private final @Nullable String outTime;
    private final @Nullable String workedHours;
    private final @Nullable String temporaryCardId;
    private final float fWorkedHours;
    private final float fFunHours;
    private final float fNetWorkedHours;

    Sl.No	Requested Date	In Date	In Time	Out Date	Out Time	Worked Hours	Day Status	Temporary Card ID
    --%>
    <div class="row">

        <h4><b>Swipe Details</b></h4>

        <div class="col-md-12">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Sl.No.</th>
                    <th>Date.</th>
                    <th>In Date</th>
                    <th>In Time</th>
                    <th>Out Date</th>
                    <th>Out Time</th>
                    <th>Worked Hours</th>
                    <th>Fun%</th>
                    <th>Fun Hours</th>
                    <th>Net Worked Hours</th>
                    <th>Day Status</th>
                    <th>Temporary Card ID</th>
                </tr>
                </thead>
                <tbody>
                <%
                    float totalWorkedHours = 0;
                    float totalFunHours = 0;
                    float netWorkedHours = 0;
                    for (final SwipeRow swipeRow : swipeRows) {

                        if (swipeRow.getfNetWorkedHours() > 0) {
                            dates.append(String.format("{ \"date\": \"%s\", \"durs\": %s },", swipeRow.getRequestedDate(), swipeRow.getfNetWorkedHours()));
                        }

                        totalWorkedHours += swipeRow.getfWorkedHours();
                        totalFunHours += swipeRow.getfFunHours();
                        netWorkedHours += swipeRow.getfNetWorkedHours();


                %>
                <tr>
                    <td><%=CU.hyphenIfNull(swipeRow.getSlNo())%>
                    </td>
                    <td><%=CU.hyphenIfNull(swipeRow.getRequestedDate())%>
                    </td>
                    <td><%=CU.hyphenIfNull(swipeRow.getInDate())%>
                    </td>
                    <td><%=CU.hyphenIfNull(swipeRow.getInTime())%>
                    </td>
                    <td><%=CU.hyphenIfNull(swipeRow.getOutDate())%>
                    </td>
                    <td><%=CU.hyphenIfNull(swipeRow.getOutTime())%>
                    </td>
                    <td><%=CU.hyphenIfNull(swipeRow.getWorkedHours())%>
                    </td>
                    <td><%=swipeRow.getFunPerc() + "%"%>
                    </td>
                    <td><%=swipeRow.getfFunHours()%>
                    </td>
                    <td><%=swipeRow.getfNetWorkedHours() %>
                    </td>
                    <td><%=CU.hyphenIfNull(swipeRow.getDayStatus())%>
                    </td>
                    <td><%=CU.hyphenIfNull(swipeRow.getTemporaryCardId())%>
                    </td>
                </tr>
                <%
                    }


                %>
                </tbody>
            </table>


        </div>
    </div>

    <%--Stat--%>
    <div class="row">
        <div class="col-sm-offset-8 col-sm-4">
            <div class="pull-right">
                <p> Total Worked Hours: <b><%=totalWorkedHours%>
                </b></p>
                <p> Total Fun Hours: <b><%=totalFunHours%>
                </b></p>
                <p> Net Worked Hours: <b><%=netWorkedHours%>
                </b></p>
            </div>
        </div>
    </div>

    <%--Script --%>
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="taScript" class="control-label">Add Script: </label>
                    <textarea class="form-control" rows="20" id="taScript">
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
    var dateAndDurs = [ <%=dates.toString()%>];


    // find second last row
    var secondLastRow = $("form[name='timelog'] div#editObject table tbody tr:last").prev();

    // my id
    var myXPlannerID = <%=xplannerId%>;

    // Selecting user
    $(secondLastRow).find(":nth-child(6) select").val(myXPlannerID);


    // looping through
    $(dateAndDurs).each(function (index, item) {

        // Set date
        $(secondLastRow).find(":nth-child(3) input").val(item.date);

        // Set duration
        $(secondLastRow).find(":nth-child(4) input").val(item.durs);

        console.log('Submitting with ', item);

        // submit
        $("input[name='submit']").click();

    });

    location.reload();


}
                    </textarea>
                </div>
            </form>
        </div>
    </div>

    <%--Delete script--%>
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="dScript" class="control-label">Delete Script: </label>
                    <textarea class="form-control" rows="20" id="dScript">

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
    <%=dates.toString()%>
  ];

    // my id
    var myXPlannerID = <%=xplannerId%>;;


    $("form[name='timelog'] div#editObject table tbody tr").each(function (index, item) {

        var iReportedDate = $(item).find('td:nth-child(3) input');
                        var iPerson1 = $(item).find('td:nth-child(6) select');

        var repDate = $(iReportedDate).val();
                        var personId = parseInt($(iPerson1).val());

        // looping each date
        $(dateAndDurs).each(function (index, item2) {
            if (repDate === item2.date && personId=== myXPlannerID) {
                $(item).find("input[type='checkbox']").attr('checked', true);
            }
        });


    });

    // submit
    $("input[name='submit']").click();


}</textarea>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
