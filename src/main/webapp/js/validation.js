g

$(document).ready(function () {

	// to define jQuery validation, call the validate function on the form element
	// the validate function takes  a JSON object as a parameter that defines the validation rules
	$("#applicationForm").validate({
		
		debug : true,
		rules : {
			
			fName : {
				required : true,		// makes the first name required
				noWhitespaceOnly : true // uses the custom validator to make sure we don't get whitespace only 
			},
			lName : {
				required : true, 		// makes last name required
				minlength : 2,			// require min length of 2 characters
				lettersonly : true
			},
			emailAddr : {
				email : true,
				techElevatorEmail : true  // uses the custom validator for techelevator email addresses	
			},
			favoriteCompanies : {
				minlength : 2			// make sure the user selects at least 2 companies
			}
		},
		messages : {
			
			lName : {
				required : "You must provide a last name",
				minlength : "Last name can't be less than 2 characters"
			},
			favoriteCompanies : {
				minlength : "Please choose at least two companies"
			}
		},
		errorClass: "error"
	});
	
	// Create a custom validation rule that does not allow fields to have only whitespaces
	$.validator.addMethod("noWhitespaceOnly", function(value) {
		return value.trim().length > 0;
	}, "Enter something other than whitespace.");

	// Create a custom validation rule that only allows techelevator.com email addresses
	$.validator.addMethod("techElevatorEmail", function(value) {
		return value.toLowerCase().endsWith("@techelevator.com");
	}, "Only @techelevator.com addresses allowed");
	
});

