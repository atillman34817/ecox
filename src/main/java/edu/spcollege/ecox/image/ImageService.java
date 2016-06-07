/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.image;

import edu.spcollege.ecox.shared.Location;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Trevor
 */


@Service
public class ImageService {
    
    // File not found exception message
    private final String NOT_FOUND_ERROR = "Image not found!";
    
    @Autowired // injecting imageRepository for database functions
    private ImageRepository imageRepository;
    
    @Transactional // annotation for anything that interacts with the database
    public Image save(Image image) {
        return imageRepository.save(image);
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public Image findById(Long id) throws FileNotFoundException {
        Image image = imageRepository.findOne(id);
        if (image == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        return image;
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public List<Image> findByLocation(Location location)
            throws FileNotFoundException {
        
        List<Image> images = imageRepository.findByLocation(location);        
        if (images.isEmpty()) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }        
        return images;
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public List<Image> findByTime(Long start, Long end)
        throws FileNotFoundException {
        
        List<Image> images = imageRepository.findByTimestampBetween(start, end);        
        if (images.isEmpty()) {
            throw new FileNotFoundException();
        }        
        return images;
    }
    
    /*
     *TODO: update oldImage paremeters with the passed images parameters
    @Transactional(rollbackFor = FileNotFoundException.class)
    public Image update(Image image) throws FileNotFoundException {
        Image oldImage = imageRepository.findOne(image.getId());
        
        
        return image;
    }
    */
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public Image delete(long id) throws FileNotFoundException {
        Image image = imageRepository.findOne(id);
        if (image == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        imageRepository.delete(id);
        return image;
    }
}