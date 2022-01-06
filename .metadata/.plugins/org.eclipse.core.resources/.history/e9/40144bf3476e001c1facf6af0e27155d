package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private String usuario;
	private String senha;
	private String caminho;
	private Connection con;
	
	public Conexao(String caminho, String usuario, String senha) {
		this.caminho = caminho;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public void conectar() {
		try {
			Class.forName("org.postgresql.Driver"); //Carregar o driver
			this.con = DriverManager.getConnection(this.caminho, this.usuario, this.senha); //cria a conexao com os dados
			System.out.println("Conexao realizada com sucesso...");
			
		}catch(Exception e) {
			System.out.print("Erro na conexao: " + e.getMessage());
		}
	}
	
	public void desconectar() {
		try {
			this.con.close();
		}catch(Exception e) {
			System.out.println("Problema ao desconectar do banco, " + e.getMessage());
		}
	}
	
	public Connection getConexao() {
		return this.con;
	}
	
	// Objeto CONNECTION cria a conexao e o objeto STATEMENT exucuta comandos 
	// Comandos => INSERT, UPDATE e DELETE nao tem retorno (EXECUTE()) (USAR O PREPAREDSTATEMENT)
	// Comando => SELECT (EXECUTEQUERY) (STATEMENT, pois não precisa de codigo de terceiros)
	// Cada um vai para a TABELA DAO que esteja se referido. Consulta CLIENTE na tabela CLIENTEDAO
	// RESULTSET é capaz de receber um retorno  de uma query. Com o comando SELECT
	// A classe CONEXAO não se comunica com o BANCO e sim as classes DAO
}
