/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import edu.spcollege.ecox.shared.Location;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Trevor
 */
@Entity
public class Sensor implements Serializable {
    
    @Id
    @GeneratedValue
    private long sensorId;
    
    private String name;
    private Location location;
    @OneToMany(targetEntity=Reading.class, mappedBy="sensor")
    private List<Reading> readings;
    
    protected Sensor(){}
    
    public Sensor(String name, Location location) {
        this.name = name;
        this.location = location;
    }
    
    public long getId() {
        return sensorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    
    public List<Reading> getReadings() {
        return readings;
    }
}
