package visao;


import dominio.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		ArrayList<DependenteUsuario> dependentes = new ArrayList<DependenteUsuario>();
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		
		int opcaoMenu, opcaoCli, opcaoMedico, opMedicament;
		
		Scanner teclado = new Scanner(System.in);
		
	
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
						System.out.println(" 1 - CADASTRAR USUÁRIO");
						System.out.println(" 2 - CADASTRAR DEPENDENTE");
						System.out.println(" 3 - MARCAR CONSULTA");
						System.out.println(" 4 - CANCELAR CONSULTA");
						System.out.println(" 5 - TODAS AS CONSULTAS PENDENTES");
						System.out.println(" 6 - VOLTAR");
						System.out.println("\n------------------------------------");
						
						opcaoCli = teclado.nextInt();
						
						switch(opcaoCli) { 
						
						case 1:
							Usuario user = new Usuario();
							
							System.out.println("Digite o CPF (Sem os pontos): ");
							user.setCpf(teclado.nextLine()); teclado.next();			
							
							System.out.println("Digite o nome: ");
							user.setNome(teclado.nextLine()); teclado.next();					
							
							System.out.println("Digite a data de nascimento: ");
							user.setDataNasc(teclado.nextLine()); teclado.next();

							System.out.println("Digite o sexo (M / F): ");
							user.setSexo(teclado.nextLine()); teclado.next();
							
							System.out.println("Digite o email: ");
							user.setEmail(teclado.nextLine()); teclado.next();
							
							System.out.println("Digite o telefone (Apenas numeros): ");
							user.setTelefone(teclado.nextLine()); teclado.next();
							
							System.out.println("Digite o endereco: ");
							user.setEndereco(teclado.next()); 
							
							users.add(user);
							System.out.println("Usuario cadastrado com sucesso.");

							break;
							
						case 2:
							boolean achou = false;
							System.out.println("Digite o CPF do titular (Sem os pontos): ");
							String auxTitularCpf = teclado.nextLine(); teclado.next();
							
							for(int i = 0; i < users.size(); i++) {
								if(users.get(i).getCpf() == auxTitularCpf) {
									achou = true;
								}
							}
							
							if(achou == true) {
								System.out.println("Titular encontrado.");
								
								DependenteUsuario dependente = new DependenteUsuario();
								System.out.println("Digite o CPF (Sem os pontos): ");
								dependente.setCpf(teclado.nextLine()); teclado.next();			
								
								System.out.println("Digite o nome: ");
								dependente.setNome(teclado.nextLine()); teclado.next();					
								
								System.out.println("Digite a data de nascimento: ");
								dependente.setDataNasc(teclado.nextLine()); teclado.next();

								System.out.println("Digite o sexo (M / F): ");
								dependente.setSexo(teclado.nextLine()); teclado.next();
								
								dependentes.add(dependente);
								System.out.println("Dependente cadastrado com sucesso.");
							}
							
							if(achou == false) {
								System.out.println("Titular não encontrado.");								
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
							
							Medico medico = new Medico();
							
							System.out.println("Digite o CPF (Sem os pontos): ");
							medico.setCpf(teclado.nextLine()); teclado.next();			
							
							System.out.println("Digite o nome: ");
							medico.setNome(teclado.nextLine()); teclado.next();					
							
							System.out.println("Digite a data de nascimento: ");
							medico.setDataNasc(teclado.nextLine()); teclado.next();

							System.out.println("Digite o sexo (M / F): ");
							medico.setSexo(teclado.nextLine()); teclado.next();
							
							System.out.println("Digite o email: ");
							medico.setEmail(teclado.nextLine()); teclado.next();
							
							System.out.println("Digite o telefone (Apenas numeros): ");
							medico.setTelefone(teclado.nextLine()); teclado.next();

							medicos.add(medico);
							System.out.println("Usuario cadastrado com sucesso.");
				
							break;
							
						case 2:
							System.out.println("Digite o CPF do medico (Sem os pontos): ");
							String auxMedico = teclado.nextLine(); teclado.next();
							for(int i = 0; i < consultas.size(); i++) {
								if(consultas.get(i).getFKmedico() == auxMedico) {
									System.out.println("======Consultas======");
									System.out.println("Data " + consultas.get(i).getData() + " | " + "Hora " + consultas.get(i).getHora());
								}
							}

//							System.out.println("Medico nao localizado.");
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
		
		System.out.println("Fim do programa...");
	 }

}
