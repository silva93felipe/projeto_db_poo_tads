package dominio;

import java.util.ArrayList;

public class Consulta {
	private String hora;
	private String data;
	private boolean status;
		
	ArrayList<Medico> medicos = new ArrayList<Medico>();
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	//tirar para implementar arrayList
	private String FKmedico;
	private String FKusuario;
	//tirar para implementar arrayList
	
	public Consulta() {
		this.medicos = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	};
	
	public Consulta(String FKmedico, String FKusuario, String hora, String data, boolean status) {
		this.hora = hora;
		this.data = data;
		this.status = status;
		
		this.medicos = new ArrayList<>();
		this.usuarios = new ArrayList<>();
		
		//tirar para implementar arrayList
		this.FKmedico = FKmedico;
		this.FKusuario = FKusuario;
		//tirar para implementar arrayList
	}
	
	//tirar para implementar arrayList
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
	//tirar para implementar arrayList
	
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
	
	public void disponibildadeConsulta(String hora, String data, Medico medico) {
		if((this.hora == hora) && (this.data == data) && (this.medicos.equals(medico))) {
			
		}
	}
	
}

