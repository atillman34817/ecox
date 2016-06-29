/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import edu.spcollege.ecox.image.ImageService;
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
    
    
    public UploadStrategy create(String fileExtension){
        if (fileExtension.equalsIgnoreCase("image/jpeg"))
            return imageStrategy;
        
        return null;
    }
}
