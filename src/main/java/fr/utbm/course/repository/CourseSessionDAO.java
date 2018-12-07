/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.repository;

import fr.ubtm.course.utils.HibernateUtil;
import fr.utbm.course.entity.Course;
import fr.utbm.course.entity.CourseSession;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Toaxyx
 */
public class CourseSessionDAO {
    
    public static List<CourseSession> showAllSession() {
        
        List<CourseSession> CourseSessions = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("From CourseSession");
        CourseSessions = query.list();
        return CourseSessions;
    }
    
    public static CourseSession getSessionById(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CourseSession courseSession = (CourseSession) session.get(CourseSession.class, id);
        return courseSession;
    }
}
