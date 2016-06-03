/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.joda.time.DateTime;

/**
 *
 * @author atillman
 */
@Entity
public class TemperatureReading {

    @Id
    @GeneratedValue
    private long Id;
    
    public TemperatureReading(){}
    
    public TemperatureReading(DateTime dt, String string) {
        
    }
    
}
