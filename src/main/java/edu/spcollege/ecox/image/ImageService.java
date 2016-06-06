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
    
    private final String NOT_FOUND_ERROR = "Image not found!";
    
    @Autowired
    private ImageRepository imageRepository;
    
    @Transactional
    public Image save(Image image) {
        return imageRepository.save(image);
    }
    
    @Transactional
    public Image findById(Long id) throws FileNotFoundException {
        return getImage(id);
    }
    
    @Transactional
    public List<Image> findByLocation(Location location)
            throws FileNotFoundException {
        
        List<Image> imagesFound = 
                imageRepository.findByLocation(location);
        
        if (imagesFound.isEmpty()) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        
        return imagesFound;
    }
    
    @Transactional
    public List<Image> findByTime(Long start, Long end)
        throws FileNotFoundException {
        
        List<Image> imagesFound = 
                imageRepository.findByTimestampBetween(start, end);
        
        if (imagesFound.isEmpty()) {
            throw new FileNotFoundException();
        }
        
        return imagesFound;
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public Image update(Image image) throws FileNotFoundException {
        Image oldImage = getImage(image.getId());
        
        //TODO: update oldImage paremeters with the passed images parameters
        return image;
    }
    
    @Transactional(rollbackFor = FileNotFoundException.class)
    public Image delete(long id) throws FileNotFoundException {
        Image image = getImage(id);
        imageRepository.delete(id);
        return image;
    }
    
    private Image getImage(Long id) throws FileNotFoundException {
        Image image = imageRepository.findOne(id);
        if (image == null) {
            throw new FileNotFoundException(NOT_FOUND_ERROR);
        }
        return image;
    }
}