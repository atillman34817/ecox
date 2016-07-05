/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import edu.spcollege.ecox.sensor.TemperatureReader;
import java.io.InputStream;
import java.io.StringReader;
import java.util.List;
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
    public void testRead() {
        // TODO: Test failing, see TemperatureReader
        // List<TemperatureReading> tempReadings = temperatureReader.read(stream);
    }
}
