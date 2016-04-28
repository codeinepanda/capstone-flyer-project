<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Search For Flyers</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/register.css">
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
      				<li class="active"><a href="${toSearch}">Search Flyers</a></li>
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
             ><div class="row header"
                   ><div class="col-xs-12 header"
                         ><h1>Create A New Flyer</h1
                   ></div
             ></div
             ><div class="row form"
                   ><div class="col-xs-12 form">
                        <div id="form_box">
                   			<select name="searchBy" id="searchBy">
                   				<option name="searchBy" value="title">Flyer Name</option>
                   				<option name="searchBy" value="author">Flyer Author</option>
                   				<option name="searchBy" value="company">Company of Origin</option>
                   				<option name="searchBy" value="tabs">Remaining Tabs</option>
                   				<option name="searchBy" value="category">Category</option>
                   			</select>
                   			<br>
                   			<br>
                            <form id="flyer_form" action="filterFlyers" method="POST">
                                <section id="flyerName" hidden>
                                	<label>Flyer Name: </label> <input type="text" name="flyerName"/>
                                	<br>
                                	<br>
                                </section>
                                <section id="company" hidden>
                                	<label>Company Name: </label> <input type="text" name="company"/>
                                	<br>
                                	<br>
                                </section>
                                <section id="userName" hidden>
                                	<label>Flyer Author: </label> <input type="text" name="userName"/>
                                	<br>
                                	<br>
                                </section>
                                <section id="category" hidden>
                                	<label>Categories: </label>
                                	<br>
                                	<input type="checkbox" name="category" value="automobile"> Automobile <input type="checkbox" name="category" value="career"> Career <input type="checkbox" name="category" value="social"> Social
                                	<input type="checkbox" name="category" value="food"> Food <input type="checkbox" name="category" value="forSale"> For Sale <input type="checkbox" name="category" value="entertainment"> Entertainment
                                	<input type="checkbox" checked="checked" name="category" value=""> Any<br>
                                	<br>
                                	<br>
                                	<br>
                                </section>
                                <label>Order By: </label>
                                <select name="orderBy">
                                	<option value="popularity" selected="selected">Most Popular</option>
                                	<option value="endDate">Days to Expiration</option>
                                	<option value="numTabs">Tabs Remaining</option>
                                	<option value="createDate">Most Recent</option>
                                </select>
                                <input class="btn btn-primary" type="submit" id="submit" value="Submit">
                            </form
                        ></div
                   ></div
             ></div
        ></div
  ><script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="   crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/additional-methods.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">
  </script>
  <script src="js/filterValid.js"></script>
  <script src="js/filterForm.js"></script>
    </body>
</html>