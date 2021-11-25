package projeto_hospital;

abstract class Pessoa {
	private int cpf;
	private String nome;
	private String dataNasc;
	private String sexo;
	private String email;
	private String telefone;
	
	
	/*Pessoa(int cpf, String nome, String nasc, String sexo,
			String email,  String telefn ){
		
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = nasc;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefn;
	
	}*/
	
	 public String getEmail(){
		 return email;
	 }
	
	 public String getSexo(){
		 return sexo;
	 }

	 public String getNome(){
		 return nome;
	 } 
	
	 public String getDataNasc(){
		 return dataNasc;
	 }
		 
	 public String getTelefone(){
		 return telefone;
	 } 
	  
	 public int getCpf(){
		 return cpf;
	 }
	 
	 public void setTelefone(String telefone){
		 this.telefone = telefone;
	 }
	 
	 public void setEmail(String email){
		 this.email = email;
	 }

	 public void setNome(String nome){
		 this.nome = nome;
	 }
	 
	 public void setDataNasc(String dataNasc){
		 this.dataNasc = dataNasc;
	 }

	 public void setSexo(String sexo){
		 this.sexo = sexo;
	 }

	 public void setCpf(int cpf){
		 this.cpf = cpf;
	 }
}