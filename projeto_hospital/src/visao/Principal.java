package visaoProjH;
import  projeto_hospital.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class Principal {

	public static void main(String[] args) {
		int cpf; String nome, dataNas, telefone, email; char sexo; 
		int opcaoMenu, opcaoCli, opcaoMedico, opMedicament;

		Scanner teclado = new Scanner(System.in);
		ArrayList <Pessoa> usuarios = new ArrayList<Pessoa>();
		Pessoa usuario;
		
		
		do {
			System.out.println("\n------------------------------------");
			System.out.println("\n MENU PRINCIPAL");
			System.out.println("\n------------------------------------");
			System.out.println("1 - CLIENTE");
			System.out.println("2 - MÉDICO");
			System.out.println("3 - MEDICAMENTOS");
			System.out.println("4 - SAIR");
			System.out.println("\n------------------------------------");
			
			opcaoMenu = teclado.nextInt();
			
			switch(opcaoMenu) {
				case 1:
					do {
						System.out.println("\n------------------------------------");
						System.out.println("\n CLIENTE");
						System.out.println("\n------------------------------------");
						System.out.println(" 1- CADASTRAR USUÁRIO");
						System.out.println(" 2- CADASTRAR DEPENDENTE");
						System.out.println(" 3- MARCAR CONSULTA");
						System.out.println(" 4- CANCELAR CONSULTA");
						System.out.println(" 5- TODAS AS CONSULTAS");
						System.out.println(" 6- VOLTAR");
						System.out.println("\n------------------------------------");
						opcaoCli = teclado.nextInt();
						
						switch(opcaoCli) { 
						
						
						case 1:
							System.out.println("insira dados abaixo");
							moduloCad(1);
								cpf = teclado.nextInt();
							
							System.out.println("data de nascimento -SEM HIFEN OU ESPAÇO");
										teclado.nextLine();
								dataNas = teclado.nextLine();
							
							System.out.println("nome -COMPLETO");
								nome = teclado.nextLine();
							
							System.out.println("sexo -M ou F");
								sexo = teclado.next().charAt(0);
							
							System.out.println("telefone -APENAS NUMEROS");
								telefone = teclado.nextLine();
							
							System.out.println("email");
								email = teclado.nextLine();
							usuario = new Usuario(cpf, nome, dataNas, sexo, email, telefone);
								usuarios.add(usuario);
							break;
							
						case 2:
							int aux; boolean comp = false;
							System.out.println("insira dados abaixo");
							System.out.println("Qual cpf do Responsável -DE USUÁRIO JÁ CADASTRADO");
								aux = teclado.nextInt();
								for (int i = 0; i < usuarios.size(); i++) {
									if((aux == usuarios.get(i).getCpf())&& comp != true )
										comp = true;
								}
							if(comp == false) {
								System.out.println("Não é possivel cadastrar!");
								System.out.println("cpf do responsável não econtrado!");}
							else {
								System.out.println("insira dados abaixo");
								
							}
							break;
						
						case 3:
							break;
						case 4:
							break;
						case 5:
							break;
						case 6:
							break;
						}
						
					}while(opcaoCli!=6);
				
				break;
				
				case 2:
					do {
						System.out.println("\n------------------------------------");
						System.out.println("\n M�DICO");
						System.out.println("\n------------------------------------");
						System.out.println("1 - CADASTRAR");
						System.out.println("2 - AGENDA");
						System.out.println("3 - VOLTAR");
						System.out.println("\n------------------------------------");
						
						opcaoMedico = teclado.nextInt();
						
						switch(opcaoMedico) {
						case 1:
							break;
							
						case 2:
							break;
						
						}
						
					}while(opcaoMedico!=3);
					
					break;
				case 3:
					
					do {
						System.out.println("\n------------------------------------");
						System.out.println("\n MEDICAMENTOS");
						System.out.println("\n------------------------------------");
						System.out.println("1 - CADASTRAR");
						System.out.println("2 - CONSULTAR ESTOQUE");
						System.out.println("3 - SOLICITAR");
						System.out.println("\n------------------------------------");
						
						opMedicament = teclado.nextInt();
						
						switch(opMedicament) {
						case 1:
							break;
							
						case 2:
							break;
						
						}
						
					}while(opMedicament!=3);
					
					break;
				
					
				default: System.out.println("opção inválida...");
				
				}
			
		}while(opcaoMenu!=4);
		 
	}
}
