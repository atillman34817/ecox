/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.spcollege.ecox.sensor;

import java.io.InputStream;
import java.util.List;

/**
 *
 * @author atillman
 */
public interface Reader<S> {
    List<S> read(InputStream inputStream);
}
