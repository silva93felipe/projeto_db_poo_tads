package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Medicamento;
import dominio.Medico;

public class MedicamentoDAO {
	
	private Conexao medicamentoConexao;
	
	private final String BURCARMEDICAMENTO = "select * from \"Medicamento\" where \"idMedicamento\" = ?";
	private final String TODOSMEDICAMENTOS = "select * from \"Medicamento\" ";
	private final String CADASTRARMEDICAMENTO = "insert into \"Medicamento\" (\"idMedicamento\", \"descricaoMedicamento\", \"quantidadeMedicamento\") "
			                                + " values (?, ?, ?)";
	
	public MedicamentoDAO() {
		this.medicamentoConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
	}
	
	public void incluirMedicamento(Medicamento medicamento) {
		try {
			this.medicamentoConexao.conectar();
			
			PreparedStatement instrucao = medicamentoConexao.getConexao().prepareStatement(CADASTRARMEDICAMENTO);
			
			instrucao.setString(1, medicamento.getIdProduto());
			instrucao.setString(2, medicamento.getDescricaProduto());
			instrucao.setInt(3, medicamento.getQuantidade());
			
			instrucao.execute();
			medicamentoConexao.desconectar();
			
		} catch (Exception e) {
			System.out.println("Erro ao incluir no banco: " + e.getMessage());
		}
		
	}

}
