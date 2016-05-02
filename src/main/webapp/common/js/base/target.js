$(function() {
	$("a.mainTag").live("click", function() {
		return window.top.openLinkTag(this);
	});
	$("form.mainTag").live("submit", function() {
		return window.top.openFormTag(this);
	});
});
function reloadTag(a) {
	window.top.reloadFrame(a);
}
function closeTag(a) {
	window.top.closeTag(a);
}
function getTagTitle() {
	return window.top.getTitle();
}
function closeSelf() {
	window.top.closeActiveTag();
}
function openTag(b, c, a) {
	window.top.openTag(b, c, a);
};