<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register New User</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="css/register.css">
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
                            <form id="reg_form" method="POST" action="createUser">
                                <label>First Name: </label> <input type="text" name="firstName" id="firstName"/>
                                <br>
                                <br>
                                <label>Last Name: </label> <input type="text" name="lastName" id="lastName"/>
                                <br>
                                <br>
                                <label>Username: </label> <input type="text" name="username" id="username"/>
                                <br>
                                <br>
                                <label>Your Email: </label> <input type="email" name="email" id="email"/>
                                <br>
                                <br>
                                <label>Password: </label> <input type="password" name="password" id="password"/>
                                <br>
                                <br>
                                <label>Confirm Password: </label> <input type="password" name="confirm" id="confirm"/>
                                <br>
                                <br>
                                <input class="btn btn-primary" id="submit" type="submit">
                            </form>
                        </div
                   ></div
             ></div
        ></div
  ><script src="https://code.jquery.com/jquery-2.2.3.min.js" integrity="sha256-a23g1Nt4dtEYOj7bR+vTu7+T8VP13humZFBJNIYoEJo="   crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/jquery.validate.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.15.0/additional-methods.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">
  </script>
  <script src="js/registerValid.js"></script>
    </body>
</html>