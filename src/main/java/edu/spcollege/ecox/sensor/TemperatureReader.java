/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class TemperatureReader implements Reader<TemperatureReading> {
    
    @Override
    public List<TemperatureReading> read(InputStream inputStream) {
        
        List<TemperatureReading> temperatureReadings = new ArrayList<>();
                
        
        return temperatureReadings;
    }
}
