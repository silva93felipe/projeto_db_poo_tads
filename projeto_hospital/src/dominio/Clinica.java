package dominio;
import java.util.ArrayList;

public class Clinica extends Hospital {
	public String especialidade;
	
	ArrayList<Medico> FKmedicos = new ArrayList<Medico>();
	
	public Clinica() {}
	
	public Clinica(String especialidade){
		this.especialidade = especialidade;
	}
	
	public String getEspec() {
		return this.especialidade;
	}
	
	public void setEspec(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public boolean buscarMedico(String cpf) {
		for(int i = 0; i < FKmedicos.size(); i++ ) {
			if(FKmedicos.get(i).getCpf() == cpf) {
				return true;
			}
		}
		
		return false;
	}
}
