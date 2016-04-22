<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Your New Flyer</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/flyer.css">
	</head>
	<body>
  <div class="container-fluid"
       
    ><div class="row page" id="page">
      <div class="col-xs-12 page">
        <div class="row" id="Mainheader">
          <div class="col-xs-12 Name">
            <h3 id="userName">Flyers Corner</h3
      ></div><!-- END NAME COLUMN
    --></div><!-- END ROW HEADER
    --><c:if test="${notPreview}"
      ><div class="row header-buttons"
          ><div class="col-xs-3"
          ><c:url var="toHome" value="/"
        /><a href="${toHome}" class="btn btn-primary btn-block fa fa-home"> Home</a
          ></div
          ><div class="col-xs-3"
          ><c:url var="toSearch" value="/searchFlyers"
        /><a href="${toSearch}" class="btn btn-primary btn-block fa fa-info-circle"> Search Flyers</a
          ></div
          ><div class="col-xs-3"
          ><c:url var="toSuggested" value="/suggestedFlyers"
        /><a href="${toSuggested}" class="btn btn-primary btn-block fa fa-folder-open"> View Suggested</a
          ></div>
          <div class="col-xs-3"
          ><c:url var="publishNew" value="flyerForm"
        /><a href="${publishNew}" class="btn btn-primary btn-block fa fa-envelope"> Make Flyer</a
          ></div
      ></div><!-- END HEADER BUTTONS
      --></c:if
        ><div class="row" id="flyer-body"
      ><div class="col-xs-12" id="body-title"
        ><h1 id="company"><c:out value="${selectedFlyer.company}"/></h1
        ><h2 id="flyer-title"><c:out value="${selectedFlyer.flyerName}"/></h2
      ></div><!-- END BODY TITLE COLUMN
    --><div class="col-xs-12 description"
      	><p><c:out value="${selectedFlyer.flyerDescription}"/></p
      ></div><!-- END DESCRIPTION COLUMN
    --><div class="col-xs-12 takeTab"
    ><c:url var="takeTab" value="/takeTab"
        /><a href="${takeTab}" class="btn btn-default fa fa-ticket link"> <strong>Grab A Tab</strong><br>Only <c:out value="${selectedFlyer.numberOfTabs}"/> left!</a
      ></div><!-- END TAKE TAB COLUMN
      --></div><!-- END FLYER BODY ROW
      --><div class="row" id="footer"
          ><div class="col-xs-6 creator"
          ><p>Created by: <c:out value="${selectedFlyer.userName}"/> on <c:out value="${suggestedFlyer.createDate}"/></p
          ></div><!-- END CREATOR COLUMN
        --><div class="col-xs-6 expire"
            ><p>Offer Expires: <c:out value="${selectedFlyer.endDate}"/> so act fast!</p
          ></div><!-- END CREATOR COLUMN
      --></div><!-- END FOOTER ROW
    --></div><!-- END HOMEPAGE COLUMN
    --></div><!-- END HOMEPAGE ROW
--></div><!-- END CONTAINER -->
</body>
</html>