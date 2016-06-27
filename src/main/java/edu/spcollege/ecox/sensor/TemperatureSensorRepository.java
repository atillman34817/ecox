/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Trevor
 */
public interface TemperatureSensorRepository extends JpaRepository<TemperatureSensor, Long> {
    
}
