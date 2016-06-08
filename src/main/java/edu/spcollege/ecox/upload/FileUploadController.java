/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import com.drew.imaging.ImageProcessingException;
import edu.spcollege.ecox.image.Image;
import edu.spcollege.ecox.image.ImageDataExtractor;
import edu.spcollege.ecox.image.ImageService;
import edu.spcollege.ecox.models.FileUpload;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author brad
 */
@Controller
public class FileUploadController {

    @Autowired
    ImageService imageService;
    
    
    @RequestMapping(value = "/fileupload", method = RequestMethod.GET)
    public String displayForm() {
        return "fileupload/fileupload";
    }
    
    @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
    public String save(@ModelAttribute("uploadFile") FileUpload fileUploads, Model map) {

        List<MultipartFile> files = fileUploads.getFiles();
        Image image;

        ImageDataExtractor imageDataExtractor = new ImageDataExtractor();
        if (files != null && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                try {
                    image = new Image(multipartFile.getBytes(), multipartFile.getOriginalFilename(), imageDataExtractor.getTimestamp(multipartFile));
                    imageService.save(image);
                } catch (IOException | ImageProcessingException ex) {
                    Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return "fileupload/success";
    }
}
