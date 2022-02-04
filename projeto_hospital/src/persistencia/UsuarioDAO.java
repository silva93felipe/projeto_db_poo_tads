package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dominio.Usuario;

public class UsuarioDAO {
	
	private Conexao usuarioConexao;
	
	private final String BURCARUSUARIO = "SELECT cpfusuario, nomeUsuario, sexoUsuario, telefoneUsuario, dataNascimentoUsuario FROM usuario where \"cpfusuario\" = ?";
	private final String CADASTRARUSUARIO = "insert into usuario (cpfUsuario, nomeUsuario, "
			                                + "emailUsuario, telefoneUsuario, "
			                                + "cepUsuario, cidadeUsuario,dataNascimentoUsuario) " 
			                                + "values (?, ?, ?, ?, ?, ?, ?, ?)";
	
	public UsuarioDAO() {
		this.usuarioConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "niko123");
	}
	
	public void incluirUsuario(Usuario usuario) {
		try {
			this.usuarioConexao.conectar();
			
			PreparedStatement instrucao = usuarioConexao.getConexao().prepareStatement(CADASTRARUSUARIO);
			
			instrucao.setString(1, usuario.getCpf());
			instrucao.setString(2, usuario.getNome());
			instrucao.setString(3, usuario.getSexo());
			instrucao.setString(4, usuario.getEmail());
			instrucao.setString(5, usuario.getTelefone());
			//instrucao.setString(6, usuario.getLagradouro());
			instrucao.setString(6, usuario.getCep());
			//instrucao.setString(8, usuario.getBairro());
			instrucao.setString(7, usuario.getCidade());
			//instrucao.setString(10, usuario.getUF());
			//instrucao.setString(11, usuario.getNumeroCasa());
			instrucao.setString(8, usuario.getDataNasc());
			
			instrucao.execute();
			usuarioConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
	}
	
	public Usuario buscarUsuario(String cpf) {
		Usuario user = null;
	
		try {
			this.usuarioConexao.conectar();
			
			PreparedStatement instrucao = usuarioConexao.getConexao().prepareStatement(BURCARUSUARIO);
			instrucao.setString(1, cpf);
			
			ResultSet rs = instrucao.executeQuery();
			
			if(rs.next()) {
				user = new Usuario(rs.getString("cpfUsuario"), rs.getString("nomeUsuario"), rs.getString("dataNascimentoUsuario"), rs.getString("telefoneUsuario"));								
			}
			
			this.usuarioConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro ao mostrar informacoes: " + e.getMessage());
		}
		
		return user;
	}

}
