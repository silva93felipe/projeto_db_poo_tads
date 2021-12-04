package visao;


import dominio.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
		static int cpf; static String nome, dataNas, telefone, email; 
		static char sexo;
		
	public static void main(String[] args) {
		
		int opcaoMenu, opcaoCli, opcaoMedico, opMedicament;
		Scanner teclado = new Scanner(System.in);
		
		ArrayList<Pessoa> usuarios = new ArrayList<Pessoa>();
		ArrayList<DependenteUsuario> DependentUsu = new ArrayList<DependenteUsuario>();
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		
		Medico medico;
		Pessoa usuario;		
		DependenteUsuario depend;
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
						System.out.println(" 5- TODAS AS CONSULTAS PENDENTES");
						System.out.println(" 6- VOLTAR");
						System.out.println("\n------------------------------------");
						opcaoCli = teclado.nextInt();
						
						switch(opcaoCli) { 
						
						case 1:
							System.out.println("Insira dados abaixo:");
							moduloCadastro();
							
							usuario = new Usuario(cpf, nome, dataNas, sexo, email, telefone);							
							usuarios.add(usuario);
							
							break;
							
						case 2:
							int cpfRespon; boolean comp = false;
							System.out.println("Insira dados abaixo");
							System.out.println("Qual CPF dos responsável? ");
								cpfRespon = teclado.nextInt();
								
								for (int i = 0; i < usuarios.size(); i++) {
									if((cpfRespon == usuarios.get(i).getCpf())&& comp != true )
										comp = true;
								}
							if(comp == false) {
								System.out.println("Nao eh possivel cadastrar!");
								System.out.println("CPF do resposável não encontrado.");}
							else {
								System.out.println("Responsável OK! Insira dados abaixo...");
								
								System.out.println("cpf -APENAS NUMEROS");
								cpf = teclado.nextInt(); teclado.nextLine();
								
							 	System.out.println("data de nascimento -SEM HIFEN OU ESPAÇO");								
								dataNas = teclado.nextLine();
								
								System.out.println("nome -COMPLETO");
								nome = teclado.nextLine();
								
								System.out.println("sexo -M ou F");
								sexo = teclado.next().charAt(0); 	
								
								depend = new DependenteUsuario(cpf, nome, dataNas, sexo);
								DependentUsu.add(depend);
								
							}
							break;
						
						case 3:
							System.out.println("Consulta marcada...");
							break;
							
						case 4:
							System.out.println("Consulta cancelada...");
							break;
							
						case 5:
							System.out.println("Suas consultas pendentes sao: ");
							break;
							
						default: System.out.println("Opcao invalida...");
						}
						
					}while(opcaoCli!=6);
				
				break;
				
				case 2:
					do {
						System.out.println("\n------------------------------------");
						System.out.println("\n MÉDICO");
						System.out.println("\n------------------------------------");
						System.out.println("1 - CADASTRAR");
						System.out.println("2 - AGENDA");
						System.out.println("3 - VOLTAR");
						System.out.println("\n------------------------------------");
						
						opcaoMedico = teclado.nextInt();
						
						switch(opcaoMedico) {
						case 1:
							System.out.println("Insira dados abaixo:");
							moduloCadastro();
							 medico = new Medico(cpf, nome, dataNas, sexo, email, telefone);
							 medicos.add(medico);
							break;
							
						case 2:
							System.out.println("Agenda do medico fulado é... ");
							break;
						
						default: System.out.println("Opcao invalida...");
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
						System.out.println("4 - VOLTAR");
						System.out.println("\n------------------------------------");
						
						opMedicament = teclado.nextInt();
						
						switch(opMedicament) {
						case 1:
							System.out.println("Medicamento cadastrado...");
							break;
							
						case 2:
							System.out.println("Estoque do produto tal é...");
							break;
							
						case 3:
							System.out.println("Estoque do produto tal é...");
							break;
							
						default: System.out.println("Opcao invalida...");
						}
						
					}while(opMedicament!=4);
					
					break;
				
				default: System.out.println("Opcao invalida...");
				
				}
			
		}while(opcaoMenu!=4);
				  
	 }

}
