function initMap() {
    var location = new google.maps.LatLng(27.812124, -82.784386);
    
    var mapSettings = {
        zoom: 16,
        center: location,
        mapTypeId: google.maps.MapTypeId.HYBRID
    };
    
    var sensorMap = new google.maps.Map(document.getElementById('sensorMap'),
        mapSettings);
}