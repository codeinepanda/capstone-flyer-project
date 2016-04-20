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
                ><div class="col-xs-2 logo"
                	><img src=""
                ></div
                ><div class="col-xs-4 title"
                	><h1>FLYERS CORNER</h1
                	><h4>Welcome back, <c:out value="${currentUser.firstName}"/>!</h4
                ></div
                ><div class="col-xs-1 button alerts"
                	><c:url var="toAlerts" value="/alerts"
                	/><a class="btn btn-block btn-warning" href="${toAlerts}">Alerts</a
                ></div
                ><div class="col-xs-1 button createFlyer"
                	><c:url var="toFlyerForm" value="/flyerForm"
                	/><a class="btn btn-block btn-warning" href="${toFlyerForm}">New Flyer</a
                ></div
                ><div class="col-xs-2 button login"
                	><c:url var="logout" value="/logout"
                	/><form id="logout" method="POST" action="${logout}"
                		><input type="submit" value="Logout" class="btn btn-block btn-danger"
<<<<<<< HEAD
                /></form></div
                ><div class="col-xs-2 profile"
=======
                /></div
                ><div class="col-xs-2 button profile"
>>>>>>> 66c39a6a13b5e6f9f0aa2fcf7451392f85f49911
                	><c:url var="toProfile" value="/profilePage"
                	/><a class="btn btn-block btn-primary" href="${toProfile}">Profile</a
                ></div
            ></div
            ><div class="row"
                ><div class="col-xs-6 featured-col"
                    ><c:forEach var="flyer" items="flyers_1" begin="0" step="1"
                        ><c:url var="flyer-img" value=""></c:url
                        ><div class="featured-flyer"
                            ><img src=""
                        ></div
                ></c:forEach
            ></div
                ><div class="col-xs-6 featured-col"
                    ><c:forEach var="flyer" items="flyers_2" begin="0" step="1"
                        ><c:url var="flyer-img" value=""></c:url
                        ><div class="featured-flyer"
                            ><img src=""
                        ></div
                ></c:forEach
            ></div
            ></div
        ></div>
    </body>
</html>