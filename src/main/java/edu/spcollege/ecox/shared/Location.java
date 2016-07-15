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
    private float latitude;
    private float longtitude;

    public Location() {
    }

    public Location(float latitude, float longtitude) {
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Float.floatToIntBits(this.latitude);
        hash = 37 * hash + Float.floatToIntBits(this.longtitude);
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
        if (Float.floatToIntBits(this.latitude) != Float.floatToIntBits(other.latitude)) {
            return false;
        }
        if (Float.floatToIntBits(this.longtitude) != Float.floatToIntBits(other.longtitude)) {
            return false;
        }
        return true;
    }

    public long GetId() {
        return this.id;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    @Override
    public String toString() {
        return "latitude=" + latitude + ", longtitude=" + longtitude;
    }
    
    
}
