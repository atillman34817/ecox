/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import edu.spcollege.ecox.shared.Location;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.joda.time.DateTime;

/**
 *
 * @author atillman
 */
@Entity
public class TemperatureReading {

    @Id
    @GeneratedValue
    private long tempReadingId;
    private Timestamp timeOfReading;
    private Location locationOfReading;
    private double celsius;
    private double fahrenheit;
    
    @ManyToOne
    @JoinColumn(name="tempSensorId")
    private TemperatureSensor temperatureSensor;
    
    public TemperatureReading(){}
    
    public TemperatureReading(DateTime timeOfReading, 
            Location locationOfReading,
            double celsius) {
        
        this.timeOfReading = new Timestamp(timeOfReading.getMillis());
        this.locationOfReading = locationOfReading;
        this.celsius = celsius;
        this.fahrenheit = CtoF(celsius);
    }

    public long getTempReadingId() {
        return tempReadingId;
    }

    public Timestamp getTimeOfReading() {
        return timeOfReading;
    }

    public Location getLocationOfReading() {
        return locationOfReading;
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }
    
    private double CtoF(double celsius) {
        return celsius * 1.8 + 32;
    }
    
}
