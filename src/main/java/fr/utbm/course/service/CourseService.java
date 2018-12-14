/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.service;

import fr.utbm.course.entity.Course;
import fr.utbm.course.repository.CourseDAO;
import java.util.List;

/**
 *
 * @author Toaxyx
 */
public class CourseService {
    
    public static List<Course> showCourses()
    {
        List<Course> courses;
        courses = CourseDAO.showAllCourse();
        return courses;
    }
    
    public static void addCourse(Course cours)
    {
        CourseDAO.addCourse(cours);
    }
    
    public static List<Course> showCoursesByName(String courseName)
    {
        List<Course> courses;
        courses = CourseDAO.getCourseByName(courseName);
        return courses;
    }
}
