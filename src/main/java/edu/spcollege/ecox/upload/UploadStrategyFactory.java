/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.upload;

/**
 *
 * @author Student
 */
public class UploadStrategyFactory {
    
    public static UploadStrategy create(String fileExtension){
        if (fileExtension.equalsIgnoreCase("image/jpeg"))
            return new ImageUploadStrategy();
        
        return null;
    }
}
