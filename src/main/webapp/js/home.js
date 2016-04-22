$(document).ready(function() {
	$(".btn-info").click(function() {
		$("param[name='notPreview']").attr("value", "true");
	});
});