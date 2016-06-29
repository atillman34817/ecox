/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.image;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import edu.spcollege.ecox.shared.Location;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Trevor
 */


@Repository
public interface ImageRepository extends JpaRepository<Image, Long>{
    // JpaRepository interface handles basic CRUD functionality
    // Create, Read, Update, and Delete functions in the database
    
    // add additional functions by defining functions with a specific
    // naming scheme (see Spring-Data documentation)
    //public List<Image> findByTimestampBetween(long startTime, long endTime);
    //public List<Image> findByLocation(Location location);
    //Image findOneByLocation(Location location);
}
