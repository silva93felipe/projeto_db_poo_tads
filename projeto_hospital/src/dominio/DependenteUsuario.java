package dominio;

	public class DependenteUsuario {
	
		private String cpf;
		private String nome;
		private String dataNasc;
		private String sexo;
		//private int FKusario; 
		
		public DependenteUsuario() {};
		
		public DependenteUsuario(String cpf, String nome, String dataNasc, String sexo) {
			this.cpf = cpf;
			this.nome = nome;
			this.dataNasc = dataNasc;
			this.sexo = sexo;		
		}
		
		public String getCpf() {
			return cpf;
		}
		public String getNome() {
			return nome;
		}
		public String getDataNasc() {
			return dataNasc;
		}
		public String getSexo() {
			return sexo;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public void setDataNasc(String dataNasc) {
			this.dataNasc = dataNasc;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}
				
}
