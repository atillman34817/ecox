/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import edu.spcollege.ecox.sensor.TemperatureReader;
import edu.spcollege.ecox.sensor.TemperatureReading;
import edu.spcollege.ecox.sensor.TemperatureReadingService;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Student
 */
@Component
public class TemperatureUploadStrategy implements UploadStrategy {

    @Autowired
    TemperatureReadingService temperatureReadingService;

    @Override
    public Map upload(FileUploadForm fileUpload) {

        Map<String, Boolean> fileStatus = new HashMap();
        TemperatureReader reader = new TemperatureReader();
        List<TemperatureReading> readings;

        for (MultipartFile temperatureFile : fileUpload.getFiles()) {
            try {
                readings = reader.read(temperatureFile.getInputStream());
                for (TemperatureReading reading : readings) {
                        temperatureReadingService.save(reading);                  
                }
                fileStatus.put(temperatureFile.getOriginalFilename(), Boolean.TRUE);
            } catch (Exception ex) {
                fileStatus.put(temperatureFile.getOriginalFilename(), Boolean.FALSE);
                Logger.getLogger(TemperatureUploadStrategy.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
        return fileStatus;
    }
}
