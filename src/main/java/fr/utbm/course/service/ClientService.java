/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.utbm.course.service;

import fr.utbm.course.entity.Client;
import fr.utbm.course.repository.ClientDAO;

/**
 *
 * @author Toaxyx
 */
public class ClientService {
    
    public static void addClientToSession(Client client) 
    {
        ClientDAO.addClientToSession(client);
    }
}
