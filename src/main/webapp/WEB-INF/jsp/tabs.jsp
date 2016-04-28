<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Your Tabs</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        
        <link rel="stylesheet" type="text/css" href="css/styles-home.css"/>
    </head>
    <nav class="navbar navbar-inverse">
  			<div class="container-fluid">
   				<div class="navbar-header">
      				<a class="navbar-brand" href="#">Flyers Corner</a>
    			</div>
    			<ul class="nav navbar-nav">
    				<c:url var="toHome" value="/"/>
     	 			<li><a href="${toHome}">Home</a></li>
     	 			<c:url var="toSearch" value="/searchFlyers"/>
      				<li><a href="${toSearch}">Search Flyers</a></li>
      				<c:url var="toFeatured" value="/viewFeatured"/>
      				<li><a href="${toFeatured}">Today's Featured Flyers</a></li>
      				<c:url var="toRecommended" value="/viewRecommended"/>
      				<li><a href="${toRecommended}">Your Recommended Flyers</a></li>
      				<c:url var="toFlyerForm" value="/flyerForm"/>
      				<li><a href="${toFlyerForm}">Your Recommended Flyers</a></li> 
    			</ul>
    			<ul class="nav navbar-nav navbar-right">
    				<c:url var="toTabs" value="/userFlyers"/>
      				<li><a href="${toUserFlyers}"><span class="glyphicons glyphicons-list-alt"></span> Your Published Flyers</a></li>
    				<c:url var="toTabs" value="/viewTabs"/>
      				<li class="active"><a href="${toTabs}"><span class="glyphicons glyphicons-ticket"></span> Your Tabs</a></li>
      				<c:url var="toLogout" value="/logout"/>
      				<li><a href="${toLogout}"><span class="glyphicons glyphicons-door"></span> Logout</a></li>
      				</form>
    			</ul>
  			</div>
		</nav>
    <body>
        <div class="container-fluid"
            ><div class="row"
                ><div class="col-xs-4 logo"
                	><img src=""
                ></div
                ><div class="col-xs-6 title"
                	><h1>FLYERS CORNER</h1
                	><h4>Welcome back, <c:out value="${currentUser.firstName}"/>!</h4
                ></div
                ><div class="col-xs-2 rewards"
                	><h4>Your Current Redemption Rewards:</h4
                	><c:if test="${not empty points}"
                		><p><strong><c:out value="${points}"/></strong></p
                	></c:if
                	><c:if test="${empty points}"
                		><p><strong>0</strong></p
                	></c:if
                ></div
                ><div class="col-xs-2 button tabs"
                	><c:url var="toHome" value="/"
                	/><a class="btn btn-block btn-success" href="${toHome}">Home</a
                ></div
                ><div class="col-xs-2 button alerts"
                	><c:url var="toAlerts" value="/alerts"
                	/><a class="btn btn-block btn-warning" href="${toAlerts}">Alerts</a
                ></div
                ><div class="col-xs-2 button createFlyer"
                	><c:url var="toFlyerForm" value="/flyerForm"
                	/><a class="btn btn-block btn-primary" href="${toFlyerForm}">New Flyer</a
                ></div
                 ><div class="col-xs-2 button search"
                	><c:url var="toSearch" value="/searchFlyers"
                	/><a class="btn btn-block btn-info" href="${toSearch}">Search</a
                ></div
                ><div class="col-xs-2 button profile"
                	><c:url var="toProfile" value="/profilePage"
                	/><a class="btn btn-block btn-primary" href="${toProfile}">Profile</a
                ></div
                ><div class="col-xs-2 button login"
                	><c:url var="logout" value="/logout"
                	/><form id="logout" method="POST" action="${logout}"
                		><input type="submit" value="Logout" class="btn btn-block btn-danger"
                /></form></div
            ></div
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