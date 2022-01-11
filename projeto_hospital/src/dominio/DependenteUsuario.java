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

		public String getCpfTitular() {
			return this.cpfTitular;
		}

		public void setCpfTitular(String cpfTitular) {
			this.cpfTitular = cpfTitular;
		}
		
		
}
