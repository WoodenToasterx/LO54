/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ubtm.course.utils;

import fr.utbm.course.entity.Client;
import fr.utbm.course.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Valou'
 */
public class GenerateSchema {

     public static void main(String[] args) {
         Session session = null;
         try{
              session = HibernateUtil.getSessionFactory().openSession();
              Transaction T = session.beginTransaction();
              Course cli = new Course();
              cli.setId(1);
              cli.setTitle("Math");
              session.persist(cli);
              T.commit();
              
         }catch(Exception e)
         {
             System.out.println(e.getStackTrace().toString());
         }
              
         
         System.out.println("aa");
           
   }
    
}
