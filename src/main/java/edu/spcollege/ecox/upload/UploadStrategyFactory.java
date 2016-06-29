/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Student
 */
@Component
public class UploadStrategyFactory {
    
    @Autowired
    private ImageUploadStrategy imageStrategy;
    
    @Autowired
    private TemperatureUploadStrategy temperatureUploadStrategy;
    
    public UploadStrategy create(String fileExtension){
        if (fileExtension.equalsIgnoreCase("image/jpeg"))
            return imageStrategy;
        if (fileExtension.equalsIgnoreCase("application/octet-stream"))
            return temperatureUploadStrategy;
        
        return null;
    }
}
