
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    public boolean existeUsuario (Usuario usuario) throws Exception {
        String sql = "select * from Login where email = ? and senha = ?";
        try (Connection conn = ConnectionDatabase.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
        
    }
    public boolean existeEmail (Usuario usuario) throws Exception {
        String sql = "select * from Login where email = ?";
        try (Connection conn = ConnectionDatabase.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getEmail());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
        
    }
    public static void adicionarSenha(Usuario usuario) throws Exception {
        String sql = "INSERT INTO Login (email, senha) VALUES (?, ?) ";

        try (Connection conn = ConnectionDatabase.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());

            
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Adicionado a alteração do usuario");
            } else{
                System.out.println("Erro no cadastramento da nova senha.");
            }
        } 
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void apagarSenha(Usuario usuario) throws Exception {
        String sql = "DELETE FROM Login WHERE email = ?";

        try (Connection conn = ConnectionDatabase.obtemConexao();
             PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getEmail());
            
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected > 0) {
                System.out.println("Usuario deletado");
            } else{
                System.out.println("Erro durante a deleção");
            }
        } 
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
