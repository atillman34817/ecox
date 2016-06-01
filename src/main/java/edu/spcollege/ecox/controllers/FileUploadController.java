/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.controllers;

import edu.spcollege.ecox.domain.Image;
import edu.spcollege.ecox.infrastructure.images.ImageService;
import edu.spcollege.ecox.models.FileUpload;
import java.util.List;
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

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String displayForm() {
        return "uploadfile";
    }
    
    @RequestMapping(value = "/savefiles", method = RequestMethod.POST)
    public String save(@ModelAttribute("uploadFile") FileUpload fileUploads, Model map) {

        List<MultipartFile> files = fileUploads.getFiles();
        Image image;

        if (files != null && files.size() > 0) {
            for (MultipartFile multipartFile : files) {
                //image = new Image(multipartFile.getBytes(), multipartFile.getOriginalFilename());
                //imageService.save(image);
            }
        }
        return "";
    }
}
