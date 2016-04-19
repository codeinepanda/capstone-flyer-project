$(document).ready(function() {
    $("#login_form").validate({
        debug: true,
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 10
            }
        },
        messages: {
            email: {
                required: "A valid email is required",
                email: "Please ensure that your email is valid"
            },
            password: {
                required: "You must enter a password",
                minlength: "Your password must be at least 10 characters long!"
            }
        }
    });
});