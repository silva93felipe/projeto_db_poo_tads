package projeto_hospital;

public class Medico extends Pessoa {
	private int matricula;
	
	public Medico(String nome, String nasc, String telefn,
			String email, String sexo, int cpf) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNasc = nasc;
		this.sexo = sexo;
		this.email = email;
		this.telefone = telefn;
	}
	
	  void solicitarMedicamento() {
		System.out.println("Solicitação de medicamento efetuada.");
	 }
	
	 public int getMatricula() {
		 return matricula;
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

	 public void setMatricula(int matricula) {
		 this.matricula = matricula;
	 }
}

