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
    private Timestamp timestamp;
    private Location location;
    private String celsius;
    private double fahrenheit;
    
    @ManyToOne
    @JoinColumn(name="tempSensorId")
    private TemperatureSensor temperatureSensor;
    
    public TemperatureReading(){}
    
    public TemperatureReading(DateTime timestamp, 
            Location location,
            String celsius) {
        
        this.timestamp = new Timestamp(timestamp.getMillis());
        this.location = location;
        this.celsius = celsius;
        this.fahrenheit = CtoF(Double.parseDouble(celsius));
    }

    public long getTempReadingId() {
        return tempReadingId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Location getLocation() {
        return location;
    }

    public String getCelsius() {
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
