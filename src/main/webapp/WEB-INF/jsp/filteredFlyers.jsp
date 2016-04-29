<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search Results</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/styles-home.css"/>
        <link rel="stylesheet" type="text/css" href="css/headerStyle.css"/>
    </head>
    <c:import url="/WEB-INF/jsp/header.jsp"/>
    <body>
        <div class="container-fluid"
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
	                	   ><a href="${navigateTo}" class="btn btn-info" style="width: 950px">View This Flyer</a
	                	   ><iframe src="${flyerPreview}" scrolling="no" width="1000" height="550"
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