/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.ecox.upload;

import java.util.List;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


/**
 *
 * @author brad
 */
public class FileUpload {

  private String description;
    
    // Upload files.
    private CommonsMultipartFile[] fileDatas;
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public CommonsMultipartFile[] getFileDatas() {
        return fileDatas;
    }
 
    public void setFileDatas(CommonsMultipartFile[] fileDatas) {
        this.fileDatas = fileDatas;
    }
}