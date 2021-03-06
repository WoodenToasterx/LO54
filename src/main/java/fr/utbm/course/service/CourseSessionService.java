/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.service;

import fr.utbm.course.entity.CourseSession;
import fr.utbm.course.repository.CourseSessionDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Toaxyx
 */
public class CourseSessionService {
    
    public static List<CourseSession> showCourseSession()
    {
        List<CourseSession> courseSessions;
        courseSessions = CourseSessionDAO.showAllSession();
        return courseSessions;
    }
    
    public static CourseSession getSessionById(int id)
    {
        CourseSession session = new CourseSession();
        session = CourseSessionDAO.getSessionById(id);
        return session;
    }
    
    public static List<CourseSession> getCourseSessionByLocation(String location)
    {
        List<CourseSession> courseSessions;
        courseSessions = CourseSessionDAO.getCourseSessionByLocation(location);
        return courseSessions;
    }
    
    public static List<CourseSession> getCourseSessionByDate(Date dateSession)
    {
        List<CourseSession> courseSessions;
        courseSessions = CourseSessionDAO.getCourseSessionByDate(dateSession);
        return courseSessions;
    }
}
