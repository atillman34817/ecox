/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Trevor
 */

@Service
public class SensorService {
    
    private final String NOT_FOUND_ERROR = "Sensor not found!";
    
    @Autowired
    private SensorRepository sensorRepository;
    
    @Transactional
    public Sensor save(Sensor sensor) {
        return sensorRepository.save(sensor);
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public Sensor findById(Long id) throws FileNotFoundException {
        Sensor sensor = sensorRepository.findOne(id);
        if (sensor == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        return sensor;
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public Sensor delete(long id) throws FileNotFoundException {
        Sensor sensor = sensorRepository.findOne(id);
        if (sensor == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        sensorRepository.delete(id);
        return sensor;
    }
}
