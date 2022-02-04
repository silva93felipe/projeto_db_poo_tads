package visao;
//local imports
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
	private TitledPane TitletPaneCli,TitletPaneCli1;
	@FXML
	private Button btnCadCli;
	@FXML
	private TextField FieldcpfCli,FieldCidadeCli,FieldemailCli,FieldtelefCli,FieldnomeCli,FieldCepCli,
	FieldataCLi,FieldCidCLi,FieldSexoCLi,FieldcpfCli2;
	@FXML
	private Label labelAvClien;
	@FXML
	private TableView<Usuario> tableCli;
	@FXML
    private TableColumn<Usuario,String> ColCpfCli,colNomeCli,colTelefCli,colDatanascCli; 

	private ObservableList<Usuario> usuario = FXCollections.observableArrayList() ;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
			ancora.setVisible(true);
			tableCli.setVisible(false);
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
		
	
		TitletPaneCli.setText("apertt");
	}
	
	@FXML
	public void listenerBtnBuscCli (ActionEvent event) {
		Usuario u = new Usuario();
		UsuarioDAO uD = new UsuarioDAO();
	 
		 u = uD.buscarUsuario(FieldcpfCli2.getText());
		
		if(u == null) 
			TitletPaneCli1.setText("Usuário não existe!");
		else { 
			tableCli.toBack();
			ColCpfCli.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			colNomeCli.setCellValueFactory(new PropertyValueFactory<>("nome"));
			colDatanascCli.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
			colTelefCli.setCellValueFactory(new PropertyValueFactory<>("telefone"));
			
			usuario.addAll(u);
			TitletPaneCli1.setText("Usuário encontrado!");
		
		tableCli.setItems(usuario);
		
		
		}
		
		
		
		TitletPaneCli.setText("Click");
	}
}
