package persistencia;

public class ClinicaDAO {
	private Conexao minhaConexao;
	
	private final String BUSCAR = "select * from \"Clinica\" where \"Id\" = ?";
	
	
	public ClinicaDAO() {
		this.minhaConexao = new Conexao("jdbc:postgresql://localhost:5432/hospital", "postgres", "root");
	}

}
