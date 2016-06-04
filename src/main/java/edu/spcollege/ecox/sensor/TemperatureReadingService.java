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

public class TemperatureReadingService {
    private final String NOT_FOUND_ERROR = "Temperature reading not found!";
    
    @Autowired
    private TemperatureReadingRepository temperatureReadingRepository;
    
    @Transactional
    public TemperatureReading save(TemperatureReading temperatureReading) {
        return temperatureReadingRepository.save(temperatureReading);
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public TemperatureReading findById(Long id) throws FileNotFoundException {
        return getReading(id);
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public TemperatureReading update(TemperatureReading temperatureReading)
            throws FileNotFoundException {
        //TODO: finish update after TemperatureReading has an ID
        return temperatureReading;
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public TemperatureReading delete(long id)
            throws FileNotFoundException {
        TemperatureReading temperatureReading = getReading(id);
        return temperatureReading;
    }
    
    private TemperatureReading getReading(Long id) 
            throws FileNotFoundException {
        TemperatureReading tempReading = temperatureReadingRepository.findOne(id);
        if (tempReading == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        return tempReading;
    }
}