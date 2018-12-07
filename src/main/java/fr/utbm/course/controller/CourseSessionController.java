/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.controller;

import fr.utbm.course.entity.Client;
import fr.utbm.course.entity.Course;
import fr.utbm.course.entity.CourseSession;
import fr.utbm.course.service.ClientService;
import fr.utbm.course.service.CourseSessionService;
import java.io.IOException;
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
public class CourseSessionController  extends HttpServlet {
    
    CourseSessionService cs = new CourseSessionService();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<CourseSession> Sessions;
        Sessions = cs.showCourseSession();
        request.setAttribute("Sessions", Sessions);
        RequestDispatcher RD = request.getRequestDispatcher("CourseSession.jsp");
        RD.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("addClient") != null)
        {
            //String title = request.getParameter("courseTitle");
            Client client = new Client();
            client.setLastname(request.getParameter("lastname"));
            client.setFirstname(request.getParameter("firstname"));
            client.setAddress(request.getParameter("address"));
            client.setEmail(request.getParameter("email"));
            client.setPhone(request.getParameter("phone"));
            int id = Integer.parseInt(request.getParameter("session"));
            
            CourseSession courseSession = cs.getSessionById(id);   
            client.setCourseSession(courseSession);
            ClientService.addClientToSession(client);
            RequestDispatcher rd = request.getRequestDispatcher("Client.jsp");
            rd.forward(request, response);
        }
    }

    public String getServletInfo() {
        return "Short description";
    }
}
