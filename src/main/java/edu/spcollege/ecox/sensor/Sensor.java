/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import edu.spcollege.ecox.shared.Location;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Trevor
 */
public class Sensor {
    
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private Location location;
    private List <ReadingType> readingTypes;
    
    public Sensor(String name, Location location, ReadingType... readingTypes) {
        this.name = name;
        this.location = location;
        for (ReadingType type : readingTypes) {
            this.readingTypes.add(type);
        }
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

    public List<ReadingType> getReadingTypes() {
        return readingTypes;
    }
    
    public void addReadingType(ReadingType type) {
        this.readingTypes.add(type);
    }
    
    public void removeReadingType(ReadingType type) {
        this.readingTypes.remove(type);
    }
}
