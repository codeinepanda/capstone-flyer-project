<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Your Tabs</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        
        <link rel="stylesheet" type="text/css" href="css/styles-home.css"/>
    </head>
    <c:import url="/WEB-INF/jsp/header.jsp"/>
    <body>
        <div class="container-fluid"
            ><div id="main-content" class="row featured"
                ><div class="col-xs-12 featured"
                    ><c:forEach var="tab" items="${tabs}" begin="0" step="1"
                    ><div class="row featured"
                    	><div class="col-xs-12 featured"
                    		><div class="row" id="titleRow"
                    			><div class="col-xs-12"
	                	   ><h4><c:out value="${tab.flyerName}"/></h4
	                	   		></div><!-- END TAB TITLE COLUMN
	                	 --></div><!-- END TAB TITLE ROW
	                	 --><div class="row" id="redeem"
                    			><div class="col-xs-12" id="redeemBtn"
                    				><c:url var="redeemTab" value="/redeemTab"
                    					><c:param name="flyerID" value="${tab.flyerID}"
	                	   	   	   /></c:url
	                	   			><a href="${redeemTab}" class="btn btn-default"><strong>Redeem Tab</strong></a
	                	   		></div><!-- END TAB REDEEM COLUMN
	                	 --></div><!-- END TAB REDEEM ROW
	                	 --><div class="row" id="timeTable"
	                	   		><div class="col-xs-6" id="timeTable1"
	                	   			><h5><c:out value="${tab.startDate}"/></h5
	                	   		></div><!-- END TIMETABLE COLLUMN 1
	                	   	--><div class="col-xs-6" id="timeTable2"
	                	   			><h5><c:out value="${tab.endDate}"/></h5
	                	   	></div><!-- END TIMETABLE COLUMN 2
	                	 --></div><!-- END TIMETABLE ROW
                		--></div
                   ></div
                   ></c:forEach
             ></div
            ></div
        ></div
   ><script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="   crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/additional-methods.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">
  </script>
  <script src="js/home.js"></script>
    </body>
</html>