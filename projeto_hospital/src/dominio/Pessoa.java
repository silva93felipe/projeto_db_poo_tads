package dominio;

  public abstract class Pessoa {
	  private String cpf;
	  private String nome;
	  private String dataNasc;
	  private String sexo;
	  private String email;
	  private String telefone;
	  
	  public Pessoa() {};
	  
	  //usuario
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
		//dependente
		public Pessoa(String nome, String dataNasc, String sexo) 
		{
			this.cpf =  "null";
			this.nome = nome;
			this.dataNasc = dataNasc;
			this.sexo = sexo;
			this.email = "null";
			this.telefone = "null";
		}
		//tabela
		public  void Pessoa2(String cpf, String nome, String dataNasc, String telefone ) {
			this.cpf = cpf;
			this.nome = nome;
			this.dataNasc = dataNasc;
			this.telefone = telefone;
		}


		public Pessoa(String cpf, String nome, String dataNasc, String sexo) {
			this.cpf =  cpf;
			this.nome = nome;
			this.dataNasc = dataNasc;
			this.sexo = sexo;
			this.email = "null";
			this.telefone = "null";
		}
		
		public void Pessoa3 (String nome,String dataNasc,String email,String telefone) {			
			this.nome = nome;
			this.dataNasc = dataNasc;			
			this.email = email;
			this.telefone = telefone;
		}
		
		public String getCpf() {
			return this.cpf;
		}
		
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getDataNasc() {
			return this.dataNasc;
		}
		
		public void setDataNasc(String dataNasc) {
			this.dataNasc = dataNasc;
		}
		
		public String getSexo() {
			return this.sexo;
		}
		
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
		
		public String getEmail() {
			return this.email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getTelefone() {
			return this.telefone;
		}
		
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
}