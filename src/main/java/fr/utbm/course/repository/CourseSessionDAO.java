/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.repository;

import fr.ubtm.course.utils.HibernateUtil;
import fr.utbm.course.entity.Course;
import fr.utbm.course.entity.CourseSession;
import fr.utbm.course.entity.Location;
import java.util.ArrayList;
import java.util.Date;
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
    
    public static List<CourseSession> getCourseSessionByLocation(String location)
    {
        List<CourseSession> CourseSessions = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM CourseSession as CourseSession WHERE CourseSession.location.city like '%' || ? || '%'");
        query.setParameter(0, location);
        CourseSessions = query.list();
        return CourseSessions;
    }
    
    public static List<CourseSession> getCourseSessionByDate(Date dateSession)
    {
        List<CourseSession> CourseSessions = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM CourseSession as CourseSession WHERE CourseSession.startDate = ? OR CourseSession.endDate = ?");
        query.setParameter(0, dateSession);
        query.setParameter(1,dateSession);
        CourseSessions = query.list();
        return CourseSessions;
    }
}
