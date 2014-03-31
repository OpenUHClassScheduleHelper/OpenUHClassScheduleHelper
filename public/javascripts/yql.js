/* Access to sources of web pages. (Also called 'scrapping')
 * Note that because browsers don't allow cross-domain requests,
 * and scrapping sources falls under these restrictions, more complicated
 * means are necessary to circumvent such restrictions.
 * 
 * Copyright 2014 Jan Stelovsky, Uni Hawaii, ICS, 
 * MIT license */

// Attempts to get the html source of a web page with 'url'.
// Calls asynchronously onSource(html) if the page's html can be obtained
// otherwise calls onError(message)
// Sample usage:
//   getSource('http://www.mit.edu/index.html', 
//     function(source){
//       // use source
//     }, 
//     function(error){
//       // report error
//     }
//   );
// Note that some web sites do not allow access to their web pages.
// Note: Doesn't support deferred/promise protocol.
// Note: Uses Yahoo's YQL frameworks, i.e., it won't work is YQL isn't available.
function getSource(url, onSource, onError){
  $.ajax({
    type: 'GET', dataType: 'json',
    // url of YQL's service
    url: 'http://query.yahooapis.com/v1/public/yql?callback=?',
    data: { // YQL query
      q: 'select * from html where url="' + url + '" and xpath="*"', 
      format: 'xml'
    },
    // callback upon query's success; note that there may be no data
    success: function(data) {
      if (data.results.length > 0) {
        // extract the page's html and get rid of <script> elements
        text = data.results[0].replace(/<script[^>]+?\/>|<script(.|\s)*?\/script>/gi, '');
        // call client's on success callback
        onSource(text);
      } else { // failure, call 
        onError("No source; URL doesn't exist or can't be scrapped");
      }
    },
    // callback upon failure of ajax call, pipe it to client
    error: function(data) {
      onError(arguments[2]);
    }
  });
}