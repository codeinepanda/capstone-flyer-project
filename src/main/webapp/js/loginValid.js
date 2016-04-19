$(document).ready(function() {
    $("#login_form").validate({
        debug: true,
        rules: {
            username: {
                required: true,
            },
            password: {
                required: true,
                minlength: 10
            }
        },
        messages: {
            username: {
                required: "Your username is required for login"
            },
            password: {
                required: "You must enter a password",
                minlength: "Your password must be at least 10 characters long!"
            }
        }
    });
});