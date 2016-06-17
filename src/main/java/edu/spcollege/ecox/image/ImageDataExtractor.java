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
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;
import edu.spcollege.ecox.shared.Location;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Trevor
 */
public class ImageDataExtractor {
    
    public Location getLocation(MultipartFile multipartFile) 
            throws IOException, ImageProcessingException {
        
        // pull GeoLocation object from metadata
        Metadata metadata = getMetadata(multipartFile);
        GpsDirectory gpsDir = metadata.getFirstDirectoryOfType(GpsDirectory.class);
        GeoLocation geoLocation = gpsDir.getGeoLocation();
        
        // create location using lat and lon values from geoLocation
        Location location = new Location((float)geoLocation.getLatitude(), 
                (float)geoLocation.getLongitude());
        
        return location; 
    }
    
    public Timestamp getTimestamp(MultipartFile multipartFile) 
            throws IOException, ImageProcessingException {
        
        Timestamp timestamp;
        try{
            // get original date from exif metadata and convert to timestamp
            Metadata metadata = getMetadata(multipartFile);
            ExifSubIFDDirectory exifDir = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            timestamp = new Timestamp(exifDir.getDateOriginal().getTime());
        } catch (NullPointerException | IOException | ImageProcessingException ex){
            timestamp = null;
        }
        
        return timestamp;
    }
    
    // gets metadata for use by methods to get specific parts of metadata
    private Metadata getMetadata(MultipartFile multipartFile) 
            throws IOException, ImageProcessingException {
        
        // create file that is identical to multipartFile
        File image = new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(image);
        
        // return Metadata object from file
        return ImageMetadataReader.readMetadata(image);
    }
}
