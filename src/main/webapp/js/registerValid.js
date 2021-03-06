$(document).ready(function() {
    $("#reg_form").validate({
        rules: {
            firstName: {
                required: true
            },
            lastName: {
                required: true
            },
            username: {
            	required: true,
            	minlength: 3
            },
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 10
            },
            confirm: {
                required: true,
                minlength: 10,
                equalTo: "#password"  
            }
        },
        messages: {
            firstName: "Please, enter your first name",
            lastName: "Please, enter your last name",
            email: {
                required: "A valid email is required",
                email: "Please ensure that your email is valid"
            },
            password: {
                required: "You must enter a password",
                minlength: "Your password must be at least 10 characters long!"
            },
            confirm: {
                required: "Your passwords must match!",
                minlength: "Your password must be at least 10 characters long!",
                equalTo: "Your passwords don't match!"
            }
        }
     });
});