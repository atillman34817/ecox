/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Trevor
 */
public class TemperatureSensorService {
    
    private final String NOT_FOUND_ERROR = "Temperature sensor not found!";
    
    @Autowired
    private TemperatureSensorRepository temperatureSensorRepository;
    
    @Transactional
    public TemperatureSensor save(TemperatureSensor temperatureSensor) {
        return temperatureSensorRepository.save(temperatureSensor);
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public TemperatureSensor findById(Long id) throws FileNotFoundException {
        TemperatureSensor temperatureSensor = temperatureSensorRepository.findOne(id);
        if (temperatureSensor == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        return temperatureSensor;
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public TemperatureSensor delete(long id) throws FileNotFoundException {
        TemperatureSensor temperatureSensor = temperatureSensorRepository.findOne(id);
        if (temperatureSensor == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        temperatureSensorRepository.delete(id);
        return temperatureSensor;
    }

}
