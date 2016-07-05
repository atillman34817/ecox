 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import edu.spcollege.ecox.shared.Location;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author atillman
 */
@Entity
public class TemperatureSensor {
    
    @Id
    @GeneratedValue
    private long tempSensorId;
    private String name;
    private Location currentLocation;
    
    @OneToMany(targetEntity=TemperatureReading.class, mappedBy="temperatureSensor")
    private List<TemperatureReading> readings;
    
    public TemperatureSensor() {
        readings = new ArrayList<>();
    }
    
    public TemperatureSensor(String name, Location location){
        this.name = name;
        this.currentLocation = location;
        readings = new ArrayList<>();
    }
    
    public List<TemperatureReading> getReadings() {
        return this.readings;  
    }

    public long getTempSensorId() {
        return tempSensorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}