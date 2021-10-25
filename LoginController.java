package curs8;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.Tab;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ComboBox;
//import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
//import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
//import curs8.DBOperations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginController implements Initializable {

    @FXML
    private Tab tab_Login;

    @FXML
    private Button buton_Login;

    @FXML
    private TextField txt_usernameLogin;

    @FXML
    private ComboBox atribut_tipLogin;

    @FXML
    private PasswordField txt_passwordLogin;

    @FXML
    private Tab tab_Register;

    @FXML
    private Button buton_Register;

    @FXML
    private ComboBox atribut_tipRegister;

    @FXML
    private TextField txt_username_Register;

    @FXML
    private PasswordField txt_passwordRegister;
    
    private DBOperations jb;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	jb = new DBOperations();
    	atribut_tipRegister.getItems().addAll("administrator", "client");
    	atribut_tipLogin.getItems().addAll("administrator", "client");
    }
    
    @FXML  
    private void Login (ActionEvent event) throws Exception{  
    	Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect3?useSSL=false", "root", "Andreescu1999");
    	String sql = "Select * from utilizatori where username = ? and parola = ? and tip = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_usernameLogin.getText());
            pst.setString(2, doHashing(txt_passwordLogin.getText()));
            pst.setString(3, atribut_tipLogin.getValue().toString());
            
            rs = pst.executeQuery();
            
            if(rs.next()){ 
                JOptionPane.showMessageDialog(null, "Corect Username And Password");
                
                buton_Login.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Curs8.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
            }else
                JOptionPane.showMessageDialog(null, "Invalide Username Or Password");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void adaugaUtilizator(ActionEvent event) throws Exception{    
    	Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect3?useSSL=false", "root", "Andreescu1999");
        String sql = "insert into utilizatori (username,parola,tip) values (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username_Register.getText());
            pst.setString(2, doHashing(txt_passwordRegister.getText()));
            pst.setString(3, atribut_tipRegister.getValue().toString());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Inregistrare reusita");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }  
    }
    
    public static String doHashing (String password) {
    	  try {
    	   MessageDigest messageDigest = MessageDigest.getInstance("MD5");
    	   
    	   messageDigest.update(password.getBytes());
    	   
    	   byte[] resultByteArray = messageDigest.digest();
    	   
    	   StringBuilder sb = new StringBuilder();
    	   
    	   for (byte b : resultByteArray) {
    	    sb.append(String.format("%02x", b));
    	   }
    	   
    	   return sb.toString();
    	   
    	  } catch (NoSuchAlgorithmException e) {
    	   e.printStackTrace();
    	  }
    	  
    	  return "";
    	 }

}
