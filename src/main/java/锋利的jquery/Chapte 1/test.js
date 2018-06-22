//the two functions are the same
$(document).ready(function(){
});

$(function(){
})

var domObject = document.getElementById("forDom");
var jqueryObject = $("#forjQuery");

var jQueryToDomByGet = jqueryObject.get(0);
var jQueryToDomBySquireBrace = jqueryObject[0];

var domToJquery = $(domObject);

