package dominio;

import java.util.ArrayList;

public class Usuario extends Pessoa {
	  
	  private String endereco;
	  ArrayList<DependenteUsuario> dependentes = new ArrayList<DependenteUsuario>(); 
	  
	  public Usuario(int cpf, String nome, String dataNasc, char sexo,
				String email,  String telefone){
		  super(cpf, nome, dataNasc, sexo, email, telefone);
	  }
	  
	  public String getEndereco() {
		return endereco;
	  }

	  public void setEndereco(String endereco) {
		this.endereco = endereco;
	  }

	  /*public void marcarConsulta(){
		System.out.println("Consulta Marcada"); 
	  }*/
}
