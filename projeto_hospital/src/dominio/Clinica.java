package dominio;
import java.util.ArrayList;

public class Clinica extends Hospital {
	
	ArrayList<Medico> FKmedicos = new ArrayList<Medico>();
	
	public Clinica() {}

	public boolean buscarMedico(String cpf) {
		for(int i = 0; i < FKmedicos.size(); i++ ) {
			if(FKmedicos.get(i).getCpf() == cpf) {
				return true;
			}
		}
		
		return false;
	}
}
