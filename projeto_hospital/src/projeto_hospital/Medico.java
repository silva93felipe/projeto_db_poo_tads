package projeto_hospital;

public class Medico extends Pessoa {
	private int matricula;
	
	Medico(int cpf, String nome, String nasc, String sexo,
			String email,  String telefn ){
		super.setCpf(cpf);
		super.setNome(nome);
		super.setDataNasc(nasc);
		super.setSexo(sexo);
		super.setEmail(email);
		super.setTelefone(telefn);
	}
	
	  void solicitarMedicamento() {
		
		  System.out.println("Solicitação de medicamento efetuada.");
	 }
	
	 public int getMatricula() {
		 
		 return matricula;
	 }
	 
	 public String getEmail() {
		 
		 return super.getEmail();
	 }

	 public String getSexo() {
		
		return super.getSexo();
	 }
	
	 public String getNome() {
		
		return super.getNome();
	 }
	
	 public String getDataNasc() {
		
		return super.getDataNasc();
	 }

	 public String getTelefone() {
		
		return super.getTelefone();
	 }

	 public int getCpf() {
		
		return super.getCpf();
	 }
	
	 public void setMatricula(int matricula) {
		 
		 this.matricula = matricula;
	 }
	 
	 public void setTelefone(String telefone) {
			
		super.setTelefone(telefone);
	}

	public void setEmail(String email) {
			
		super.setEmail(email);
	}
		 
}

