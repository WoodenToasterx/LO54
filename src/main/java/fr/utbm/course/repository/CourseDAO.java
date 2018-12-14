/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.repository;

import fr.ubtm.course.utils.HibernateUtil;
import fr.utbm.course.entity.Course;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Toaxyx
 */
public class CourseDAO {
    
    public static List<Course> showAllCourse() {
        
        List<Course> courses = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From Course");
        courses = query.list();
        return courses;
    }
    
    public static void addCourse(Course cours) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cours);
        transaction.commit();
        session.close();
    }
    
    public static List<Course> getCourseByName(String courseName)
    {
        List<Course> courses = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Course WHERE title like '%' || ? || '%'");
        query.setString(0, courseName);
        courses = query.list();
        return courses;
    }
    
}
