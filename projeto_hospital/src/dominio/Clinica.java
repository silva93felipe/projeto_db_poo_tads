package dominio;
import java.util.ArrayList;

public class Clinica extends Hospital {
	private int codClinc;
	String espec;
	
	ArrayList<Integer> FKmedico 
	= new ArrayList<Integer>();
	
	
	Clinica(String espec){
		espec = "Clinica de fraturas"; //exmplo;
	}

	
	public int getCodClinc() {
		return codClinc;
	}
	
	public String getEspec() {
		return espec;
	}
	
	public void Status() {
		
		System.out.println("Você está na clinica "+codClinc);
		System.out.println("/n "+ espec);
	}
	
	public void seuMedico() {
		System.out.println("Você será atendido pelo medico(a):");
		System.out.println("cpf: " +FKmedico.get(2));
	}
	
	public void vincularMedico(int cpf){
		FKmedico.add(cpf);
		System.out.println("Vinculado com sucesso!");
	}
	
	public int getFKcpf(int i) {
		
		return FKmedico.get(i);
	}
	
}
