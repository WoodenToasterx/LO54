/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.controller;

import fr.utbm.course.entity.Client;
import fr.utbm.course.entity.Course;
import fr.utbm.course.entity.CourseSession;
import fr.utbm.course.entity.Location;
import fr.utbm.course.service.ClientService;
import fr.utbm.course.service.CourseService;
import fr.utbm.course.service.CourseSessionService;
import fr.utbm.course.service.LocationService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    CourseSessionService css = new CourseSessionService();
    LocationService ls = new LocationService();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        List<Course> courses;
        List<CourseSession> courseSession;
        List<Location> locations;
        courses = cs.showCourses();
        courseSession = CourseSessionService.showCourseSession();
        locations = ls.getAllLocation();       
        
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
        request.setAttribute("locations", locations);
        RequestDispatcher RD = request.getRequestDispatcher("Course.jsp");
        RD.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("FilterCourseName") != null)
        {
            String courseName = request.getParameter("courseName");
            List<Course> courseList = new ArrayList<Course>();
            courseList = cs.showCoursesByName(courseName);
              
            List<CourseSession> courseSession;
            courseSession = CourseSessionService.showCourseSession();

            Map<Course, List<CourseSession>> Array = new HashMap<Course, List<CourseSession>>();

            for (Course item : courseList) {
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
            RequestDispatcher rd = request.getRequestDispatcher("Course.jsp");
            rd.forward(request, response);
        }
        if(request.getParameter("FilterSessionDate") != null)
        {
            String dateSession = request.getParameter("sessionDate");
            
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date dateConverti = null;
            try {
                dateConverti = format.parse(dateSession);
            } catch (ParseException ex) {
                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
            }
            List<Course> courseList = new ArrayList<Course>();
            courseList = cs.showCourses();
             
            List<Location> locations;
            locations = ls.getAllLocation();       
            
            List<CourseSession> courseSession;
            courseSession = CourseSessionService.getCourseSessionByDate(dateConverti);

            Map<Course, List<CourseSession>> Array = new HashMap<Course, List<CourseSession>>();

            for (Course item : courseList) {
                List<CourseSession> listSessionByCourse = new ArrayList<CourseSession>();
                for(CourseSession coursesession : courseSession)
                {
                    if(coursesession.getCourse().getId() == item.getId())
                    {
                        listSessionByCourse.add(coursesession);
                    }
                }
                if(listSessionByCourse.isEmpty() != true)
                {
                    Array.put(item, listSessionByCourse);
                }
            }
            request.setAttribute("items", Array);
            request.setAttribute("locations", locations);
            RequestDispatcher rd = request.getRequestDispatcher("Course.jsp");
            rd.forward(request, response);
        }
        if(request.getParameter("FilterCourseLocation") != null)
        {
            String locationName = request.getParameter("courseLocation");
            List<Course> courseList = new ArrayList<Course>();
            courseList = cs.showCourses();
             
            List<Location> locations;
            locations = ls.getAllLocation();       
            
            List<CourseSession> courseSession;
            courseSession = CourseSessionService.getCourseSessionByLocation(locationName);

            Map<Course, List<CourseSession>> Array = new HashMap<Course, List<CourseSession>>();

            for (Course item : courseList) {
                List<CourseSession> listSessionByCourse = new ArrayList<CourseSession>();
                for(CourseSession coursesession : courseSession)
                {
                    if(coursesession.getCourse().getId() == item.getId())
                    {
                        listSessionByCourse.add(coursesession);
                    }
                }
                if(listSessionByCourse.isEmpty() != true)
                {
                    Array.put(item, listSessionByCourse);
                }
            }
            request.setAttribute("items", Array);
            request.setAttribute("locations", locations);
            RequestDispatcher rd = request.getRequestDispatcher("Course.jsp");
            rd.forward(request, response);
        }
        
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("addClient") != null)
        {
            List<Course> courses;
            List<CourseSession> courseSession;
            List<Location> locations;
            courses = cs.showCourses();
            courseSession = CourseSessionService.showCourseSession();
            locations = ls.getAllLocation();       

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
        
            Client client = new Client();
            client.setLastname(request.getParameter("lastname"));
            client.setFirstname(request.getParameter("firstname"));
            client.setAddress(request.getParameter("address"));
            client.setEmail(request.getParameter("email"));
            client.setPhone(request.getParameter("phone"));
            int id = Integer.parseInt(request.getParameter("sessionId"));
            
            CourseSession session = css.getSessionById(id);   
            client.setCourseSession(session);
            ClientService.addClientToSession(client);
            
            request.setAttribute("items", Array);
            request.setAttribute("locations", locations);
            RequestDispatcher rd = request.getRequestDispatcher("Course.jsp");
            rd.forward(request, response);
        }
        
       
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
