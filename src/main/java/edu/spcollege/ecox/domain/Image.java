/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 *
 * @author James
 */
@Entity
public class Image implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private Timestamp timestamp;
    private byte[] bytes;

    public Image() {
    }

    public Image(byte[] bytes, String name, Timestamp timeStamp) {
        this.bytes = bytes;
        this.name = name;
        this.timestamp = timeStamp;
    }

    @Override
    public boolean equals(Object object) {
        boolean testConclusion = false;

        //Testing for null object or different class
        if (object == null || object.getClass() != getClass()) {
            testConclusion = false;
        } else {

            //Casting object to Image and assigning reference
            Image image = (Image) object;

            //Comparing name and timestamp to determine uniqueness
            if (this.name == image.name && this.timestamp == image.timestamp) {
                testConclusion = true;
            }
        }

        return testConclusion;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 7 * hash + this.name.hashCode();
        hash = 7 * hash + this.timestamp.hashCode();
        return hash;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
