<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Flyers Corner</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        
        <link rel="stylesheet" type="text/css" href="css/styles-home.css"/>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
  			<div class="container-fluid">
   				<div class="navbar-header">
      				<a class="navbar-brand" href="#">Flyers Corner</a>
    			</div>
    			<ul class="nav navbar-nav">
     	 			<li class="active"><a href="#">Home</a></li>
     	 			<c:url var="toSearch" value="/searchFlyers"/>
      				<li><a href="${toSearch}">Search Flyers</a></li>
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
 
  <script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="   crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/additional-methods.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">
  </script>
  <script src="js/home.js"></script>
    </body>
</html>