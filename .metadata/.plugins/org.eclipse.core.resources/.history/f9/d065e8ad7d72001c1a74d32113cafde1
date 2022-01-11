package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Consulta;
import dominio.Medico;

public class ConsultaDAO {
	
	private Conexao consultaConexao;
	
	private final String BUSCARCONSULTASMEDICOS = "select * from \"Consulta\" where \"cpfMedico\" = ?";
	
	private final String BUSCARCONSULTASUSUARIO = "select * from \"Consulta\" where \"cpfUsuario\" = ?";
	
	public ConsultaDAO() {
		this.consultaConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
	}
	
	public ArrayList<Consulta> todasConsultasMedico(String cpfMedico){
		ArrayList<Consulta> listaConsultaMedico = null;
		
		try {
			this.consultaConexao.conectar();
			
			PreparedStatement instrucao = consultaConexao.getConexao().prepareStatement(BUSCARCONSULTASMEDICOS); 
			
			instrucao.setString(1, cpfMedico);
			
			ResultSet rs = instrucao.executeQuery();
			
			while(rs.next()) {
				Consulta consulta = new Consulta(rs.getString("horaConsulta"), rs.getString("dataConsulta"), rs.getBoolean("statusConsulta"), 
										rs.getString("cpfMedico"), rs.getString("cpfUsuario"));
				
				listaConsultaMedico.add(consulta);
			}
			
			consultaConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao desconectar do banco: " + e.getMessage());
		}
		
		return listaConsultaMedico;
	}

}
