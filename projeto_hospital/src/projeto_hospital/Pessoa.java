package projeto_hospital;

public class Pessoa {
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String cpf;
	private String telefone;
	private String email;
	
	public Pessoa() { }
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDataNascimento() {
		return this.dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getSexo() {
		return this.sexo;
	}
	
	public void setSexto(String sexo) {
		this.sexo = sexo;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
