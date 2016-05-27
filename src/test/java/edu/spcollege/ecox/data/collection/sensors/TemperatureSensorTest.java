/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.data.collection.sensors;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import edu.spcollege.ecox.data.collection.readers.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author atillman
 */
public class TemperatureSensorTest {
    
    private Reader mockedReader;
    private TemperatureSensor sensor;
    
    public TemperatureSensorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        mockedReader = mock(Reader.class);
        List<String> readings = Arrays.asList("04/02/2016 20:27:05,30", 
                "04/02/2016 20:28:05,40", "04/02/2016 20:29:05,50");
        when(mockedReader.read()).thenReturn(readings);
        
        sensor = new TemperatureSensor();
    }
    
    @After
    public void tearDown() {
    }

    @org.junit.Test
    public void testCaptureReadsFromSDCard() {
        
        sensor.captureFrom(mockedReader);
        
        verify(mockedReader).read();
    }
    
    @org.junit.Test
    public void testCaptureFromReadsAllRows(){
        sensor.captureFrom(mockedReader);
        List<TemperatureReading> sensorReadings = sensor.getReadings();
        
        assertEquals(3, sensorReadings.size());
    }
}
