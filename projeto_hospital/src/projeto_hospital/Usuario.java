package projeto_hospital;

public class Usuario extends Pessoa {
	private String endereco;
	
	
	public Usuario( String nome, String nasc, String telefn,
			String email, String sexo, int cpf) { 
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = nasc;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefn;
	
	} 
	
	 public void marcarConsulta(){
		System.out.println("Consulta Marcada"); 
	 }

	 public String getEndereco() {
		return endereco;
	 }


	 public String getEmail() {
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

	 public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
}
