package dominio;

public class Consulta {
	private String hora;
	private String data;
	private String FKmedico;
	private String FKusuario;
	private boolean status;
	
	public Consulta() {};
	
	public Consulta(String FKmedico, String FKusuario) {
		this.FKmedico = FKmedico;
		this.FKusuario = FKusuario;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getFKmedico() {
		return this.FKmedico;
	}

	public void setFKmedico(String FKmedico ) {
		this.FKmedico = FKmedico;
	}
	
	public String getFKusuario() {
		return this.FKusuario;
	}
	
	public void setFKusuario(String fkUsuario) {
		this.FKusuario = fkUsuario;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}

