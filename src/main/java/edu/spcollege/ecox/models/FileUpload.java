/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.spcollege.ecox.models;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author brad
 */
public class FileUpload {

    private List<MultipartFile> files;

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFile(List<MultipartFile> files) {
        this.files = files;
    }
}