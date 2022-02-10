package visao;
import java.net.URL;
import java.util.ResourceBundle;

//local imports
import dominio.DependenteUsuario;
import dominio.Medicamento;
import dominio.Medico;
import dominio.Usuario;
import persistencia.DependenteDAO;
import persistencia.MedicamentoDAO;
import persistencia.MedicoDAO;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class Gui955parteIIController implements Initializable {
	@FXML
	private AnchorPane Ancora;
	@FXML
	private Label LabelAvCdep;
	@FXML
	private TextField FieldnomeDep;
	@FXML
	private TextField FieldSexoDep;
	@FXML
	private TextField FieldCpfRespn;
	@FXML
	private TextField FieldCpfDep;
	@FXML
	private TextField FieldDataNasc;
	@FXML
	private Label LabelAVbDep;
	@FXML
	private TextField FieldCPFrespBuscar;
	@FXML
	private Button btnCadastrarDep;
	@FXML
	private Button btnBuscarDep;
	@FXML
	private TableView<DependenteUsuario> TabDep;
	@FXML
	private TableColumn<DependenteUsuario, String> ColNomeDep;
	@FXML
	private TableColumn<DependenteUsuario, String> ColSexoDep;
	@FXML
	private TableColumn<DependenteUsuario, String> ColdataNasDep;
	@FXML
	private TableColumn<DependenteUsuario, String> ColCPFrespDep;
	
	private ObservableList<DependenteUsuario> DepUsu = FXCollections.observableArrayList();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Ancora.setVisible(true);
		TabDep.setVisible(false);
	}
	
	
	@FXML
	public void listenerBtnCadastrarDep(ActionEvent event) {
		DependenteDAO depD = new DependenteDAO();
		DependenteUsuario dep = new DependenteUsuario();
		
		dep.setNome(FieldnomeDep.getText());
		dep.setCpf(FieldCpfDep.getText());
		dep.setDataNasc(FieldDataNasc.getText());
		dep.setSexo(FieldSexoDep.getText());
		dep.setCpfTitular(FieldCpfRespn.getText());
		
		depD.incluirDependente(dep);
		LabelAvCdep.setText("Cadastro efetuado!");
		
		
	}
	
	@FXML
	public void listenerBtnBuscarDep(ActionEvent event) {
		//DependenteUsuario du = new DependenteUsuario();
		TabDep.setVisible(true);
		DependenteDAO depD = new DependenteDAO();
		DepUsu = depD.bucarDependente(FieldCPFrespBuscar.getText());		
		
		ColNomeDep.setCellValueFactory(new PropertyValueFactory<>("nome"));
		ColSexoDep.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		ColCPFrespDep.setCellValueFactory(new PropertyValueFactory<>("cpfTitular"));
		ColdataNasDep.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
		
		
		TabDep.setItems(DepUsu);
	}
}
