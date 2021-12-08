package dominio;

public abstract class Hospital {
	private String endereco;	
	private String[] telefone = new String[3]; 
	private String[] email = new String[3];
	
	public Hospital() {	}
	
	public Hospital(String endereco, String[] telefone, String[] email) {	
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}

	public String getTelefone(int i) {
		return telefone[i];
	}

	public void setTelefone(String telefone, int i) {
		this.telefone[i] = telefone;
	}

	public String getEmail(int i) {
		return email[i];
	}

	public void setEmail(String email, int i) {
		this.email[i] = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
