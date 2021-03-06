package visao;
//local imports
import dominio.Consulta;
import dominio.Usuario;
import persistencia.ConsultaDAO;
import persistencia.UsuarioDAO;

//fx imports
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;

public class Gui955Controller implements Initializable {
	@FXML
	private AnchorPane ancora;
	@FXML
	private TitledPane TitletPaneCli,TitletPaneCli1,TitletPaneConsu,TitletPaneCli11;
	@FXML
	private Button btnCadCli,btnBuscCli1,btnCadConsu,btnBuscConsu;
	@FXML
	private TextField FieldcpfCli,FieldCidadeCli,FieldemailCli,FieldtelefCli,FieldnomeCli,FieldCepCli,
	FieldataCLi,FieldCidCLi,FieldSexoCLi,FieldcpfCli2;
	@FXML
	private TextField FieldIdCosu,FieldHoraConsu,FieldCpfCliConsu,FieldCpfMedConsu,FieldataConsu,FieldcpfCliConsubus;
	@FXML
	private Label labelAvClien,labelAvConsu;
	@FXML
	private TableView<Usuario> tableCli;
	@FXML
	private TableView<Consulta> tableConsu;
	@FXML
    private TableColumn<Usuario,String> ColCpfCli,colNomeCli,colTelefCli,colDatanascCli; 
	@FXML
	private TableColumn<Consulta, String>colDataConsu,colhoraConsu,colCpfMedConsu;
	
	private ObservableList<Usuario> usuario = FXCollections.observableArrayList();
	private ObservableList<Consulta> consu = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
			ancora.setVisible(true);
			tableCli.setVisible(false);
			labelAvClien.setVisible(false);
			labelAvConsu.setVisible(false);
			tableConsu.setVisible(false);
			//TitletPaneCli.setVisible(false);
	}
	// Event Listener on Button[#btnCadCli].onAction    
	@FXML
	public void listenerBtnCadCli(ActionEvent event) {
		Usuario u = new Usuario();
		UsuarioDAO uD = new UsuarioDAO();
		
		u.setNome(FieldnomeCli.getText());
		
		u.setCpf(FieldcpfCli.getText());
		
		u.setDataNasc(FieldataCLi.getText());
		
		u.setSexo(FieldSexoCLi.getText());
		
		u.setEmail(FieldemailCli.getText());
		
		u.setTelefone(FieldtelefCli.getText());
		
		u.setCidade(FieldCidadeCli.getText());
		
		u.setCep(FieldCepCli.getText());
		
		uD.incluirUsuario(u);
		FieldnomeCli.clear();
		FieldcpfCli.clear();
		FieldataCLi.clear();
		FieldSexoCLi.clear();
		FieldemailCli.clear();
		FieldtelefCli.clear();
		FieldCidadeCli.clear();
		FieldCepCli.clear();
	
		TitletPaneCli.setText("Cadastro efetuado!");
	}
	
	@FXML
	public void listenerBtnBuscCli (ActionEvent event) {
		
		Usuario u = new Usuario();
		UsuarioDAO uD = new UsuarioDAO();
	 
		 u = uD.buscarUsuario(FieldcpfCli2.getText());
		
		if(u == null) { 
			tableCli.setVisible(false);
			TitletPaneCli1.setText("Usu??rio n??o existe!");
			labelAvClien.setVisible(true);
			labelAvClien.setText("Error, usuario n??o encontrado, ou talvez queira cadastra-lo?");
			TitletPaneCli.setVisible(true);
		}
		else { 
			//tableCli.setItems(null);
			ColCpfCli.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			colNomeCli.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colDatanascCli.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
			colTelefCli.setCellValueFactory(new PropertyValueFactory<>("telefone"));
			
			usuario.addAll(u);
			TitletPaneCli1.setText("Usu??rio encontrado!");
			FieldcpfCli2.clear();
			tableCli.setVisible(true);
			tableCli.setItems(usuario);
			
		}
	}
	@FXML
	public void listenerBtnCadConsu(ActionEvent event) {
		Consulta c = new Consulta();
		ConsultaDAO cD = new ConsultaDAO();
		
		c.setId(Integer.parseInt(FieldIdCosu.getText()));
		c.setFKmedico(FieldCpfMedConsu.getText());
		c.setFKusuario(FieldCpfCliConsu.getText());
		c.setData(FieldataConsu.getText());
		c.setHora(FieldHoraConsu.getText());
		c.setStatus(true);
	
		/*if(cD.existeConsu(FieldIdCosu.getText())) {
			labelAvConsu.setVisible(true);
			labelAvConsu.setText("error, j?? existe consulta nesse ID!");*/
		
		
			cD.cadastrarConsulta(c);
			labelAvConsu.setVisible(true);
			labelAvConsu.setText("Cadastro foi um Sucesso!");
			
			FieldIdCosu.clear();
			FieldCpfMedConsu.clear();
			FieldCpfCliConsu.clear();
			FieldataConsu.clear();
			FieldHoraConsu.clear();
	}
		
		
	
	
	
	@FXML
	public void listenerBtnBuscConsu(ActionEvent event) {
		tableConsu.setVisible(true);
		ConsultaDAO cD = new ConsultaDAO();
		
		
		//if(cD.existeConsu(FieldcpfCliConsubus.getText())) {
		consu = cD.todasConsultasUsuario(FieldcpfCliConsubus.getText());
		
		colCpfMedConsu.setCellValueFactory(new PropertyValueFactory<>("FKmedico"));
		colDataConsu.setCellValueFactory(new PropertyValueFactory<>("hora"));
		colhoraConsu.setCellValueFactory(new PropertyValueFactory<>("data"));
		
		if(consu.isEmpty()) {
			TitletPaneConsu.setText("Tente novamente!");
			labelAvConsu.setVisible(true);
			labelAvConsu.setText("Nenhuma consulta encontrada!");
		}else {
			TitletPaneConsu.setText("Consultas");
			tableConsu.setItems(consu);
			labelAvConsu.setText("Consulta(s)encontrada(s)!");
		}
			FieldcpfCliConsubus.clear();
		}
		/*}else {
			TitletPaneConsu.setText("N??o encontrado!");
		}*/
		
	
	
	
	
	
	
}
