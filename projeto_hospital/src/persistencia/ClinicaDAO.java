package persistencia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Medico;

public class ClinicaDAO {
	private Conexao clinicaConexao;
	
	private final String LISTAMEDICOS = "select * from \"Clinica\" where \"MedicoId\" = ?";
	
//	private final String LISTAESPECIALIDADE = "select * from \"Clinica\" where \"Especialidade\" = ?";
	
	
	public ClinicaDAO() {
		this.clinicaConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
	}
	
	public ArrayList<Medico> medicosAssociados(){
		ArrayList<Medico> listaMedicos = new ArrayList<Medico>();
		
		try {
			this.clinicaConexao.conectar();
			
			Statement instrucao = clinicaConexao.getConexao().createStatement(); 
			
			ResultSet rs = instrucao.executeQuery(LISTAMEDICOS); // quando é um select usar o executeQuery
			while(rs.next()) {
				Medico medico = new Medico(rs.getString("cpf"), rs.getString("nome"), rs.getString("dataNasc"), rs.getString("sexo"), rs.getString("email"), rs.getString("telefone"));
				listaMedicos.add(medico);
			}
			
			clinicaConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao desconectar do banco: " + e.getMessage());
		}
		
		return listaMedicos;
	}

}
