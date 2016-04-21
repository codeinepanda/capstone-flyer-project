$(document).ready(function() {
    $.validator.addMethod("sqlDate", function(date) {
        return date.match(/^(19|20)\d\d-(0\d|1[012])-(0\d|1\d|2\d|3[01])$/);
    });
    $("#flyer_form").validate({
        rules: {
            flyerName: {
                required: true,
            },
            companyName: {
                required: true,
            },
            startDate: {
            	required: true,
            	date: true,
            	sqlDate: true
            },
            expDate: {
            	required: true,
            	date: true,
            	sqlDate: true
            },
            numTabs: {
            	required: true,
            	min: 1
            },
            category: {
            	required: true
            },
            description: {
            	required: true,
            	minlength: 150
            }
        },
        messages: {
            flyerName: {
                required: "A name for your flyer is required"
            },
            companyName: {
                required: "Indicate a company affiliation. If none, enter \"None\""
            },
            startDate: {
            	required: "Please enter the date at which your promotions become redeemable",
            	date: "Please ensure that your date is properly formatted:",
            	sqlDate: "Please ensure that your date is properly formatted:"
            },
            expDate: {
            	required: "Please enter the earliest date at which your promotions will no longer be redeemable",
            	date: "Please ensure that your date is properly formatted:",
            	sqlDate: "Please ensure that your date is properly formatted"
            },
            numTabs: {
            	required: "Please indicate how many tabs you would like to offer",
            	min: "You must offer at least one tab"
            },
            category: {
            	required: "Please indicate at least one category to describe your flyer. It will help our users find your promotions."
            },
            description: {
            	required: "Please describe your flyer in detail. Explain what is being offered as well as any terms and conditions that may apply.",
            	minlength: "This part of the form should be quite detailed. Your description is too short to be effective"
            }
        }
    });
});