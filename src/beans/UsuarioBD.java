
package beans;

/**
 *
 * @author hidek
 */
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;


public class UsuarioBD {
    
  
  // METODO INSEGURO - nao criar o metodo desta forma
    
    public static Usuario validarUsuarioInSeguro(Usuario usuario){
        
        //criando consulta parametrizada
        String sql = "SELECT * FROM usuario WHERE login = "+usuario.getLogin()+" AND senha = " +usuario.getSenha() ;
        Usuario usuarioEncontrado = null;
        
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/login_exemplo","root","");
            PreparedStatement statement = conn.prepareStatement(sql);
            
            //atribuindo valores para a consulta, vindas do preenchimento dos campos:
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
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
    
    
}
