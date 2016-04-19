<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Omega Flyers</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        
        <link rel="stylesheet" type="text/css" href="styles-home.css"/>
    </head>
    <body>
        <div class="container-fluid"
            ><div class="row"
                ><div class="col-xs-2 logo"></div
                ><div class="col-xs-4 title"></div
                ><div class="col-xs-2 register alerts"></div
                ><div class="col-xs-2 login"></div
            ></div
            ><div class="row"
                ><div class="col-xs-6 featured-col"
                    ><c:forEach var="flyer" items="flyers_1" begin="0" step="1"
                        ><c:url var="flyer-img" value="${flyer.img}"></c:url
                        ><div class="featured-flyer"
                            ><img src="${flyer-img}"
                        ></div
                ></c:forEach
            ></div
                ><div class="col-xs-6 featured-col"
                    ><c:forEach var="flyer" items="flyers_2" begin="0" step="1"
                        ><c:url var="flyer-img" value="${flyer.img}"></c:url
                        ><div class="featured-flyer"
                            ><img src="${flyer-img}"
                        ></div
                ></c:forEach
            ></div
            ></div
        ></div>
    </body>
</html>