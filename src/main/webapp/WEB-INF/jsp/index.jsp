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
            ></div
            ><div id="main-content" class="row featured"
                ><div class="col-xs-6 featured"
                    ><c:forEach var="flyer" items="${column1}" begin="0" step="1"
                    ><div class="row"
                    	><div class="col-xs-12"
	                        ><c:out value="<strong>Flyer Name:</strong> ${flyer.flyerName}" escapeXml="false"
	                       /><br
	                       ><c:out value="<strong>Company:</strong> ${flyer.company}" escapeXml="false"
	                       /><br
	                       ><c:out value="<strong>Creator:</strong> ${flyer.userName}" escapeXml="false"
	                       /><br
	                       ><c:out value="<strong>Number of Tabs:</strong> ${flyer.numberOfTabs}" escapeXml="false"
	                       /><br
	                       ><c:out value="<strong>Offer Expires:</strong> ${flyer.endDate}" escapeXml="false"
	                       /><br
	                       ><c:out value="<strong>Description:</strong> ${flyer.flyerDescription}" escapeXml="false"
	                	  /><br
	                	   ><br
                		></div
                   ></div
                   ></c:forEach
             ></div
                ><div class="col-xs-6 featured"
                    ><c:forEach var="flyer" items="${column2}" begin="0" step="1"
                    	><div class="row"
                    		><div class="column-xs-12"
		                        ><c:out value="<strong>Flyer Name:</strong> ${flyer.flyerName}" escapeXml="false"
		                       /><br
		                       ><c:out value="<strong>Company:</strong> ${flyer.company}" escapeXml="false"
		                       /><br
		                       ><c:out value="<strong>Creator:</strong> ${flyer.userName}" escapeXml="false"
		                       /><br
		                       ><c:out value="<strong>Number of Tabs:</strong> ${flyer.numberOfTabs}" escapeXml="false"
		                       /><br
		                       ><c:out value="<strong>Offer Expires:</strong> ${flyer.endDate}" escapeXml="false"
		                       /><br
		                       ><c:out value="<strong>Description:</strong> ${flyer.flyerDescription}" escapeXml="false"
                			  /><br
                			   ><br
                			></div
                	   ></div
                	></c:forEach
              ></div
            ></div
        ></div>
    </body>
</html>