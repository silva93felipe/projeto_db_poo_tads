package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import dominio.Medico;

public class MedicoDAO {

	private Conexao medicoConexao;
	
	private final String BUSCARMEDICO = "select nomeMedico,dataNascimentoMedico,emailMedico,telefoneMedico from Medico where cpfMedico = ?";
	private final String BUSCATODOSMEDICOS = "select * from Medico ";
	private final String CADASTRARMEDICO = "insert into Medico (cpfMedico, nomeMedico, dataNascimentoMedico,"
			                                + " emailMedico, telefoneMedico) values (?, ?, ?, ?, ?)";
	
	//private final String LISTAESPECIALIDADE = "select * from Clinica where Especialidade = ?";
	
	
	public MedicoDAO() {
		this.medicoConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "niko123");
	}
	
	public ArrayList<Medico> medicosAssociados(){
		ArrayList<Medico> listaMedicos = new ArrayList<Medico>();
		
		try {
			this.medicoConexao.conectar();
			
			Statement instrucao = medicoConexao.getConexao().createStatement(); 
			
			ResultSet rs = instrucao.executeQuery(BUSCATODOSMEDICOS); // quando � um select usar o executeQuery
			
			while(rs.next()) {
				Medico medico = new Medico(rs.getString("cpfMedico"), rs.getString("nomeMedico"), 
											rs.getString("sexoMedico"), rs.getString("emailMedico"), rs.getString("telefoneMedico"), rs.getString("dataNascimentoMedico"));
				listaMedicos.add(medico);
			}
			
			medicoConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao desconectar do banco: " + e.getMessage());
		}
		
		return listaMedicos;
	}
	
	public void incluirMedico(Medico medico) {
		
		try {
			this.medicoConexao.conectar();
			
			PreparedStatement instrucao = medicoConexao.getConexao().prepareStatement(CADASTRARMEDICO);
			
			instrucao.setString(1, medico.getCpf());
			instrucao.setString(2, medico.getNome());
			instrucao.setString(3, medico.getDataNasc());
			instrucao.setString(4, medico.getEmail());
			instrucao.setString(5, medico.getTelefone());
			
			
			instrucao.execute();
			medicoConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
		
	}
	
	public Medico bucarMedico(String cpfMedico) {
		Medico medico = null;
		
		try {
			this.medicoConexao.conectar();
			
			PreparedStatement instrucao = medicoConexao.getConexao().prepareStatement(BUSCARMEDICO);
			
			instrucao.setString(1, cpfMedico);
			
			ResultSet rs = instrucao.executeQuery();
			
			if(rs.next()) {
				medico = new Medico(rs.getString("nomeMedico"), rs.getString("dataNascimentoMedico"), 
						 rs.getString("emailMedico"), rs.getString("telefoneMedico"));
			}
			medicoConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
		
		return medico;
		
	}
}
