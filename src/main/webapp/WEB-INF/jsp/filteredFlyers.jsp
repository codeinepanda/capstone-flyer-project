<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Results</title>
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
      				<li><a href="${toSearch}">Return to Search</a></li>
      				<c:url var="toFeatured" value="/viewFeatured"/>
      				<li><a href="${toFeatured}">View Featured Flyers</a></li> 
    			</ul>
    			<ul class="nav navbar-nav navbar-right">
    			<c:url var="toRegistration" value="/registration"/>
      				<li><a href="${toRegistration}"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      				<c:url var="toLogin" value="/loginPage"/>
      				<li><a href="${toLogin}"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    			</ul>
  			</div>
		</nav>
		
    <body>
        <div class="container-fluid"
            ><c:if test="${empty currentUser}"
            	><div id="header-row" class="row"
                	><div class="col-xs-2 logo"
                		><img src=""
                	></div
                	><div class="col-xs-4 title"
                		><h1>FLYERS CORNER</h1
                	></div
                	><div class="col-xs-2 register"
                		><c:url var="toRegistration" value="/registration"
                		/><a class="btn btn-block btn-default" href="${toRegistration}">Register</a
                	></div
                	><div class="col-xs-2 login"
                		><c:url var="toLogin" value="/loginPage"
                		/><a class="btn btn-block btn-default" href="${toLogin}">Login</a
               	 	></div
                	><div class="col-xs-2 login"
                		><c:url var="toSearch" value="/searchFlyers"
                		/><a class="btn btn-block btn-default" href="${toSearch}">Return to Search</a
               	 	></div
           		></div
           	></c:if
           	><c:if test="${not empty currentUser}"
           		><div class="row"
                ><div class="col-xs-4 logo"
                	><img src=""
                ></div
                ><div class="col-xs-8 title"
                	><h1>FLYERS CORNER</h1
                	><h4>Welcome back, <c:out value="${currentUser.firstName}"/>!</h4
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
                ><div class="col-xs-2 button tabs"
                	><c:url var="toTabs" value="/viewTabs"
                	/><a class="btn btn-block btn-success" href="${toTabs}">Your Tabs</a
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
           	></c:if
            ><div id="main-content" class="row featured"
                ><div class="col-xs-12 featured"
                    ><c:forEach var="flyer" items="${filteredFlyers}" begin="0" step="1"
                    ><div class="row featured"
                    	><div class="col-xs-12 featured"
	                	   ><c:url var="flyerPreview" value="/previewSelected"
	                	   		><c:param name="flyerName" value="${flyer.flyerName}"
	                	   		/><c:param name="company" value="${flyer.company}"
	                	   		/><c:param name="flyerID" value="${flyer.flyerID}"
	                	   		/><c:param name="userName" value="${flyer.userName}"
	                	   		/><c:param name="createDate" value="${flyer.createDate}"
	                	   		/><c:param name="startDate" value="${flyer.startDate}"
	                	   		/><c:param name="endDate" value="${flyer.endDate}"
	                	   		/><c:param name="numTabs" value="${flyer.numberOfTabs}"
	                	   		/><c:param name="flyerInfo" value="${flyer.flyerDescription}"
	                	   		/><c:param name="category" value="${flyer.categories}"
	                	   		/><c:param name="isRetired" value="${flyer.retired}"
	                	   /></c:url
	                	   	><c:url var="navigateTo" value="/viewSelected"
	                	   		><c:param name="flyerName" value="${flyer.flyerName}"
	                	   		/><c:param name="company" value="${flyer.company}"
	                	   		/><c:param name="flyerID" value="${flyer.flyerID}"
	                	   		/><c:param name="userName" value="${flyer.userName}"
	                	   		/><c:param name="createDate" value="${flyer.createDate}"
	                	   		/><c:param name="startDate" value="${flyer.startDate}"
	                	   		/><c:param name="endDate" value="${flyer.endDate}"
	                	   		/><c:param name="numTabs" value="${flyer.numberOfTabs}"
	                	   		/><c:param name="flyerInfo" value="${flyer.flyerDescription}"
	                	   		/><c:param name="category" value="${flyer.categories}"
	                	   		/><c:param name="isRetired" value="${flyer.retired}"
	                	   /></c:url
	                	   ><a href="${navigateTo}" class="btn btn-block btn-info">View This Flyer</a
	                	   ><iframe src="${flyerPreview}" width="650" height="650"
	                	   ></iframe
                		></div
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