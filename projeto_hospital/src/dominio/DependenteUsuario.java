package dominio;

	public class DependenteUsuario {
	
		private int cpf;
		private String nome;
		private String dataNasc;
		private char sexo;
		//private int FKusario; 
		
		public DependenteUsuario(int cpf, String nome, String dataNasc, char sexo) {
			this.cpf = cpf;
			this.nome = nome;
			this.dataNasc = dataNasc;
			this.sexo = sexo;		
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
				
}
