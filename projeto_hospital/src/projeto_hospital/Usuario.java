package projeto_hospital;

public class Usuario extends Pessoa {
	private String endereco;
	
	Usuario(int cpf, String nome, String nasc, String sexo,
			String email,  String telefn ){
		super.setCpf(cpf);
		super.setNome(nome);
		super.setDataNasc(nasc);
		super.setSexo(sexo);
		super.setEmail(email);
		super.setTelefone(telefn);
	}
	
	
	 public void marcarConsulta(){
		System.out.println("Consulta Marcada"); 
	 }

	 public String getEndereco() {
		return endereco;
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

	 public void setTelefone(String telefone) {
		
		super.setTelefone(telefone);
	 }


	 public void setEmail(String email) {
		
		super.setEmail(email);
	 }
	 
	 public void setEndereco(String endereco) {
		 
		 this.endereco = endereco;
	 }
	 
	 
	 
	 
	 
	 
}
