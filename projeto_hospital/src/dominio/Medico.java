package dominio;

public class Medico extends Pessoa {
	
	public Medico(int cpf, String nome, String dataNasc, char sexo,
			String email,  String telefone){
	  super(cpf, nome, dataNasc, sexo, email, telefone);
  }
	
	
	
  void solicitarMedicamento() {
	  System.out.println("Solicitacao de medicamento efetuada.");
  }
 
  
  
}

