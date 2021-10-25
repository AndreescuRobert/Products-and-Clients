package curs8;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Produs {

    private final IntegerProperty idprodus;
    private final StringProperty Denumire;
    private final IntegerProperty Cantitate;


    public Produs(Integer idprodus, String Denumire, Integer Cantitate) {
        this.idprodus = new SimpleIntegerProperty(idprodus);
        this.Denumire = new SimpleStringProperty(Denumire);
        this.Cantitate = new SimpleIntegerProperty(Cantitate);
    }

    public Integer getIdprodus() {
        return idprodus.get();
    }

    public String getDenumire() {
        return Denumire.get();
    }

    public Integer getCantitate() {
        return Cantitate.get();
    }


    public void setIdProdus(Integer valoare) {
        idprodus.set(valoare);
    }

    public void setDenumire(String valoare) {
        Denumire.set(valoare);
    }

    public void setPrenume(Integer valoare) {
        Cantitate.set(valoare);
    }


    public IntegerProperty idprodusProperty() {
        return idprodus;
    }

    public StringProperty DenumireProperty() {
        return Denumire;
    }

    public IntegerProperty CantitateProperty() {
        return Cantitate;
    }


}
