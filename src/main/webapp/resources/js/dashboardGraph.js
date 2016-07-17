google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawGraph);

function drawGraph() {

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'X');
      data.addColumn('number', 'Temperature');
      
      var celsiusOverTime = [];
      var time, temp;
      
      for (var i in temperatureReadings) {
          time = temperatureReadings[i].timestamp.slice(5,7) + '/' + temperatureReadings[i].timestamp.slice(8,10);
          temp = temperatureReadings[i].celsius;
          celsiusOverTime.push([time, temp]);
      }
      
      data.addRows(celsiusOverTime);

      var options = {
        hAxis: {
          title: 'Time'
        },
        vAxis: {
          title: 'Temperature'
        }
      };

      var graph = new google.visualization.LineChart(document.getElementById('dataGraph'));

      graph.draw(data, options);
    }