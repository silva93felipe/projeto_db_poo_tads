package dominio;
import java.util.ArrayList;

public class Clinica extends Hospital {
//	private int codClinc;
	public String espec;
	
	ArrayList<Integer> FKmedico 
	= new ArrayList<Integer>();
	
	public Clinica() {}
	
	public Clinica(String espec){
		espec = "Clinica de fraturas"; //exmplo;
	}

//	public int getCodClinc() {
//		return codClinc;
//	}
	
	public String getEspec() {
		return espec;
	}
	
//	public void Status() {
//		System.out.println("Você está na clinica "+codClinc);
//		System.out.println("/n "+ espec);
//	}
	
	public void seuMedico() {
		System.out.println("Voce sera atendido pelo medico(a):");
		System.out.println(FKmedico.get(2));
	}
	
	public void vincularMedico(int cpf){
		FKmedico.add(cpf);
		System.out.println("Vinculado com sucesso!");
	}
	
//	public int getFKcpf(int i) {
//		
//		return FKmedico.get(i);
//	}
//	
}