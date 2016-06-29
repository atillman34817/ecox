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
public class TemperatureReadingService {
    
    // File not found exception message
    private final String NOT_FOUND_ERROR = "Temperature reading not found!";
    
    @Autowired
    private TemperatureReadingRepository temperatureReadingRepository;
    
    @Transactional
    public TemperatureReading save(TemperatureReading temperatureReading) {
        return temperatureReadingRepository.save(temperatureReading);
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public TemperatureReading findById(Long id) throws FileNotFoundException {
        TemperatureReading tr = temperatureReadingRepository.findOne(id);
        if (tr == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        return tr;
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public TemperatureReading delete(long id)
            throws FileNotFoundException {
        TemperatureReading tr = temperatureReadingRepository.findOne(id);
        if (tr == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        return tr;
    }
}