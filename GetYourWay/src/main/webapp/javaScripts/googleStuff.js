/**
 * 
 */
alert("Hello 1");
var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;

function initialize() {
	  directionsDisplay = new google.maps.DirectionsRenderer();
	  var chicago = new google.maps.LatLng(41.850033, -87.6500523);
	  var mapOptions = {
	    zoom:7,
	    center: chicago
	  }
	  map = new google.maps.Map(document.getElementById("map-canvas"), mapOptions);
	  directionsDisplay.setMap(map);
	}


function calcRoute() {
	
	console.dir("Hello");
  var start = document.getElementById("start").value;
  var end = document.getElementById("end").value;
  var mode = document.getElementById("mode").value;
  var transitOpts = document.getElementById("transitOpts").value;
  
  var request = {
    origin:start,
    destination:end,
    travelMode: google.maps.TravelMode[mode],
    transitOptions: transitOpts
  };
  directionsService.route(request, function(result, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(result);
    }
  });
}

google.maps.event.addDomListener(window, 'load', initialize);