/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.controller;

import fr.utbm.course.entity.Course;
import fr.utbm.course.service.CourseService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
        courses = cs.showCourses();
        request.setAttribute("courses", courses);
        RequestDispatcher RD = request.getRequestDispatcher("Course.jsp");
        RD.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("addCourse") != null)
        {
            String title = request.getParameter("courseTitle");
            Course course = new Course();
            course.setTitle(title);
            cs.addCourse(course);
            RequestDispatcher rd = request.getRequestDispatcher("Course.jsp");
            rd.forward(request, response);
        }
        
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
