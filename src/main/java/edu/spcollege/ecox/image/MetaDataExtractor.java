/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import edu.spcollege.ecox.shared.Location;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Trevor
 */
public class MetaDataExtractor {
    
    public Location getLocation(MultipartFile multipartFile) 
            throws IOException, ImageProcessingException {
        
        File image = new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(image);
        Metadata metadata = ImageMetadataReader.readMetadata(image);
        GpsDirectory gpsDir = metadata.getFirstDirectoryOfType(GpsDirectory.class);
        GeoLocation geoLocation = gpsDir.getGeoLocation();
        Location location = new Location((float)geoLocation.getLatitude(), 
                (float)geoLocation.getLongitude());
        
        return location; 
    }
}
