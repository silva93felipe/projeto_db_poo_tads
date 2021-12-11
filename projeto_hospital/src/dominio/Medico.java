package dominio;

public class Medico extends Pessoa {
	public String especialidade;
	
	public Medico() {
		super();
	};
	
	public Medico(String cpf, String nome, String dataNasc, String sexo,
			String email,  String telefone)
	{
		super(cpf, nome, dataNasc, sexo, email, telefone);
	}
	
	public String getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

}

