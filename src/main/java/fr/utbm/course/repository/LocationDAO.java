/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.repository;

import fr.ubtm.course.utils.HibernateUtil;
import fr.utbm.course.entity.Location;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Toaxyx
 */
public class LocationDAO {
    
    public static List<Location> getAllLocation()
    {
        List<Location> locations = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Location");
        locations = query.list();
        return locations;
    }
    
}
