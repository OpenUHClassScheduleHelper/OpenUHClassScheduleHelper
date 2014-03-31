$().ready(function(){

  var displayStudents = function (students){
    $.each(students, function(i, student){
	  console.log('student ' + i + ': ' + student.name);
	});
  };
  
  $.getJSON("315.json", displayStudents);
  
});

function extractURL(){
  var urlSource = $('#inputURL').val(); // url
  
  function onSource(source){
	// $('#source').val(source);
	
	var iframeNum = $(source).find('iframe').size(); // number of iframe elements on the page
	
	for (var i = 0; i < iframeNum; i++) {  // for each iframe, print all the attributes
	  var iframe = $(source).find('iframe')[i].attributes;
	  	var testDiv = $('<textarea/>', {
		                rows: '4',
		                cols: '50'});
		
	    testDiv.appendTo($('body'));

	  for (var j = 0; j < iframe.length; j++) {
	    testDiv.append(iframe[j].nodeName + " = " + iframe[j].nodeValue + "; ");
	    console.log(iframe[j].nodeName + " = " + iframe[j].nodeValue + "; ");
      }
	}
	
  }

  function onError(error){ alert(error); } // reports errors retrieving source
  
  getSource(urlSource, onSource, onError);
  
}
