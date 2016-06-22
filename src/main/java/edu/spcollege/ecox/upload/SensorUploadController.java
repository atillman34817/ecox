/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Douglas
 */
@Controller
public class SensorUploadController {
    
    @RequestMapping(value = "/sensorupload")
    public String sensorUpload() {
        return "sensorupload/sensorupload";
    
    }
}        

  
