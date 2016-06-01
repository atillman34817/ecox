/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.infrastructure.sensors;

import java.io.FileNotFoundException;

/**
 *
 * @author Trevor
 */
public class SensorNotFoundException extends FileNotFoundException{
    
    SensorNotFoundException() {
        super("No Sensor found!");
    }
}
