<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Your New Flyer</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="flyer.css">
	</head>
	<body>
		<div class="container-fluid">
			<div class="row page">
				<div class="col-xs-12 page">
					<div class="row header">
						<div class="col-xs-4 header" id="logo"></div>
						<div class="col-xs-4 header" id="title">
							<h1><c:out value="${newFlyer.flyerName}"/></h1>
						</div>
						<div class="col-xs-4 header" id="daysRemaining">
							<h3><c:out value="${days}"/></h3>
						</div>
					</div><!-- END ROW HEADER -->
					<div class="row description">
						<div class="col-xs-12 description" id="description">
							<p><c:out value="${newFlyer.flyerDescription}"/></p>
						</div>
					</div><!-- END ROW DESCRIPTION -->
					<div class="row tabs">
						<div class="col-xs-12"><h3>ACT NOW! Only <c:out value="${newFlyer.numberOfTabs}"/> Tabs Remaining!</h3></div>
					</div><!-- END ROW TABS -->
				</div>
			</div>
		</div><!-- END CONTAINER -->
	</body>
</html>