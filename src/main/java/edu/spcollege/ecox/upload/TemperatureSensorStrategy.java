/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Student
 */
public class TemperatureSensorStrategy implements UploadStrategy {
    
    @Override
    public Map upload(FileUploadForm FileUpload) {
        Map<String, Boolean> fileStatus = new HashMap();
    
        return fileStatus;
    }
}
