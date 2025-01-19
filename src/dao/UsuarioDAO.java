/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Usuario;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hidek
 */
public class UsuarioDAO {
    private Conexao conexao; //criando o objeto da classe Conexao
    private Connection conn; //criando a conexao que permitira o CRUD
    


  public UsuarioDAO(){ // criando o construtor da classe 

this.conexao = new Conexao();

}

    public  Usuario validarUsuarioSeguro(String login, String senha){
        
        //criando consulta parametrizada
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        this.conn = this.conexao.getConexao();
        Usuario usuarioEncontrado = null;
        
        try{
           
            PreparedStatement statement = conn.prepareStatement(sql);
            
            //atribuindo valores para a consulta, vindas do preenchimento dos campos:
            statement.setString(1, login);
            statement.setString(2, senha);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()){
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
                 }
        }catch (SQLException ex){
            System.out.println ("Sintaxe de comando inválida");
            
        }
        return usuarioEncontrado;
    }

  
  
  
  
public Usuario getTipo (int id){ //metodo para buscar usuario a partir do id 
    this.conn = this.conexao.getConexao();
      String sql = "SELECT * FROM usuario WHERE id = ?";
      try{
          PreparedStatement stmt = this.conn.prepareStatement(sql);
          stmt.setInt(1, id);
          ResultSet rs = stmt.executeQuery();
        
          Usuario usuario = new Usuario();
          rs.next();
          usuario.setTipo(rs.getString("tipo"));
          return usuario;
          
      }catch (Exception e) {
          System.out.println("erro: " + e.getMessage());
          return null;
      }
}


}
