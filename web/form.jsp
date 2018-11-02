<%@ page import="com.theah64.h2x.H2X" %><%--
  Created by IntelliJ IDEA.
  User: theapache64
  Date: 2/11/18
  Time: 9:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>


    <title>h2x</title>
    <jsp:include page="common_headers.jsp"/>
</head>
<body>

<jsp:include page="nav_bar.jsp"/>

<div class="container">
    <div class="row">
        <%--Form --%>
        <div class="col-sm-8">

            <form method="POST" class="form-horizontal" target="_blank" action="form_handler.jsp">

                <%--XPlannerID--%>
                <div class="form-group">
                    <label class="control-label col-sm-3" for="<%=H2X.KEY_XP_ID%>">XPlannerID:</label>
                    <div class="col-sm-9">

                        <input name="<%=H2X.KEY_XP_ID%>"
                               type="number"
                               class="form-control"
                               id="<%=H2X.KEY_XP_ID%>"
                               placeholder="Enter your XPlannerID here"
                               required>

                    </div>
                </div>

                <%--Percentage of fun--%>
                <div class="form-group">
                    <label class="control-label col-sm-3" for="<%=H2X.KEY_FUN_PERC%>">Fun Percentage: </label>
                    <div class="col-sm-9">

                        <input name="<%=H2X.KEY_FUN_PERC%>"
                               type="number"
                               class="form-control"
                               id="<%=H2X.KEY_FUN_PERC%>"
                               placeholder="Enter percentage of fun you had on each day"
                               value="8.5"
                               required>

                    </div>
                </div>

                <%--Swipe data--%>
                <div class="form-group">

                    <label
                            class="control-label col-sm-3"
                            for="<%=H2X.KEY_SWIPE_DATA%>">
                        Swipe Data
                    </label>

                    <div class="col-sm-9">

                        <textarea name="<%=H2X.KEY_SWIPE_DATA%>"
                                  rows="10"
                                  class="form-control"
                                  id="<%=H2X.KEY_SWIPE_DATA%>"
                                  required></textarea>

                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary">Generate Script</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

</body>
</html>
