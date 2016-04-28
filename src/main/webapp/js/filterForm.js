$(document).ready(function() {
	$("#searchBy").change(function() {
		var $selected = $("#searchBy option:selected").val();
		if($selected === "title") {
			$("#flyerName").show();
			$("#company").hide();
			$("#userName").hide();
			$("#category").hide();
			$("#submit").show();
		} else if($selected === "author") {
			$("#flyerName").hide();
			$("#company").hide();
			$("#userName").show();
			$("#category").hide();
			$("#submit").show();
		} else if($selected === "company") {
			$("#flyerName").hide();
			$("#company").show();
			$("#userName").hide();
			$("#category").hide();
			$("#submit").show();
		} else if($selected === "category") {
			$("#flyerName").hide();
			$("#company").hide();
			$("#userName").hide();
			$("#category").show();
			$("#submit").show();
		}
	});
});