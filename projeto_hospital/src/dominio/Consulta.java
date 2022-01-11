package dominio;

public class Consulta {
	private String hora;
	private String data;
	private boolean status;
	private String FKmedico;
	private String FKusuario;

	
	public Consulta() {
		
	};
	
	public Consulta(String hora, String data, boolean status, String FKmedico, String FKusuario) {
		this.hora = hora;
		this.data = data;
		this.status = status;
		this.FKmedico = FKmedico;
		this.FKusuario = FKusuario;

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

	public boolean getStatus() {
		return this.status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}

