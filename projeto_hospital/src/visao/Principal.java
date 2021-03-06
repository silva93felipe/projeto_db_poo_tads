package visao;

import java.util.ArrayList;
import java.util.Scanner;

import dominio.Consulta;
import dominio.DependenteUsuario;
import dominio.Medicamento;
import dominio.Medico;
import dominio.Usuario;
import persistencia.ConsultaDAO;
import persistencia.DependenteDAO;
import persistencia.MedicamentoDAO;
import persistencia.MedicoDAO;
import persistencia.UsuarioDAO;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		
		// Objetos DAO
		MedicoDAO mDAO = new MedicoDAO();
		MedicamentoDAO medDAO = new MedicamentoDAO();
		UsuarioDAO userDAO = new UsuarioDAO();
		DependenteDAO depDAO = new DependenteDAO();
		ConsultaDAO conDAO = new ConsultaDAO();
		MedicamentoDAO medicamentoDAO = new MedicamentoDAO();
		
		// Variaveis auxiliares
		String cpfUserAux, cpfDepAux, cpfMedAux, codProdAux;
		
		Usuario user = new Usuario();
		DependenteUsuario dependente = new DependenteUsuario();
		Medico medico = new Medico();
		Consulta consulta = new Consulta();
		Medicamento medicamento = new Medicamento();
		
		int opcaoMenu, opcaoCli, opcaoMedico, opMedicament, retiradaProd;
		
		Scanner teclado = new Scanner(System.in);
		
		do {
			System.out.println("\n------------------------------------");
			System.out.println("\n==========MENU PRINCIPAL============");
			System.out.println("\n------------------------------------");
			System.out.println("1 - CLIENTE");
			System.out.println("2 - M?DICO");
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
							
							System.out.println("Digite o CPF (Sem os pontos): ");
							
							cpfUserAux = teclado.nextLine();
							user = userDAO.buscarUsuario(cpfUserAux);
							
							if (user != null) {
								System.out.println("Ops, Usuario ja cadastrado.");
								break;
							}
							
							if(user == null) {
								
								user = new Usuario();
								
								user.setCpf(cpfUserAux);
								
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
							}
							
							break;
	
						case 2:
							
							System.out.println("Digite o CPF do titular (Sem os pontos): ");
							cpfUserAux = teclado.nextLine();
							user = userDAO.buscarUsuario(cpfUserAux);
							
							if(user == null) {
								System.out.println("Titular n?o encontrado.");
								break;
							}
							
							System.out.println("Titular encontrado.");
							
							System.out.println("Digite o CPF do dependente (Sem os pontos): ");
							cpfDepAux = teclado.nextLine();
							dependente = depDAO.bucarDependente(cpfDepAux);
							
							if(dependente != null) {
								System.out.println("Dependente j? cadastrado.");
								break;
							}
								
							if (user != null && dependente == null) {
								System.out.println("=============Informacoes do dependente================");
								
								dependente = new DependenteUsuario();
								
								dependente.setCpfTitular(cpfUserAux);
								
								dependente.setCpf(cpfDepAux);
		
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
							}
							
							break;
						
						case 3:

							System.out.println("Digite o CPF do medico (Sem os pontos): ");
							cpfMedAux = teclado.nextLine();
							medico = mDAO.bucarMedico(cpfMedAux);
							
							if(medico == null) {
								System.out.println("Problema ao cadastrar a consulta, medico n?o encontrado.");
								break;
							}
							
							System.out.println("Digite o CPF do usuario (Sem os pontos): ");
							cpfUserAux = teclado.nextLine();
							user = userDAO.buscarUsuario(cpfUserAux);
							dependente = depDAO.bucarDependente(cpfUserAux);
							
							if(user == null && dependente == null) {
								System.out.println("Problema ao cadastrar a consulta, nenhum usuario encontrado.");
								break;
							}
							
							consulta.setFKusuario(cpfUserAux);
							consulta.setFKmedico(cpfMedAux);
							
							System.out.println("Digite a data da consulta: ");
							consulta.setData(teclado.nextLine());
							
							System.out.println("Digite a hora da consulta: ");
							consulta.setHora(teclado.nextLine());
							
							consulta.setStatus(true);
							
							conDAO.cadastrarConsulta(consulta);
							
							System.out.println("Consulta marcada.");									
							
							break;
							
						case 4: 
							System.out.println("Digite o CPF do usuario (Sem os pontos): ");
							cpfUserAux = teclado.nextLine();
							
							consultas = conDAO.todasConsultasUsuario(cpfUserAux);
							
							if(consultas.size() == 0) {
								System.out.println("Nenhuma consulta agendada.");
								break;
							}
							
							for( int i=0; i < consultas.size(); i++){
								if(consultas.get(i).getStatus() == true) {
									System.out.println("============Consultas============");
									System.out.println("-------------------------------");
									System.out.println("DATA: " + consultas.get(i).getData());
									System.out.println("HORA: " + consultas.get(i).getHora());
									System.out.println("-------------------------------");
									System.out.println("================================");
								}
		                    }
							
							break;
							
							
						}
						
					}while(opcaoCli!=5);
				
				break;
				
				case 2:
					do {
						System.out.println("\n------------------------------------");
						System.out.println("\n=============M?DICO=================");
						System.out.println("\n------------------------------------");
						System.out.println("1 - CADASTRAR");
						System.out.println("2 - AGENDA");
						System.out.println("3 - VOLTAR");
						System.out.println("\n------------------------------------");
						
						opcaoMedico = teclado.nextInt();
						teclado.nextLine();
						
						switch(opcaoMedico) {
						case 1:
							
							System.out.println("Digite o CPF do medico (Sem os pontos): ");
							cpfMedAux = teclado.nextLine();
							medico = mDAO.bucarMedico(cpfMedAux);
							
							if(medico != null) {
								System.out.println("Medico ja cadastrado.");
								break;
							}
							
							medico = new Medico();
						
							medico.setCpf(cpfMedAux);
							
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
							System.out.println("Digite o CPF do medico (Sem os pontos): ");
							cpfMedAux = teclado.nextLine();
							
							consultas = conDAO.todasConsultasMedico(cpfMedAux);
							
							if(consultas.size() == 0) {
								System.out.println("Nenhuma consulta agendada.");
								break;
							}
							
							for( int i=0; i < consultas.size(); i++){
								if(consultas.get(i).getStatus() == true) {
									System.out.println("============Consultas============");
									System.out.println("-------------------------------");
									System.out.println("DATA: " + consultas.get(i).getData());
									System.out.println("HORA: " + consultas.get(i).getHora());
									System.out.println("-------------------------------");
									System.out.println("================================");
								}
		                    }
							
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
								System.out.println("Digite codigo do produto: ");
								codProdAux = teclado.nextLine();
								medicamento = medicamentoDAO.bucarMedicamento(codProdAux);
								
								if(medicamento != null) {
									System.out.println("Ops, Medicamento ja cadastrado.");
									break;
								}
								
								medicamento = new Medicamento();
								
								medicamento.setIdProduto(codProdAux);
								
								System.out.println("Digite o nome do produto: ");
								medicamento.setDescricaProduto(teclado.nextLine());
								
								System.out.println("Digite a quantidade: ");
								medicamento.setQuantidade(teclado.nextInt());
								
								medDAO.incluirMedicamento(medicamento);
								System.out.println("Medicamento cadastrado com sucesso.");
								
								break;
								
							case 2:
								int saldoAtual = 0;
								System.out.println("Digite codigo do produto: ");
								codProdAux = teclado.nextLine();
								medicamento = medicamentoDAO.bucarMedicamento(codProdAux);
								
								if(medicamento == null) {
									System.out.println("Ops, Medicamento nao encontrado.");
									break;
								}
								
								saldoAtual = medicamentoDAO.estoque(codProdAux);
								
								System.out.println("Saldo atual do produto e: " + saldoAtual);
								
								break;
								
							case 3:
								System.out.println("Digite codigo do produto: ");
								codProdAux = teclado.nextLine();
								medicamento = medicamentoDAO.bucarMedicamento(codProdAux);
								
								if(medicamento == null) {
									System.out.println("Ops, Medicamento nao encontrado.");
									break;
								}
								
								System.out.println("Digite a quantidade para retirada:  ");
								retiradaProd = teclado.nextInt();
								
								saldoAtual = medicamentoDAO.estoque(codProdAux);
								
								if(saldoAtual < retiradaProd) {
									System.out.println("Produto com saldo insuficiente.");
									break;
								}
								
								if(saldoAtual - retiradaProd < 0) {
									System.out.println("Nao pode fazer retirada maior que o saldo.");
									break;
								}
								
								//TESTAR A RETIRADA
								
								medicamentoDAO.retirada(codProdAux, retiradaProd);
								System.out.println("Retirada efetuada com Sucesso.");
								
								break;
						}
						
					}while(opMedicament!=4);
					
					break;
				}
			
		}while(opcaoMenu!=4);
		
		System.out.println("Fim do programa...");
	 }

}

