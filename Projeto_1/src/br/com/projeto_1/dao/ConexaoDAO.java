/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_1.dao;

import java.sql.*;

public class ConexaoDAO {
    
    public static Connection con = null;
    
    
    
    
    
    public ConexaoDAO() {       
    }
      public static void ConectDB(){
          try {
              
              String dsn = "Projeto_1";
              String user = "postgres";
              String senha = "postdba";
              DriverManager.registerDriver(new org.postgresql.Driver());
              
              String url = "jdbc:postgresql://localhost:5432/" + dsn;
              
              con = DriverManager.getConnection(url, user, senha);
              
              con.setAutoCommit(false);
              if(con == null) {
                  System.out.println("erro ao abrir  o banco ");
                  
              }
          }
              catch (SQLException e) {
              System.out.println("Problema ao abrir a base de dados!"  +
                      e.getMessage());
              
          }

      }
      
      public static void closeDB(){
          try{
              con.close();
          }catch(Exception e){
              System.out.println(e.getMessage());
          }
      }
        
}
// fecha classe