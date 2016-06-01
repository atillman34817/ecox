/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.infrastructure.sensors;

import edu.spcollege.ecox.data.collection.sensors.TemperatureSensor;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Trevor
 */
public class TemperatureSensorService {
    
    //@AutoWired
    TemperatureSensorRepository temperatureSensorRepository;
    
    @Transactional
    public TemperatureSensor save(TemperatureSensor temperatureSensor) {
        return temperatureSensorRepository.save(temperatureSensor);
    }
    
    @Transactional(rollbackFor = SensorNotFoundException.class)
    public TemperatureSensor findById(Long id) throws SensorNotFoundException {
        return getSensor(id);
    }
    
    @Transactional(rollbackFor = SensorNotFoundException.class)
    public TemperatureSensor update(TemperatureSensor temperatureSensor)
            throws SensorNotFoundException {
        //TODO: finish update after TemperatureSensor has an ID
        return temperatureSensor;
    }
    
    @Transactional(rollbackFor = SensorNotFoundException.class)
    public TemperatureSensor delete(long id)
            throws SensorNotFoundException {
        TemperatureSensor temperatureSensor = getSensor(id);
        return temperatureSensor;
    }
    
    private TemperatureSensor getSensor(Long id) 
            throws SensorNotFoundException {
        TemperatureSensor tempSensor = temperatureSensorRepository.findOne(id);
        if (tempSensor == null) {
            throw new SensorNotFoundException();
        }
        return tempSensor;
    }
}
