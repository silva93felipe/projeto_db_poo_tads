package visao;
import dominio.Pessoa;
import dominio.Usuario;
import persistencia.UsuarioDAO;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.TabPane;

import javafx.scene.control.Tab;

import javafx.scene.control.DatePicker;

import javafx.scene.control.TableView;

import javafx.scene.control.ChoiceBox;

public class WindowHController implements Initializable {
	@FXML
	private TabPane PaneMain;
	@FXML
	private Tab TabCli;
	@FXML
	private Button btnSair;
	@FXML
	private TextField CpfUSU;
	@FXML
	private TextField emailUsu;
	@FXML
	private TextField nomeUsu;
	@FXML
	private TextField telefoneUsu;
	@FXML
	private TextField cidadeCampo;
	@FXML
	private TextField cepCampo;
	@FXML
	private Button btnCadastrar;
	@FXML
	private DatePicker dataCampo;
	@FXML
	private ChoiceBox sexoChoice;
	@FXML
	private TextField cpfCa1;
	@FXML
	private TextField nomeCampo1;
	@FXML
	private TextField nomeCampo2;
	@FXML
	private DatePicker dataCampo1;
	@FXML
	private ChoiceBox sexoChoice1;
	@FXML
	private Button btnCadastrar1;
	@FXML
	private Tab TabMed;
	@FXML
	private TextField cpfMed;
	@FXML
	private TextField emailMed;
	@FXML
	private TextField nomeMed;
	@FXML
	private TextField telefoneMed;
	@FXML
	private Button btnCadMed;
	@FXML
	private DatePicker dataMed;
	@FXML
	private ChoiceBox sexoChoiceMed;
	@FXML
	private TextField cpfCa11;
	@FXML
	private Button btnBuscarMed;
	@FXML
	private TableView tableViAG;

	@Override
public void initialize(URL url, ResourceBundle rb) {
		
		PaneMain.setVisible(true);
	
		
	}
	
	
	@FXML
	private void listenerCadastrarUsu() {
		UsuarioDAO uD;
		Usuario u = new Usuario();
		
		u.setCpf(CpfUSU.getText());
		u.setNome(nomeUsu.getText());
		u.setCidade(cidadeCampo.getText());
		u.setCep(cepCampo.getText());
		u.setDataNasc(dataCampo.getAccessibleText());
		u.setTelefone(telefoneUsu.getText()) ;
		u.setEmail(emailUsu.getText());
		
		TabCli.setText("hello!");
		//sexoChoice.get;
		
		
		
	}
	@FXML
	private void listenerCadastrarDepe() {
		//cpf, nome, dataNas, cpfResp, sexo;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
