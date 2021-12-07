package dominio;

  public abstract class Pessoa {
	  private String cpf;
	  private String nome;
	  private String dataNasc;
	  private String sexo;
	  private String email;
	  private String telefone;
	  
	  public Pessoa() {};
	  
	
		public Pessoa(String cpf, String nome, String dataNasc, String sexo,
				String email,  String telefone ) 
		{
			this.cpf =  cpf;
			this.nome = nome;
			this.dataNasc = dataNasc;
			this.sexo = sexo;
			this.email = email;
			this.telefone = telefone;
		}
		
		public String getCpf() {
			return cpf;
		}
		
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getDataNasc() {
			return dataNasc;
		}
		
		public void setDataNasc(String dataNasc) {
			this.dataNasc = dataNasc;
		}
		
		public String getSexo() {
			return sexo;
		}
		
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getTelefone() {
			return telefone;
		}
		
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
}