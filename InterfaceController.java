package curs8;


import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import javafx.scene.input.MouseEvent;


public class Curs8Controller implements Initializable {
    
    @FXML
    private TableView<Produs> tabela_Produse;
    @FXML
    private Tab tab_Produse;
    @FXML
    private Button buton_IncarcareProduse;
    @FXML
    private Button buton_adaugareProduse;
    @FXML
    private Button buton_stergereProduse;
    @FXML
    private Button buton_modificareProduse;
    @FXML
    private TableColumn<Produs, Integer> atribut_idprodus;
    @FXML
    private TableColumn<Produs, String> atribut_Denumire;
    @FXML
    private TableColumn<Produs, Integer> atribut_Cantitate;
    @FXML
    private TextField txt_idProdus;
    @FXML
    private TextField txt_denumire;
    @FXML
    private TextField txt_cantitate;
    
    @FXML
    private TableView<Furnizor> tabela_Furnizori;
    @FXML
    private Tab tab_Furnizori;
    @FXML
    private Button buton_IncarcareFurnizori;
    @FXML
    private Button buton_adaugareFurnizori;
    @FXML
    private Button buton_stergereFurnizori;
    @FXML
    private Button buton_modificareFurnizori;
    @FXML
    private TableColumn<Furnizor, Integer> atribut_idfurnizor;
    @FXML
    private TableColumn<Furnizor, String> atribut_NumeF;
    @FXML
    private TableColumn<Furnizor, String> atribut_AdresaF;
    @FXML
    private TextField txt_idFurnizor;
    @FXML
    private TextField txt_numeFurnizor;
    @FXML
    private TextField txt_adresaFurnizor;
    
    @FXML
    private TableView<Client> tabela_Clienti;
    @FXML
    private Tab tab_Clienti;
    @FXML
    private Button buton_IncarcareClienti;
    @FXML
    private Button buton_adaugareClienti;
    @FXML
    private Button buton_stergereClienti;
    @FXML
    private Button buton_modificareClienti;
    @FXML
    private TableColumn<Client, Integer> atribut_idclient;
    @FXML
    private TableColumn<Client, String> atribut_NumeC;
    @FXML
    private TableColumn<Client, String> atribut_Prenume;
    @FXML
    private TableColumn<Client, String> atribut_AdresaC;
    @FXML
    private TableColumn<Client, String> atribut_Email;
    @FXML
    private TextField txt_idClient;
    @FXML
    private TextField txt_numeClient;
    @FXML
    private TextField txt_prenume;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_adresaClient;
    
    private ObservableList<Produs> dateProduse;
    private ObservableList<Furnizor> dateFurnizori;
    private ObservableList<Client> dateClienti;
    private DBOperations jb;
    
    int index = -1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jb = new DBOperations();
    }    

    @FXML
    private void incarcaProduse(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateProduse = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("produse");
        //jb.afisare(rs);
        //System.out.println("test");
        while (rs.next()) {
            dateProduse.add(new Produs(rs.getInt("idprodus"), rs.getString("Denumire"), rs.getInt("Cantitate")));
        }

        atribut_idprodus.setCellValueFactory(new PropertyValueFactory<>("idprodus"));
        atribut_Denumire.setCellValueFactory(new PropertyValueFactory<>("Denumire"));
        atribut_Cantitate.setCellValueFactory(new PropertyValueFactory<>("Cantitate"));
        
        tabela_Produse.setItems(null);
        tabela_Produse.setItems(dateProduse);
        jb.disconnect();
    }

    @FXML
    private void incarcaFurnizori(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateFurnizori = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("furnizori");
        while (rs.next()) {
            dateFurnizori.add(new Furnizor(rs.getInt("idfurnizor"), rs.getString("NumeFurnizor"), rs.getString("Adresa")));
        }

        atribut_idfurnizor.setCellValueFactory(new PropertyValueFactory<>("idfurnizor"));
        atribut_NumeF.setCellValueFactory(new PropertyValueFactory<>("NumeFurnizor"));
        atribut_AdresaF.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
        
        tabela_Furnizori.setItems(null);
        tabela_Furnizori.setItems(dateFurnizori);
        jb.disconnect();
    }
    
    @FXML
    private void incarcaClienti(ActionEvent event) throws SQLException, Exception {
        jb.connect();
        dateClienti = FXCollections.observableArrayList();

        ResultSet rs = jb.vedeTabel("clienti");
        while (rs.next()) {
            dateClienti.add(new Client(rs.getInt("idclient"), rs.getString("NumeClient"), rs.getString("Prenume"), rs.getString("Adresa"), rs.getString("Email")));
        }

        atribut_idclient.setCellValueFactory(new PropertyValueFactory<>("idclient"));
        atribut_NumeC.setCellValueFactory(new PropertyValueFactory<>("NumeClient"));
        atribut_AdresaC.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
        atribut_Prenume.setCellValueFactory(new PropertyValueFactory<>("Prenume"));
        atribut_Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        
        tabela_Clienti.setItems(null);
        tabela_Clienti.setItems(dateClienti);
        
        jb.disconnect();
    }
    
    @FXML
    private void adaugareClienti(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	jb.adaugaClient(txt_numeClient.getText(), txt_prenume.getText(), txt_adresaClient.getText(), txt_email.getText());
    	JOptionPane.showMessageDialog(null, "Adaugare realizata cu succes");
    	jb.disconnect();
    }
    
    @FXML
    private void adaugareFurnizori(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	jb.adaugaFurnizor(txt_numeFurnizor.getText(), txt_adresaFurnizor.getText());
    	JOptionPane.showMessageDialog(null, "Adaugare realizata cu succes");
    	jb.disconnect();
    }
    
    @FXML
    private void adaugareProduse(ActionEvent event) throws SQLException, Exception {
    	jb.connect();
    	jb.adaugaProdus(txt_denumire.getText(), Integer.parseInt(txt_cantitate.getText()));
    	JOptionPane.showMessageDialog(null, "Adaugare realizata cu succes");
    	jb.disconnect();
    }
    
    @FXML
    void getSelectedClienti (MouseEvent event){
    	index = tabela_Clienti.getSelectionModel().getSelectedIndex();
    	if (index <= -1){
    
    		return;
    	}
    	txt_idClient.setText(atribut_idclient.getCellData(index).toString());
    	txt_numeClient.setText(atribut_NumeC.getCellData(index).toString());
    	txt_prenume.setText(atribut_Prenume.getCellData(index).toString());
    	txt_email.setText(atribut_Email.getCellData(index).toString());
    	txt_adresaClient.setText(atribut_AdresaC.getCellData(index).toString());
    
    }
    
    @FXML
    void getSelectedFurnizori (MouseEvent event){
    	index = tabela_Furnizori.getSelectionModel().getSelectedIndex();
    	if (index <= -1){
    
    		return;
    	}
    	txt_idFurnizor.setText(atribut_idfurnizor.getCellData(index).toString());
    	txt_numeFurnizor.setText(atribut_NumeF.getCellData(index).toString());
    	txt_adresaFurnizor.setText(atribut_AdresaF.getCellData(index).toString());
    
    }
    
    @FXML
    void getSelectedProduse (MouseEvent event){
    	index = tabela_Produse.getSelectionModel().getSelectedIndex();
    	if (index <= -1){
    
    		return;
    	}
    	txt_idProdus.setText(atribut_idprodus.getCellData(index).toString());
    	txt_denumire.setText(atribut_Denumire.getCellData(index).toString());
    	txt_cantitate.setText(atribut_Cantitate.getCellData(index).toString());
    }
    
    public void modificaProdus (ActionEvent event) throws SQLException, Exception {   
    	//modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
    	jb.connect();
    	String[] valori = { txt_denumire.getText(), txt_cantitate.getText() };
    	String[] campuri = { "denumire", "cantitate" };
    	jb.modificaTabela("produse", "idprodus", Integer.parseInt(txt_idProdus.getText()), campuri, valori);
    	JOptionPane.showMessageDialog(null, "Modificare realizata cu succes");
    	jb.disconnect();
    }
    
    public void modificaFurnizor (ActionEvent event) throws SQLException, Exception {   
    	//modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
    	jb.connect();
    	String[] valori = { txt_numeFurnizor.getText(), txt_adresaFurnizor.getText() };
    	String[] campuri = { "numefurnizor", "adresa" };
    	jb.modificaTabela("furnizori", "idfurnizor", Integer.parseInt(txt_idFurnizor.getText()), campuri, valori);
    	JOptionPane.showMessageDialog(null, "Modificare realizata cu succes");
    	jb.disconnect();
    }
    
    public void modificaClient (ActionEvent event) throws SQLException, Exception {   
    	//modificaTabela(String tabela, String primarykey, long ID, String[] campuri, String[] valori)
    	jb.connect();
    	String[] valori = { txt_numeClient.getText(), txt_prenume.getText(), txt_adresaClient.getText(), txt_email.getText() };
    	String[] campuri = { "numeclient", "prenume", "adresa", "email" };
    	jb.modificaTabela("clienti", "idclient", Integer.parseInt(txt_idClient.getText()), campuri, valori);
    	JOptionPane.showMessageDialog(null, "Modificare realizata cu succes");
    	jb.disconnect();
    }
    
    public void stergeProdus (ActionEvent event) throws SQLException, Exception {
        jb.connect();
        //public void stergeTabela(String tabela, String denumirePK, long id)
        jb.stergeTabela("produse", "idprodus", Integer.parseInt(txt_idProdus.getText()));
        JOptionPane.showMessageDialog(null, "Stergere realizata cu succes");
        jb.disconnect();
     }
    
    public void stergeFurnizor (ActionEvent event) throws SQLException, Exception {
        jb.connect();
        //public void stergeTabela(String tabela, String denumirePK, long id)
        jb.stergeTabela("furnizori", "idfurnizor", Integer.parseInt(txt_idFurnizor.getText()));
        JOptionPane.showMessageDialog(null, "Stergere realizata cu succes");
        jb.disconnect();
     }
    
    public void stergeClient (ActionEvent event) throws SQLException, Exception {
        jb.connect();
        //public void stergeTabela(String tabela, String denumirePK, long id)
        jb.stergeTabela("clienti", "idclient", Integer.parseInt(txt_idClient.getText()));
        JOptionPane.showMessageDialog(null, "Stergere realizata cu succes");
        jb.disconnect();
     }
}
