<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>User Preferences</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/register.css">
        <link rel="stylesheet" type="text/css" href="css/headerStyle.css"/>
    </head>
    <c:import url="/WEB-INF/jsp/header.jsp"/>
    <body>
        <div class="container-fluid"
             ><div class="row header"
                   ><div class="col-xs-12 header"
                         ><h1>User Preferences</h1
                         ><h4>Fill in the fields below with any preferences you might have and we'll notify you whenever a new flyer
                         is created that matches your preferences. You can view a list of our most recent flyers that match your
                         preferences any time you want, just by clicking "Recommended Flyers" in your navigation bar.</h4
                   ></div
             ></div
             ><div class="row form"
                   ><div class="col-xs-12 form">
                        <div id="form_box">
                            <form id="flyer_form" action="createPreferences" method="POST">

                                <section id="company">
                                	<label>Company Name: </label>
                                	<select multiple name="company">
                                		<option value="" selected="selected">Any</option>
                                		<c:forEach var="company" items="${companies}">
                                			<option value="${company}"><c:out value="${company}"/></option>
                                		</c:forEach>
                                	</select>
                                	<br>
                                	<br>
                                </section>
                                <section id="author">
                                	<label>Flyer Author: </label>
                                	<select multiple name="author">
                                		<option value="" selected="selected">Any</option>
                                		<c:forEach var="author" items="${authors}">
                                			<option value="${author}"><c:out value="${author}"/></option>
                                		</c:forEach>
                                	</select>
                                	<br>
                                	<br>
                                </section>
                                <section id="category">
                                	<label>Categories: </label>
                                	<p>Select from the list of currently available categories. If you would like to add additional categories
                                	to your preferences, you may. We will add flyers of that category to your recommendations as soon as they
                                	become available.</p>
                                	<select multiple name="categories">
                                		<option value="" selected="selected">Any</option>
                                		<c:forEach var="category" items="${categories}">
                                			<option value="${category}"><c:out value="${category}"/></option>
                                		</c:forEach>
                                	</select>
                                	<br>
                                	<label>Additional categories: </label> <input type="text" name="categories">
                                	<br>
                                	<br>
                                	<br>
                                </section>
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
</body>
</html>