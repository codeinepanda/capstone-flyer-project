$(document).ready(function() {
	$("#searchBy").change(function() {
		var $selected = $("#searchBy option:selected").val();
		if($selected === "title") {
			$("#flyerName").show();
			$("#company").hide();
			$("#userName").hide();
			$("#numTabs").hide();
			$("#category").hide();
			$("#submit").show();
		} else if($selected === "author") {
			$("#flyerName").hide();
			$("#company").hide();
			$("#userName").show();
			$("#numTabs").hide();
			$("#category").hide();
			$("#submit").show();
		} else if($selected === "company") {
			$("#flyerName").hide();
			$("#company").show();
			$("#userName").hide();
			$("#numTabs").hide();
			$("#category").hide();
			$("#submit").show();
		} else if($selected === "tabs") {
			$("#flyerName").hide();
			$("#company").hide();
			$("#userName").hide();
			$("#numTabs").show();
			$("#category").hide();
			$("#submit").show();
		} else if($selected === "category") {
			$("#flyerName").hide();
			$("#company").hide();
			$("#userName").hide();
			$("#numTabs").hide();
			$("#category").show();
			$("#submit").show();
		}
	});
});