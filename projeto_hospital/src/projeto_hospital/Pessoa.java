package projeto_hospital;

abstract class Pessoa {
	 String nome;
	 String dataNasc;
	 String telefone;
	 String email;
	 String sexo;
	 int cpf;
	
	
	 abstract String getEmail();
	
	 abstract String getSexo();

	 abstract String getNome(); 
	
	 abstract String getDataNasc();
		 
	 abstract String getTelefone(); 
	  
	 abstract int getCpf();
	 
	 abstract void setTelefone(String telefone);
	 
	 abstract void setEmail(String email);
		
}