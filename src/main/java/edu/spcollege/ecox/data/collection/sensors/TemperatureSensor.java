/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.data.collection.sensors;

import edu.spcollege.ecox.data.collection.readers.Reader;

/**
 *
 * @author atillman
 */
public class TemperatureSensor {

    public void captureFrom(Reader reader) {
        reader.read();
    }
    
}
