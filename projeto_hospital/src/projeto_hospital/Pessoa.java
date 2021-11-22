package projeto_hospital;

public abstract class Pessoa {
	private String nome;
	private String dataNasc;
	private String telefone;
	private String email;
	private String sexo;
	private int cpf;
	

	public String getEmail() {
		return this.email;
	}

	public String getSexo() {
		return this.sexo;
	}

	public String getNome() {
		return this.nome;
	}
	
	 public String getDataNasc() {
		return this.dataNasc;
	}
		 
	 public String getTelefone() {
		return this.telefone;
	}
	  
	 public int getCpf() {
		 return this.cpf;
	 }
	 
	 public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	  
	 public void setEmail(String email) {
		this.email = email;
		}
		
}
