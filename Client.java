package curs8;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Client {

    private final IntegerProperty idclient;
    private final StringProperty NumeClient;
    private final StringProperty Prenume;
    private final StringProperty Adresa;
    private final StringProperty Email;

    public Client(Integer idclient, String NumeClient, String Prenume, String Adresa, String Email) {
        this.idclient = new SimpleIntegerProperty(idclient);
        this.NumeClient = new SimpleStringProperty(NumeClient);
        this.Adresa = new SimpleStringProperty(Adresa);
        this.Prenume = new SimpleStringProperty(Prenume);
        this.Email = new SimpleStringProperty(Email);
       
    }

    public Integer getIdClient() {
        return idclient.get();
    }

    public String getNumeClient() {
        return NumeClient.get();
    }

    public String getAdresa() {
        return Adresa.get();
    }
    
    public String getPrenume() {
        return Prenume.get();
    }
    
    public String getEmail() {
        return Email.get();
    }

    public void setIdClient(Integer valoare) {
        idclient.set(valoare);
    }

    public void setNumeClient(String valoare) {
        NumeClient.set(valoare);
    }

    public void setAdresa(String valoare) {
        Adresa.set(valoare);
    }
    
    public void setPrenume(String valoare) {
        Prenume.set(valoare);
    }
    
    public void setEmail(String valoare) {
        Email.set(valoare);
    }

    public IntegerProperty idclientProperty() {
        return idclient;
    }

    public StringProperty NumeProperty() {
        return NumeClient;
    }

    public StringProperty AdresaProperty() {
        return Adresa;
    }
    
    public StringProperty PrenumeProperty() {
        return Prenume;
    }
    
    public StringProperty EmailProperty() {
        return Email;
    }

}
