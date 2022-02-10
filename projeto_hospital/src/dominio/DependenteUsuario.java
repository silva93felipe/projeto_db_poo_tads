package dominio;

	public class DependenteUsuario extends Pessoa{
		private String cpfTitular;
		
		public DependenteUsuario() {
			super();
		};
		
		public DependenteUsuario(String cpf, String nome, String dataNasc, String sexo,
				String email,  String telefone, String cpfTitular ) {
			super(cpf, nome, dataNasc, sexo, email, telefone);
		}

		public DependenteUsuario(String cpf, String nome, String sexo, String cpfTitular,
				 String dataNasc) {
			super(cpf, nome, dataNasc, sexo);
			this.cpfTitular = cpfTitular;
		}

		public DependenteUsuario(String nome, String sexo, String cpfTitular,
				 String dataNasc) {
			super(nome, dataNasc, sexo);
			this.cpfTitular = cpfTitular;
		}

		public String getCpfTitular() {
			return this.cpfTitular;
		}

		public void setCpfTitular(String cpfTitular) {
			this.cpfTitular = cpfTitular;
		}
		
		
}
