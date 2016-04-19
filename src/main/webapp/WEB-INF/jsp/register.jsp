<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register New User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="register.css">
        <script src=""></script>
        <script src=""></script>
    </head>
    
    <body>
        <div class="container-fluid"
             ><div class="row header"
                   ><div class="col-xs-12 header"
                         ><h1>Register With Flyers Corner</h1
                   ></div
             ></div
             ><div class="row form"
                   ><div class="col-xs-12 form">
                        <div id="form_box">
                            <form>
                                <label>First Name: </label> <input type="text" name="firstName" id="firstName"/>
                                <br>
                                <br>
                                <label>Last Name: </label> <input type="text" name="lastName" id="lastName"/>
                                <br>
                                <br>
                                <label>Your Email: </label> <input type="email" name="email" id="email"/>
                                <br>
                                <br>
                                <label>Password: </label> <input type="password" name="password" id="password"/>
                                <br>
                                <br>
                                <label>Confirm Password: </label> <input type="password" name="password" id="password"/>
                                <br>
                                <br>
                                <input class="btn btn-primary" id="submit" type="submit">
                            </form>
                        </div
                   ></div
             ></div
        ></div>
    </body>
</html>