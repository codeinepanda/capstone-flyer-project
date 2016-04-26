<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Omega Flyers</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        
        <link rel="stylesheet" type="text/css" href="css/styles-home.css"/>
    </head>
    <body>
        <div class="container-fluid"
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
            ><div class="row"
                ><div class="col-xs-6 featured-col"
                    ><c:forEach var="flyer" items="${column1}" begin="0" step="1"
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
	                	   		/><c:param name="category" value="${flyer.category}"
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
	                	   		/><c:param name="category" value="${flyer.category}"
	                	   		/><c:param name="isRetired" value="${flyer.retired}"
	                	   /></c:url
	                	   ><a href="${navigateTo}" class="btn btn-block btn-info">View This Flyer</a
	                	   ><iframe src="${flyerPreview}" width="650" height="650"
	                	   ></iframe
                		></div
                   ></div
                   ></c:forEach
             ></div
             ><div class="col-xs-6 featured"
             	><c:forEach var="flyer" items="${column2}" begin="0" step="1"
                    ><div class="row featured"
                    	><div class="column-xs-12 featured"
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
	                	   		/><c:param name="category" value="${flyer.category}"
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
	                	   		/><c:param name="category" value="${flyer.category}"
	                	   		/><c:param name="isRetired" value="${flyer.retired}"
	                	   /></c:url
	                	   ><a href="${navigateTo}" class="btn btn-block btn-info">View This Flyer</a
	                	  ><iframe src="${flyerPreview}" width="650" height="650"
	                	   ></iframe
            		></div
            	></div
            ></c:forEach
        ></div>
    </body>
</html>