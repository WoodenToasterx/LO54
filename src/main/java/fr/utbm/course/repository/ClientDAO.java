/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.repository;

import fr.ubtm.course.utils.HibernateUtil;
import fr.utbm.course.entity.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Toaxyx
 */
public class ClientDAO {
    
    public static void addClientToSession(Client client)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(client);
        transaction.commit();
        session.close();
    }
    
}
