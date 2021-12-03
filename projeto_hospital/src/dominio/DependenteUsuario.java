package dominio;

	public class DependenteUsuario {
	
		private int cpf;
		private String nome;
		private String dataNasc;
		private char sexo;
		private int FKusario; //chave estrangeira (cpf) de usuario;
		
		public DependenteUsuario(int cpf, String nome, String dataNasc, char sexo, int FKusario ) {
			this.cpf = cpf;
			this.nome = nome;
			this.dataNasc = dataNasc;
			this.sexo = sexo;
			this.FKusario = FKusario;			
		}
		
		
		
		
		
		public int getCpf() {
			return cpf;
		}
		public String getNome() {
			return nome;
		}
		public String getDataNasc() {
			return dataNasc;
		}
		public char getSexo() {
			return sexo;
		}
		public int getFKusario() {
			return FKusario;
		}
		public void setCpf(int cpf) {
			this.cpf = cpf;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public void setDataNasc(String dataNasc) {
			this.dataNasc = dataNasc;
		}
		public void setSexo(char sexo) {
			this.sexo = sexo;
		}
		public void setFKusario(int fKusario) {
			FKusario = fKusario;
		}
		
		
		
		
		
		
}
