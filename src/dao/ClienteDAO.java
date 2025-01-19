/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import beans.Clientes;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import forms.RelatorioCadastroCliente;
/**
 *
 * @author hidek
 */
public class ClienteDAO {
     private Conexao conexao; //criando o objeto da classe Conexao
    private Connection conn; //criando a conexao que permitira o CRUD
    
  public ClienteDAO(){ // criando o construtor da classe 

this.conexao = new Conexao();

}
  public void inserir(Clientes cliente){ //metodo para cadastrar clientes 
    this.conn = this.conexao.getConexao();
    String sql ="INSERT INTO clientes (nome,cpf,telefone,end) VALUES"+"(?,?,?,?)";
    try{
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1,cliente.getNome());
        stmt.setString(2, cliente.getCpf());   
        stmt.setString(3,cliente.getTelefone());
        stmt.setString(4,cliente.getEnd());
        stmt.execute();
        
        JOptionPane.showMessageDialog(null,"Cliente inserido com sucesso!!");
        
    }catch(Exception e){
        System.out.println("Erro ao inserir cliente : "+e.getMessage());
    }
    this.conexao.desconectar(this.conn);
}
  
  public Clientes getCliente (int id){ //metodo para buscar clientes a partir do id 
    this.conn = this.conexao.getConexao();
      String sql = "SELECT * FROM clientes WHERE id = ?";
      try{
          PreparedStatement stmt = this.conn.prepareStatement(sql);
          stmt.setInt(1, id);
          ResultSet rs = stmt.executeQuery();
        
          Clientes cliente = new Clientes();
          rs.next();
          cliente.setId(id);
          cliente.setNome(rs.getString("nome"));
          cliente.setCpf(rs.getString("cpf"));
          cliente.setTelefone(rs.getString("telefone"));
          cliente.setEnd(rs.getString("end"));
          
          return cliente;
          
      }catch (Exception e) {
          System.out.println("erro: " + e.getMessage());
          return null;
      }
      finally{
          this.conexao.desconectar(this.conn);
      }
  }

  
public  List<Clientes> getClientes(String nome){//metodo para buscar Cliente por nome
    this.conn = this.conexao.getConexao();
                String sql = "SELECT * FROM clientes WHERE nome LIKE ?";
                
              try {
                    PreparedStatement stmt = this.conn.prepareStatement(sql);
                   stmt.setString(1,"%" + nome + "%"); //Conforme for a palavra ou letra digitada para pesquisa,
                    ResultSet rs = stmt.executeQuery();       
                    List<Clientes> listaCliente = new ArrayList<>();
                    
                    while (rs.next()) { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                        Clientes cliente = new Clientes();
                        
                    cliente.setId(rs.getInt("id"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setEnd(rs.getString("end"));
                    
                        
                        listaCliente.add(cliente);    
                    }
                    return listaCliente;
                    
                    
                    
                } catch (Exception e) {
                    return null;
                }
                finally {
                    this.conexao.desconectar(this.conn);
             }
                
            }
  
  public void excluir (int id){
    this.conn = this.conexao.getConexao();
       
                
                String sql = "DELETE FROM clientes WHERE id = ?";
                try {
                    //esse trecho é igual ao método editar e inserir
                    PreparedStatement stmt = this.conn.prepareStatement(sql);
                    stmt.setInt(1, id);
                    
                    //Executando a query
                    stmt.execute();
                    
                    JOptionPane.showMessageDialog(null,"Cliente  "+id+" excluído com sucesso.");
                    
                    //tratando o erro, caso ele ocorra
                } catch (Exception e) {
                    System.out.println("Erro ao excluir cliente: " + e.getMessage());
                }
                this.conexao.desconectar(this.conn);
            }
  
  
    
}
