/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.service;

import fr.utbm.course.entity.Location;
import fr.utbm.course.repository.LocationDAO;
import java.util.List;

/**
 *
 * @author Toaxyx
 */
public class LocationService {
    
    public static List<Location> getAllLocation()
    {
        List<Location> locations;
        locations = LocationDAO.getAllLocation();
        return locations;
    }
}
