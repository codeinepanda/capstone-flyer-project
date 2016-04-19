$(document).ready(function() {
    $("#reg_form").validate({
        debug: true,
        rules: {
            firstName: {
                required: true
            },
            lastName: {
                required: true
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