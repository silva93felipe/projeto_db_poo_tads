package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import dominio.DependenteUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DependenteDAO {
	
private Conexao dependenteConexao;
	
	private final String BURCARDEPENDENTE = "select nomeDependente,sexoDependente,dataNascimentoDependente,"
			+ "cpfUsuario from DependenteUsuario where cpfusuario = ?";
	
	private final String CADASTRARDEPENDENTE = "insert into DependenteUsuario (nomeDependente, cpfDependente, dataNascimentoDependente,"
			                                + " sexoDependente, cpfUsuario)" 
			                                + " values (?, ?, ?, ?, ?)";
	
	public DependenteDAO() {
		this.dependenteConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "niko123");
	}
	
	public void incluirDependente(DependenteUsuario dependente) {
		try {
			this.dependenteConexao.conectar();
			
			PreparedStatement instrucao = dependenteConexao.getConexao().prepareStatement(CADASTRARDEPENDENTE);
						
			instrucao.setString(1, dependente.getNome());
			instrucao.setString(2, dependente.getCpf());
			instrucao.setString(3, dependente.getDataNasc());
			instrucao.setString(4, dependente.getSexo());
			instrucao.setString(5, dependente.getCpfTitular());
			
			
			instrucao.execute();
			dependenteConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
		
	}
	
	public ObservableList<DependenteUsuario> bucarDependente(String cpfusuario) {
		ObservableList<DependenteUsuario> dependente= FXCollections.observableArrayList();
		
		try {
			this.dependenteConexao.conectar();
			
			PreparedStatement instrucao = dependenteConexao.getConexao().prepareStatement(BURCARDEPENDENTE);
			
			instrucao.setString(1, cpfusuario);
			
			ResultSet rs = instrucao.executeQuery();
			
			if(rs.next()) {
				DependenteUsuario dep= new DependenteUsuario ( 
						rs.getString("nomeDependente"), rs.getString("sexoDependente"), 
						rs.getString("cpfUsuario"), rs.getString("dataNascimentoDependente"));
				dependente.add(dep);
			}
			dependenteConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
		
		return dependente;
		
	}

}
