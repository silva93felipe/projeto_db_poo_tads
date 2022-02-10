package visao;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

import dominio.Medico;
import dominio.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import persistencia.MedicoDAO;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class Gui955parteIIIController implements Initializable {
	@FXML
	private AnchorPane Ancora;
	@FXML
	private Label LabelAvCadmed;
	@FXML
	private TextField fieldNome;
	@FXML
	private TextField FieldCPF;
	@FXML
	private TextField fieldTelefone;
	@FXML
	private TextField fieldEmail;
	@FXML
	private Label LabelAvbusca;
	@FXML
	private TextField fieldBUscaCPF;
	@FXML
	private TextField FielddataNasc;
	@FXML
	private TableView<Medico> tebMed;
	@FXML
	private TableColumn<Medico,String> colNome;
	@FXML
	private TableColumn<Medico,String> colDatanas;
	@FXML
	private TableColumn<Medico,String> colEmail;
	@FXML
	private TableColumn<Medico,String> colTelefone;
	@FXML
	private Button btnBuscar;
	@FXML
	private Button btnCad;

	private ObservableList<Medico> med = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Ancora.setVisible(true);
		
	}
	
	
	@FXML
	public void listenerBtnBuscar(ActionEvent event) {
		Medico medc = new Medico();
		MedicoDAO mD = new MedicoDAO();
		  medc = mD.bucarMedico(fieldBUscaCPF.getText());
		 colDatanas.setCellValueFactory(new PropertyValueFactory<>("dataNasc"));
		 colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		 colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		 colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		 
		 if(medc==null) {
			 LabelAvbusca.setText("Medico não encontrado!");
			 fieldBUscaCPF.clear();
			 tebMed.setVisible(false);
		 }else {
			 tebMed.setVisible(true);
			 LabelAvbusca.setText("Medico encontrado!");
			 fieldBUscaCPF.clear();
			 med.addAll(medc);
			tebMed.setItems(med);
		}
		 	 
	}
	
	
	@FXML
	public void listenerBtnCad(ActionEvent event) {
		Medico medc = new Medico();
		MedicoDAO md = new MedicoDAO();
		medc.setCpf(FieldCPF.getText());
		medc.setDataNasc(FielddataNasc.getText());
		medc.setEmail(fieldEmail.getText());
		medc.setTelefone(fieldTelefone.getText());
		medc.setNome(fieldNome.getText());
		
		md.incluirMedico(medc);
		LabelAvCadmed.setText("Inserção foi um sucesso!");
		
		FieldCPF.clear();
		FielddataNasc.clear();
		fieldEmail.clear();
		fieldTelefone.clear();
		fieldNome.clear();
	}
}
