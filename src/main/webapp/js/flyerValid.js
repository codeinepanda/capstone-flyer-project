$(document).ready(function() {
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
            	date: true
            },
            expDate: {
            	required: true,
            	date: true
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
            	date: "Please ensure that your date is properly formatted: YYYY-MM-DD"
            },
            expDate: {
            	required: "Please enter the earliest date at which your promotions will no longer be redeemable",
            	date: "Please ensure that your date is properly formatted: YYYY-MM-DD"
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