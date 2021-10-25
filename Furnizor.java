package curs8;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Furnizor {

    private final IntegerProperty idfurnizor;
    private final StringProperty NumeFurnizor;
    private final StringProperty Adresa;

    public Furnizor(Integer idfurnizor, String NumeFurnizor, String Adresa) {
        this.idfurnizor = new SimpleIntegerProperty(idfurnizor);
        this.NumeFurnizor = new SimpleStringProperty(NumeFurnizor);
        this.Adresa = new SimpleStringProperty(Adresa);
       
    }

    public Integer getIdFurnizor() {
        return idfurnizor.get();
    }

    public String getNumeFurnizor() {
        return NumeFurnizor.get();
    }

    public String getAdresa() {
        return Adresa.get();
    }


    public void setIdFurnizor(Integer valoare) {
        idfurnizor.set(valoare);
    }

    public void setNume(String valoare) {
        NumeFurnizor.set(valoare);
    }

    public void setAdresa(String valoare) {
        Adresa.set(valoare);
    }


    public IntegerProperty idfurnizorProperty() {
        return idfurnizor;
    }

    public StringProperty NumeProperty() {
        return NumeFurnizor;
    }

    public StringProperty AdresaProperty() {
        return Adresa;
    }

}
