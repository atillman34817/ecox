/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import edu.spcollege.ecox.sensor.TemperatureReader;
import edu.spcollege.ecox.shared.Location;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
import junit.framework.Assert;
import org.apache.commons.io.input.ReaderInputStream;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Trevor
 */
public class TemperatureReaderTest {
    
    private TemperatureReader temperatureReader;
    private InputStream stream;
    
    @Before
    public void setUp() {
        String input = "2016-07-04 07:59:20,27.812295,-82.786255,26.980\n" +
                       "2016-07-04 07:59:30,27.812295,-82.786255,27.050\n" +
                       "2016-07-04 07:59:40,27.812295,-82.786255,27.076";
        StringReader reader = new StringReader(input);
        stream = new ReaderInputStream(reader);
        temperatureReader = new TemperatureReader();
    }
    
    @Test
    public void testRead_Returns_CorrectNumberOfTempReadings() {
        List<TemperatureReading> tempReadings = temperatureReader.read(stream);
        Assert.assertEquals(tempReadings.size(), 3);
    }
    
    @Test
    public void testRead_ParsesReadingCorrectly(){
        List<TemperatureReading> tempReadings = temperatureReader.read(stream);
        TemperatureReading first = tempReadings.get(0);
        Location location = first.getLocation();
        Assert.assertEquals(location.getLatitude(), "27.812295");
        Assert.assertEquals(location.getlongitude(), "-82.786255");
        Assert.assertEquals(first.getCelsius(), "26.980"); 
    }
}
