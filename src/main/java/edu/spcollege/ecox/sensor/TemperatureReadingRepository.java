/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Trevor
 */

@Repository
public interface TemperatureReadingRepository 
        extends JpaRepository<TemperatureReading, Long>{
    // for JpaRepository explanation, see ImageRepository
    
}