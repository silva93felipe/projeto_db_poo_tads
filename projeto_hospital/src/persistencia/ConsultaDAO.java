package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dominio.Consulta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConsultaDAO {
	
	private Conexao consultaConexao;
	
	private final String BUSCARCONSULTASMEDICOS = "select * FROM consulta where cpfMedico = ?";
	
	//private final String BUSCARPORID = "SELECT idconsulta FROM consulta WHERE idconsulta = ?";
	
	private final String BUSCARCONSULTASUSUARIO = "SELECT dataconsulta,horaconsulta,cpfmedico from Consulta where cpfusuario = ?";
	
	private final String CADASTRARCONSULTA = "INSERT INTO Consulta ( idconsulta,statusConsulta, cpfMedico, cpfUsuario, dataConsulta, "
											+ " horaConsulta) VALUES (?,?, ?, ?, ?, ?)";
	
	public ConsultaDAO() {
		this.consultaConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "niko123");
	}
	
	public ArrayList<Consulta> todasConsultasMedico(String cpfMedico){
		ArrayList<Consulta> listaConsultaMedico = new ArrayList<Consulta>();
		
		try {
			this.consultaConexao.conectar();
			
			PreparedStatement instrucao = consultaConexao.getConexao().prepareStatement(BUSCARCONSULTASMEDICOS); 
			
			instrucao.setString(1, cpfMedico);
			
			ResultSet rs = instrucao.executeQuery();
			
			if(rs.next()) {
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
	
	
	public ObservableList<Consulta> todasConsultasUsuario(String cpfUsuario){
		ObservableList<Consulta> listaConsultaUsuario = FXCollections.observableArrayList();
		
		try {
			this.consultaConexao.conectar();
			
			PreparedStatement instrucao = consultaConexao.getConexao().prepareStatement(BUSCARCONSULTASUSUARIO); 
			
			instrucao.setString(1, cpfUsuario);
			
			ResultSet rs = instrucao.executeQuery();
			
			if(rs.next()) {
				Consulta consulta = new Consulta(rs.getString("dataconsulta"), rs.getString("horaconsulta"),
						rs.getString("cpfmedico"));
				
				listaConsultaUsuario.add(consulta);
			}
			
			consultaConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao desconectar do banco: " + e.getMessage());
		}
		
		return listaConsultaUsuario;
	}
	
	public void cadastrarConsulta(Consulta consulta) {
		
		
		try {
			this.consultaConexao.conectar();
			
			PreparedStatement instrucao = consultaConexao.getConexao().prepareStatement(CADASTRARCONSULTA);
			
			instrucao.setInt(1, consulta.getId());
			instrucao.setBoolean(2, consulta.getStatus());
			instrucao.setString(3, consulta.getFKmedico());
			instrucao.setString(4, consulta.getFKusuario());
			instrucao.setString(5, consulta.getData());
			instrucao.setString(6, consulta.getHora());
			
			instrucao.execute();
			consultaConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
		
	}

	/*public boolean existeConsu(String id) {
		boolean ex=true;
		try {
			this.consultaConexao.conectar();
			
			PreparedStatement instrucao = consultaConexao.getConexao().prepareStatement(BUSCARPORID); 
			//conversão?
			instrucao.setString(1, id);
			
			ResultSet rs = instrucao.executeQuery();
			
			if(rs == null) 
				ex = false;
			
			consultaConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao desconectar do banco: " + e.getMessage());
		}
		return ex;
	
	}*/
}
