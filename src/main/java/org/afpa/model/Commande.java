package org.afpa.model;

import java.sql.Timestamp;
import java.util.Date;

public class Commande {

    Integer numcom;
    String obscom;
    Timestamp datecom;
    Integer numfou;

    public Commande(Integer numcom, String obscom, Timestamp datecom, Integer numfou) {
        this.numcom = numcom;
        this.obscom = obscom;
        this.datecom = datecom;
        this.numfou = numfou;
    }

    public Commande() {

    }

    public Integer getNumcom() {
        return numcom;
    }

    public void setNumcom(Integer numcom) {
        this.numcom = numcom;
    }

    public String getObscom() {
        return obscom;
    }

    public void setObscom(String obscom) {
        this.obscom = obscom;
    }

    public Date getDatecom() {
        return datecom;
    }

    public void setDatecom(Timestamp datecom) {
        this.datecom = datecom;
    }

    public Integer getNumfou() {
        return numfou;
    }

    @Override
    public String toString() {
        return numcom + " " + obscom + " " + datecom;
    }

    public void setNumfou(Integer numfou) {
        this.numfou = numfou;
    }
}
