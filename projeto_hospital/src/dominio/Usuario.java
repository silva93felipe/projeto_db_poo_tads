package dominio;

import java.util.ArrayList;

public class Usuario extends Pessoa {
	private String endereco;
	
	private String lagradouro;
	private String cep;
	private String bairro;
	private String cidade;
	private String UF;
	private String numeroCasa;
	
	ArrayList<DependenteUsuario> dependentes = new ArrayList<DependenteUsuario>(); 
	  
	  public Usuario() {
		  super();
	  };
	  
	  public Usuario(String cpf, String nome, String dataNasc, String sexo,
				String email, String telefone, String lagradouro, String cep, String bairro, String cidade, String uf, String numeroCasa){
		  super(cpf, nome, dataNasc, sexo, email, telefone);
		  this.lagradouro = lagradouro;
		  this.cep = cep;
		  this.bairro = bairro;
		  this.cidade = cidade;
		  this.UF = uf;
		  this.numeroCasa = numeroCasa;
	  }
	  
	  
	  public String getEndereco() {
		return endereco;
	  }

	  public void setEndereco(String endereco) {
		this.endereco = endereco;
	  }
		
		
	
	public String getLagradouro() {
		return this.lagradouro;
	}

	public void setLagradouro(String lagradouro) {
		this.lagradouro = lagradouro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUF() {
		return this.UF;
	}

	public void setUF(String uF) {
		this.UF = uF;
	}

	public String getNumeroCasa() {
		return this.numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
}
