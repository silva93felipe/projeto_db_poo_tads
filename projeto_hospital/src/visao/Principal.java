package visao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import dominio.Consulta;
import dominio.DependenteUsuario;
import dominio.Medicamento;
import dominio.Medico;
import dominio.Usuario;
import persistencia.DependenteDAO;
import persistencia.MedicamentoDAO;
import persistencia.MedicoDAO;
import persistencia.UsuarioDAO;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		ArrayList<DependenteUsuario> dependentes = new ArrayList<DependenteUsuario>();
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
		
		//Objetos DAO
		MedicoDAO mDAO = new MedicoDAO();
		MedicamentoDAO medDAO = new MedicamentoDAO();
		UsuarioDAO userDAO = new UsuarioDAO();
		DependenteDAO depDAO = new DependenteDAO();
			
		int opcaoMenu, opcaoCli, opcaoMedico, opMedicament;
		
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.println("\n------------------------------------");
			System.out.println("\n==========MENU PRINCIPAL============");
			System.out.println("\n------------------------------------");
			System.out.println("1 - CLIENTE");
			System.out.println("2 - M�DICO");
			System.out.println("3 - MEDICAMENTOS");
			System.out.println("4 - SAIR");
			System.out.println("\n------------------------------------");
			
			opcaoMenu = teclado.nextInt();
			
			switch(opcaoMenu) {
				case 1:
					do {
						System.out.println("\n------------------------------------");
						System.out.println("\n=============CLIENTE================");
						System.out.println("\n------------------------------------");
						System.out.println(" 1 - CADASTRAR CLIENTE");
						System.out.println(" 2 - CADASTRAR DEPENDENTE");
						System.out.println(" 3 - MARCAR CONSULTA");   
						System.out.println(" 4 - CONSULTAS MARCADAS");
						System.out.println(" 5 - VOLTAR");
						System.out.println("\n------------------------------------");
						
						opcaoCli = teclado.nextInt();
						teclado.nextLine();
						
						switch(opcaoCli) { 
						
						case 1:
							Usuario user = new Usuario();
							
							System.out.println("Digite o CPF (Sem os pontos): ");
							user.setCpf(teclado.nextLine());
							
							System.out.println("Digite o nome: ");
							user.setNome(teclado.nextLine());
							
							System.out.println("Digite a data de nascimento: ");
							user.setDataNasc(teclado.nextLine());

							System.out.println("Digite o sexo (M / F): ");
							user.setSexo(teclado.nextLine());
							
							System.out.println("Digite o email: ");
							user.setEmail(teclado.nextLine());
							
							System.out.println("Digite o telefone (Apenas numeros): ");
							user.setTelefone(teclado.nextLine());
							
							System.out.println("Digite o lagradouro: ");
							user.setLagradouro(teclado.nextLine());
							
							System.out.println("Digite o CEP (Apenas numeros): ");
							user.setCep(teclado.nextLine());
							
							System.out.println("Digite o nome do bairro: ");
							user.setBairro(teclado.nextLine());
							
							System.out.println("Digite o nome da cidade: ");
							user.setCidade(teclado.nextLine());
							
							System.out.println("Digite o nome do estado: ");
							user.setUF(teclado.nextLine());
							
							System.out.println("Digite o numero da casa:  ");
							user.setNumeroCasa(teclado.nextLine());
							
							userDAO.incluirUsuario(user);
							System.out.println("Cadastro realizado com sucesso.");
							
//							System.out.println("Digite o endereco: ");
//							user.setEndereco(teclado.nextLine()); 
//							boolean achouUser = false;
//							for(int i = 0; i < users.size(); i++) {
//								if(users.get(i).getCpf().equals(user.getCpf())) {
//									achouUser = true;
//									System.out.println("Ops, Usuario ja cadastrado.");
//								}
//							}
//							
//							if(achouUser == false) {
//								users.add(user);
//								System.out.println("Cadastro realizado com sucesso.");								
							//}
							
							break;
							
						case 2:
//							boolean achouUserDep = false;
//							System.out.println("Digite o CPF do titular (Sem os pontos): ");
//							String auxTitularCpf = teclado.nextLine();
//							
//							for(int i = 0; i < users.size(); i++) {
//								if(users.get(i).getCpf().equals(auxTitularCpf)) {
//									achouUserDep = true;
//								}
//							}
							
//							if(achouUserDep == true) {
//								System.out.println("Titular encontrado.");
								System.out.println("=============Informacoes do dependente================");
								DependenteUsuario dependente = new DependenteUsuario();
								
								System.out.println("Digite o CPF do titular: ");
								dependente.setCpfTitular(teclado.nextLine());
								
								System.out.println("Digite o CPF (Sem os pontos): ");
								dependente.setCpf(teclado.nextLine());		
								
								System.out.println("Digite o nome: ");
								dependente.setNome(teclado.nextLine());				
								
								System.out.println("Digite o sexo (M / F): ");
								dependente.setSexo(teclado.nextLine());
								
								System.out.println("Digite o email: ");
								dependente.setEmail(teclado.nextLine());
								
								System.out.println("Digite o telefone: ");
								dependente.setTelefone(teclado.nextLine());
								
								System.out.println("Digite a data de nascimento: ");
								dependente.setDataNasc(teclado.nextLine());
								
								depDAO.incluirDependente(dependente);
								System.out.println("Dependente cadastrado com sucesso.");
//							}
							
//							if(achouUserDep == false) {
//								System.out.println("Titular n�o encontrado.");								
//							}
							
							break;
						
						case 3:
							boolean achouMedCon = false;
							boolean achouDep = false;
							boolean achouUserCon = false;
							Consulta consulta = new Consulta();
							
							System.out.println("Digite a data da consulta: ");
							consulta.setData(teclado.nextLine());
							
							System.out.println("Digite a hora da consulta: ");
							consulta.setHora(teclado.nextLine());
							
							System.out.println("Digite o CPF do medico: ");
							consulta.setFKmedico(teclado.nextLine());
							
							for(int i = 0; i < medicos.size(); i++) {
								if(medicos.get(i).getCpf().equals(consulta.getFKmedico())) {
									achouMedCon = true;
								}
							}
							
							if(achouMedCon) {
								System.out.println("Digite o CPF do usuario: ");
								consulta.setFKusuario(teclado.nextLine());
								
								for(int i = 0; i < users.size(); i++) {
									if(users.get(i).getCpf().equals(consulta.getFKusuario())) {
										achouUserCon = true;
									}
								}
								
								for(int i = 0; i < dependentes.size(); i++) {
									if(dependentes.get(i).getCpf().equals(consulta.getFKusuario())) {
										achouDep = true;
									}
								}
								
								if(achouUserCon || achouDep) {
									consulta.setStatus(true);
									consultas.add(consulta);
									System.out.println("Consulta marcada.");									
								}
								
								if(achouUserCon == false && achouDep == false) {
									System.out.println("Problema ao cadastrar a consulta, nem cliente encontrado.");
								}
							}
							
							if(achouMedCon == false) {
								System.out.println("Problema ao cadastrar a consulta, nem medico encontrado.");
							}
							
							break;
							
						case 4: 
							System.out.println("Digite o CPF do usuario: ");
							String consultaMarcada = teclado.nextLine();
							System.out.println("============Consultas============");
							
							for(int i = 0; i < consultas.size(); i++) {
								if(consultas.get(i).getFKusuario().equals(consultaMarcada)) {
									if(consultas.get(i).getStatus() == true) {
										System.out.println("Data " + consultas.get(i).getData() + " | " + "Hora " + consultas.get(i).getHora());										
									}
								}else {
									System.out.println("Nenhuma consulta marcada.");									
								}
							}
							
							System.out.println("================================");

							break;
						}
						
					}while(opcaoCli!=5);
				
				break;
				
				case 2:
					do {
						System.out.println("\n------------------------------------");
						System.out.println("\n=============M�DICO=================");
						System.out.println("\n------------------------------------");
						System.out.println("1 - CADASTRAR");
						System.out.println("2 - AGENDA");
						System.out.println("3 - VOLTAR");
						System.out.println("\n------------------------------------");
						
						opcaoMedico = teclado.nextInt();
						teclado.nextLine();
						
						switch(opcaoMedico) {
						case 1:
							
							Medico medico = new Medico();
							
							System.out.println("Digite o CPF (Sem os pontos): ");
							medico.setCpf(teclado.nextLine());
							
							System.out.println("Digite o nome: ");
							medico.setNome(teclado.nextLine());				
														
							System.out.println("Digite o sexo (M / F): ");
							medico.setSexo(teclado.nextLine());
							
							System.out.println("Digite o email: ");
							medico.setEmail(teclado.nextLine());
							
							System.out.println("Digite o telefone: ");
							medico.setTelefone(teclado.nextLine());
							
							System.out.println("Digite a data de nascimento: ");
							medico.setDataNasc(teclado.nextLine());
							
							mDAO.incluirMedico(medico);
							
							System.out.println("Cadastrado com Sucesso.");
							
							break;
								
						case 2:
							boolean temConsulta = false;
							System.out.println("Digite o CPF do medico (Sem os pontos): ");
							String auxMedico = teclado.nextLine();
							
							System.out.println("============Consultas============");
							for(int i = 0; i < consultas.size(); i++) {
								if(consultas.get(i).getFKmedico().equals(auxMedico)) {
									System.out.println("Data " + consultas.get(i).getData() + " | " + "Hora " + consultas.get(i).getHora());
									temConsulta = true;
								}
							}
							
							if(temConsulta == false) {
								System.out.println("Nenhuma consulta agendada.");
							}
							System.out.println("================================");
							break;
						}
						
					}while(opcaoMedico!=3);
					
					break;
					
				case 3:
					
					do {
						System.out.println("\n------------------------------------");
						System.out.println("\n===========MEDICAMENTOS=============");
						System.out.println("\n------------------------------------");
						System.out.println("1 - CADASTRAR");
						System.out.println("2 - ESTOQUE");
						System.out.println("3 - SOLICITAR");
						System.out.println("4 - VOLTAR");
						System.out.println("\n------------------------------------");
						
						opMedicament = teclado.nextInt();
						teclado.nextLine();
						
						switch(opMedicament) {
							case 1:
								Medicamento medicamento = new Medicamento();
								
								System.out.println("Digite codigo do produto: ");
								medicamento.setIdProduto(teclado.nextLine());
								
								System.out.println("Digite o nome do produto: ");
								medicamento.setDescricaProduto(teclado.nextLine());
								
								System.out.println("Digite a quantidade: ");
								medicamento.setQuantidade(teclado.nextInt());
//								teclado.nextLine();
								
								medDAO.incluirMedicamento(medicamento);
								System.out.println("Medicamento cadastrado com sucesso.");
								
//								try {
//									
//									boolean achouMedicamento = false;
//									for(int i = 0; i < medicamentos.size(); i++) {
//										if(medicamentos.get(i).getIdProduto().equals(medicamento.getIdProduto())){
//											achouMedicamento = true;
//											System.out.println("Ops, Medicamento ja cadastrado.");
//										}
//									}
//									
//									if(achouMedicamento == false) {
//										medicamentos.add(medicamento);
//										System.out.println("Medicamento cadastrado com sucesso.");								
//									}
//									
//								}catch (InputMismatchException e) {
//									System.out.println("Falha, Digite apenas n�meros." + e.getMessage());
//								}
								
								break;
							case 2:
								
								System.out.println("Digite codigo do produto: ");
								String codigoProd = teclado.nextLine();
								
								for(int i = 0; i < medicamentos.size(); i++) {
									if(medicamentos.get(i).getIdProduto().equals(codigoProd)){
										System.out.println("O saldo do produto " + medicamentos.get(i).getDescricaProduto() + 
												" eh: " + medicamentos.get(i).getQuantidade());
									}else {
										System.out.println("Produto nao encontrado.");
									}
								}
								
								break;
								
							case 3:
								System.out.println("Digite codigo do produto: ");
								String codigoProdReti = teclado.nextLine();
								
								for(int i = 0; i < medicamentos.size(); i++) {
									if(medicamentos.get(i).getIdProduto().equals(codigoProdReti)){
										System.out.println("Digite a quantidade: ");
										int quantidade = teclado.nextInt();
										teclado.nextLine();
										medicamentos.get(i).retirada(quantidade, codigoProdReti);
									}else {
										System.out.println("Produto nao encontrado.");
									}
								}
								
								break;
						}
						
					}while(opMedicament!=4);
					
					break;
				}
			
		}while(opcaoMenu!=4);
		
		System.out.println("Fim do programa...");
	 }

}

