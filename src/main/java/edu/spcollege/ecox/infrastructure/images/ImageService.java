/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.infrastructure.images;

import edu.spcollege.ecox.domain.Image;
import edu.spcollege.ecox.domain.Location;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Trevor
 */

@Service
public class ImageService {
    
    @Resource
    private ImageRepository imageRepository;
    
    @Transactional
    public Image create(Image image) {
        return imageRepository.save(image);
    }
    
    @Transactional
    public Image findById(Long id) throws ImageNotFoundException {
        return getImage(id);
    }
    
    @Transactional
    public List<Image> findByLocation(Location location)
            throws ImageNotFoundException {
        
        List<Image> imagesFound = 
                imageRepository.findByLocation(location);
        
        if (imagesFound.isEmpty()) {
            throw new ImageNotFoundException();
        }
        
        return imagesFound;
    }
    
    @Transactional
    public List<Image> findByTime(Long start, Long end)
        throws ImageNotFoundException {
        
        List<Image> imagesFound = 
                imageRepository.findByTimeStampBetween(start, end);
        
        if (imagesFound.isEmpty()) {
            throw new ImageNotFoundException();
        }
        
        return imagesFound;
    }
    
    @Transactional(rollbackFor = ImageNotFoundException.class)
    public Image update(Image image) throws ImageNotFoundException {
        //TODO: get image from database by arguments id
        //Image oldImage = getImage(image.getId());
        
        //TODO: update oldImage paremeters with the passed images parameters
        return image;
    }
    
    @Transactional(rollbackFor = ImageNotFoundException.class)
    public Image delete(long id) throws ImageNotFoundException {
        Image image = getImage(id);
        imageRepository.delete(id);
        return image;
    }
    
    private Image getImage(Long id) throws ImageNotFoundException {
        Image image = imageRepository.findOne(id);
        if (image == null) {
            throw new ImageNotFoundException();
        }
        return image;
    }
}
