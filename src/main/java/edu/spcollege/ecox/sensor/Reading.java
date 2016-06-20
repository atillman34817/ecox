/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Trevor
 */
@Entity
public abstract class Reading implements Serializable {
    
    @Id
    @GeneratedValue
    private long readingId;
    
    @ManyToOne
    @JoinColumn(name="sensorId")
    private Sensor sensor;
    
    public Sensor getSensor() {
        return sensor;
    }
    
    public long getId() {
        return readingId;
    }
}
