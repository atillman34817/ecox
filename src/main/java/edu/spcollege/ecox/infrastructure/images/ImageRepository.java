/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.infrastructure.images;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import edu.spcollege.ecox.domain.Image;
import edu.spcollege.ecox.domain.Location;
/**
 *
 * @author Trevor
 */
public interface ImageRepository extends JpaRepository<Image, Long>{
    public List<Image> findByTimeStampBetween(long startTime, long endTime);
    public List<Image> findByLocation(Location location);
}
