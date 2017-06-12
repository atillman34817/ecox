/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.shared;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author James
 */
@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String latitude;
    private String longitude;

    public Location() {
    }

    public Location(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Float.floatToIntBits(Integer.parseInt(this.latitude));
        hash = 37 * hash + Float.floatToIntBits(Integer.parseInt(this.longitude));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (Float.floatToIntBits(Integer.parseInt(this.latitude)) != Float.floatToIntBits(Integer.parseInt(other.latitude))) {
            return false;
        }
        if (Float.floatToIntBits(Integer.parseInt(this.longitude)) != Float.floatToIntBits(Integer.parseInt(other.longitude))) {
            return false;
        }
        return true;
    }

    public long GetId() {
        return this.id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getlongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "latitude=" + latitude + ", longitude=" + longitude;
    }
    
    
}
