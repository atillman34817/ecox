/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import edu.spcollege.ecox.shared.Location;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
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
        String encoding = "UTF-8";
        List<TemperatureReading> temperatureReadings = new ArrayList<>();
        
        try {
            String input = IOUtils.toString(inputStream, encoding);
            
            String[] row = input.split("\n");
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
        } catch (IOException ex) {
            Logger.getLogger(TemperatureReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return temperatureReadings;
    }
}
