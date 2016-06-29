/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import edu.spcollege.ecox.image.ImageService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author brad
 */
@Controller
public class FileUploadController {

    @Autowired
    private UploadStrategyFactory uploadStrategy;
    
    @RequestMapping(value = "/fileupload", method = RequestMethod.GET)
    public String displayForm(Model model) {
        model.addAttribute("uploadForm", new FileUploadForm());
        return "fileupload/fileupload";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String importFile(@ModelAttribute("uploadForm") FileUploadForm fileUploads, Model model) throws IOException {
        String pageTitle = "Upload file";

        String contentType;
        
        contentType = fileUploads.getFiles()[0].getContentType();
        try {
            UploadStrategy strategy = uploadStrategy.create(fileUploads.getFiles()[0].getContentType());
            model.addAttribute("map", strategy.upload(fileUploads));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "fileupload/success";

    }

    @RequestMapping(value = "/uploadSuccess")
    public String success(Model model) {
        String pageTitle = "File uploaded";
        //BreadCrumbs.set(model, pageTitle);
        return "fileupload/success";
    }

}
