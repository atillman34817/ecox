function initMap() {
    var location = new google.maps.LatLng(27.812124, -82.784386);
    
    var mapSettings = {
        zoom: 16,
        center: location,
        mapTypeId: google.maps.MapTypeId.HYBRID
    };
    
    var sensorMap = new google.maps.Map(document.getElementById('sensorMap'),
        mapSettings);
        
    var dummyLocations = [
        {lat: 27.812316, lng: -82.786215},
        {lat: 27.811671, lng: -82.786430},
        {lat: 27.810893, lng: -82.785636},
        {lat: 27.812981, lng: -82.786054},
    ];
    
    var dummyMarker1 = new google.maps.Marker({
        position: dummyLocations[0],
        map: sensorMap,
        title: 'Sensor 1'
    });
    
    var dummyMarker2 = new google.maps.Marker({
        position: dummyLocations[1],
        map: sensorMap,
        title: 'Sensor 2'
    });
    
    var dummyMarker3 = new google.maps.Marker({
        position: dummyLocations[2],
        map: sensorMap,
        title: 'Sensor 3'
    });
    
    var dummyMarker4 = new google.maps.Marker({
        position: dummyLocations[3],
        map: sensorMap,
        title: 'Sensor 4'
    });
}