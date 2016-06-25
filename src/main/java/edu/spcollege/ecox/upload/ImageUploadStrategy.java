/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import com.drew.imaging.ImageProcessingException;
import edu.spcollege.ecox.image.Image;
import edu.spcollege.ecox.image.ImageDataExtractor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Student
 */
public class ImageUploadStrategy implements UploadStrategy {
    
    @Override
    public Map upload(FileUploadForm fileUpload) {
        Map<String, Boolean> fileStatus = new HashMap();
        
        ImageDataExtractor imageDataExtractor = new ImageDataExtractor();

        for (MultipartFile locationImageFile : fileUpload.getFiles()) {
            try {
                Image img = new Image(locationImageFile.getBytes(),
                        locationImageFile.getOriginalFilename(),
                        imageDataExtractor.getTimestamp(locationImageFile));
                        fileStatus.put(locationImageFile.getOriginalFilename(), true);
                //imageService.save(img);
            } catch (IOException | ImageProcessingException ex) {
                fileStatus.put(locationImageFile.getOriginalFilename(), false);
                Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fileStatus;
    }
}
