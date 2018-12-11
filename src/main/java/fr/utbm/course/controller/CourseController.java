/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.controller;

import fr.utbm.course.entity.Course;
import fr.utbm.course.entity.CourseSession;
import fr.utbm.course.service.CourseService;
import fr.utbm.course.service.CourseSessionService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Toaxyx
 */
public class CourseController extends HttpServlet {
    
    CourseService cs = new CourseService();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        List<Course> courses;
        List<CourseSession> courseSession;
        courses = cs.showCourses();
        courseSession = CourseSessionService.showCourseSession();
        
        Map<Course, List<CourseSession>> Array = new HashMap<Course, List<CourseSession>>();
        
        for (Course item : courses) {
            List<CourseSession> listSessionByCourse = new ArrayList<CourseSession>();
            for(CourseSession coursesession : courseSession)
            {
                if(coursesession.getCourse().getId() == item.getId())
                {
                    listSessionByCourse.add(coursesession);
                }
            }
            Array.put(item, listSessionByCourse);
        }
        
        request.setAttribute("items", Array);
        RequestDispatcher RD = request.getRequestDispatcher("Course.jsp");
        RD.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
