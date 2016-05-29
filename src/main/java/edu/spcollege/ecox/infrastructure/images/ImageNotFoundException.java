/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.infrastructure.images;

import java.io.FileNotFoundException;

/**
 *
 * @author Trevor
 */
public class ImageNotFoundException extends FileNotFoundException {

    ImageNotFoundException() {
        super("No images found!");
    }
}
