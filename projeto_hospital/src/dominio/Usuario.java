package dominio;

public class Usuario extends Pessoa {
	private String endereco;
	
	 public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void marcarConsulta(){
		System.out.println("Consulta Marcada"); 
	 }

}
