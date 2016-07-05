/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import edu.spcollege.ecox.shared.Location;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 *
 * @author Student
 */
public class TemperatureReader implements Reader<TemperatureReading> {
    
    @Override
    public List<TemperatureReading> read(InputStream inputStream) {
        
        String[] row = inputStream.toString().split("\n");
        List<TemperatureReading> temperatureReadings = new ArrayList<>();
        DateTimeFormatter dtFormatter = 
                DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        
        for(String val: row) {
            String[] column = val.split(",");
            /**
             * Test failing at this line. Suspect that String[] column isn't
             * being created with an array of columns for each row properly.
             */
            DateTime dateTime = dtFormatter.parseDateTime(column[0]);
            float latitude = Float.parseFloat(column[1]);
            float longitude = Float.parseFloat(column[2]);
            float celsius = Float.parseFloat(column[3]);
            Location location = new Location(latitude, longitude);
            TemperatureReading tempReading = 
                    new TemperatureReading(dateTime, location, celsius);
            
            temperatureReadings.add(tempReading);
        }
        
        return temperatureReadings;
    }
}
