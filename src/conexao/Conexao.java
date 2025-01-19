/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author hidek
 */

public class Conexao {
    public Connection getConexao(){  //criando metodo para conectar ao bd
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/confeiteiro","root","");
            return conn;
        }catch (Exception e){
            System.out.println("erro ao conectar ao BD :"+e.getMessage());
            return null;
        }
    }
    
    public void desconectar (Connection conn){ //criando metodo para desconectar o BD
        
        try{
            if (conn !=null &&!conn.isClosed()){
                conn.close();
                System.out.println ("BD desconectado");
            }
        }catch (SQLException ex){
            System.out.println("Não foi possível desconectar o BD");
        }
        
        
    }
    
}
