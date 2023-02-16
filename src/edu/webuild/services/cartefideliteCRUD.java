/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.services;
//interfaces

import edu.webuild.interfaces.InterfacecarteCRUD;
//model
import edu.webuild.model.Abonnement;
import edu.webuild.model.Cartefidelite;

//utils

import edu.webuild.utils.MyConnection;

//java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author mtirn
 */

public class cartefideliteCRUD extends InterfacecarteCRUD{
    Statement ste;
    Connection conn = MyConnection.getInstance().getConn();
    
    
  
    
    
}
