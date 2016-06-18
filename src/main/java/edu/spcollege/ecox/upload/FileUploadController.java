/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import com.drew.imaging.ImageProcessingException;
import edu.spcollege.ecox.Application;
import edu.spcollege.ecox.image.Image;
import edu.spcollege.ecox.image.ImageDataExtractor;
import edu.spcollege.ecox.image.ImageService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String displayForm(Model model) {
        model.addAttribute("uploadForm", new FileUpload());
        return "fileupload/fileupload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String importFile(@ModelAttribute("uploadForm") FileUpload uploadedFiles, Model model) throws IOException {
        String pageTitle = "Upload file";
        List<String> fileNamesSucceeded = new ArrayList<>();
        List<String> fileNamesFailed = new ArrayList<>();

        ImageDataExtractor imageDataExtractor = new ImageDataExtractor();

        for (MultipartFile locationImageFile : uploadedFiles.getFiles()) {
            try {
                Image img = new Image(locationImageFile.getBytes(),
                        locationImageFile.getOriginalFilename(),
                        imageDataExtractor.getTimestamp(locationImageFile));
                fileNamesSucceeded.add(locationImageFile.getOriginalFilename());
                //imageService.save(img);
            } catch (IOException | ImageProcessingException ex) {
                fileNamesFailed.add(locationImageFile.getOriginalFilename());
                Logger.getLogger(FileUploadController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        model.addAttribute("fileNamesSucceeded", fileNamesSucceeded);
        model.addAttribute("fileNamesFailed", fileNamesFailed);
        // Redirect to a successful upload page
        return "fileupload/success";
        //return "redirect:uploadSuccess";
    }

    @RequestMapping(value = "/uploadSuccess")
    public String success(Model model) {
        String pageTitle = "File uploaded";
        //BreadCrumbs.set(model, pageTitle);
        return "fileupload/success";
    }

}
