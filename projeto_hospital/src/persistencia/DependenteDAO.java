package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dominio.DependenteUsuario;

public class DependenteDAO {
	
private Conexao dependenteConexao;
	
	private final String BURCARDEPENDENTE = "select * from \"DependenteUsuario\" where \"cpfDependente\" = ?";
	
	private final String CADASTRARDEPENDENTE = "insert into \"DependenteUsuario\" (\"cpfDependente\", \"nomeDependente\", "
			                                + " \"sexoDependente\", \"emailDependente\", \"telefoneDependente\", \"cpfUsuario\", "
			                                + " \"dataNascimentoDependente\") " 
			                                + " values (?, ?, ?, ?, ?, ?, ?)";
	
	public DependenteDAO() {
		this.dependenteConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "niko123");
	}
	
	public void incluirDependente(DependenteUsuario dependente) {
		try {
			this.dependenteConexao.conectar();
			
			PreparedStatement instrucao = dependenteConexao.getConexao().prepareStatement(CADASTRARDEPENDENTE);
			
			instrucao.setString(1, dependente.getCpf());
			instrucao.setString(2, dependente.getNome());
			instrucao.setString(3, dependente.getSexo());
			instrucao.setString(4, dependente.getEmail());
			instrucao.setString(5, dependente.getTelefone());
			instrucao.setString(6, dependente.getCpfTitular());
			instrucao.setString(7, dependente.getDataNasc());
			
			instrucao.execute();
			dependenteConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
		
	}
	
	public DependenteUsuario bucarDependente(String cpfDependente) {
		DependenteUsuario dependente = null;
		
		try {
			this.dependenteConexao.conectar();
			
			PreparedStatement instrucao = dependenteConexao.getConexao().prepareStatement(BURCARDEPENDENTE);
			
			instrucao.setString(1, cpfDependente);
			
			ResultSet rs = instrucao.executeQuery();
			
			if(rs.next()) {
				dependente = new DependenteUsuario (rs.getString("cpfDependente"), rs.getString("nomeDependente"), rs.getString("sexoDependente"), rs.getString("emailDependente"), 
												   rs.getString("telefoneDependente"), rs.getString("cpfUsuario"), rs.getString("dataNascimentoDependente"));
			}
			dependenteConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
		
		return dependente;
		
	}

}
