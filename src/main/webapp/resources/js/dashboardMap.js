/* 
This Sets the map tile - there is not a tile currently added. 
 */

var mymap = L.map( 'mapid', {
    center: [27.812295, -82.786255],
    minZoom: 2,
    zoom: 17
});


L.tileLayer( 'http://{s}.mqcdn.com/tiles/1.0.0/sat/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="http://osm.org/copyright" title="OpenStreetMap" target="_blank">OpenStreetMap</a> contributors | Tiles Courtesy of <a href="http://www.mapquest.com/" title="MapQuest" target="_blank">MapQuest</a> <img src="http://developer.mapquest.com/content/osm/mq_logo.png" width="16" height="16">',
    subdomains: ['oatile1','oatile2','oatile3','oatile4']
}).addTo( mymap );

L.marker([27.812295, -82.786255]).addTo(mymap).bindPopup("<b>Test Sensor</b><br>I am a test");