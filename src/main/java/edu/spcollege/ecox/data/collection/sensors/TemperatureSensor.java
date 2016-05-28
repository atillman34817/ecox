/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.data.collection.sensors;

import edu.spcollege.ecox.data.collection.readers.Reader;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import edu.spcollege.ecox.data.collection.readers.Reader;

/**
 *
 * @author atillman
 */
public class TemperatureSensor {

    private List<TemperatureReading> readings;
    
    public TemperatureSensor(){
        readings = new ArrayList<>();
    }
    
    public void captureFrom(Reader reader) {
        List<String> data = reader.read();
        convertReadingsToTemperatureReading(data);
    }

    public List<TemperatureReading> getReadings() {
        return this.readings;  
    }

    private void convertReadingsToTemperatureReading(List<String> in){
        for(String val: in){
            String[] dat = val.split(",");
            DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
            DateTime dt = formatter.parseDateTime(dat[0]);
            TemperatureReading reading = new TemperatureReading(dt, dat[1]);
            readings.add(reading);
        }
    }
}
