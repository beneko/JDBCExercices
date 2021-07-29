package org.afpa.model;

public class Fournisseur {

    Integer numfou;
    String nomfou;
    String ruefou;
    String posfou;
    String vilfou;
    String confou;
    Integer satisf;

    public Fournisseur() {
    }

    public Fournisseur(String nomfou, String ruefou, String posfou, String vilfou, String confou) {

        this.nomfou = nomfou;
        this.ruefou = ruefou;
        this.posfou = posfou;
        this.vilfou = vilfou;
        this.confou = confou;

    }

    public Integer getNumfou() {
        return numfou;
    }

    public void setNumfou(Integer numfou) {
        this.numfou = numfou;
    }


    public String getNomfou() {
        return nomfou;
    }

    public void setNomfou(String nomfou) {
        this.nomfou = nomfou;
    }

    public String getRuefou() {
        return ruefou;
    }

    public void setRuefou(String ruefou) {
        this.ruefou = ruefou;
    }

    public String getPosfou() {
        return posfou;
    }

    public void setPosfou(String posfou) {
        this.posfou = posfou;
    }

    public String getVilfou() {
        return vilfou;
    }

    public void setVilfou(String vilfou) {
        this.vilfou = vilfou;
    }

    public String getConfou() {
        return confou;
    }

    public void setConfou(String confou) {
        this.confou = confou;
    }

    public Integer getSatisf() {
        return satisf;
    }

    public void setSatisf(Integer satisf) {
        this.satisf = satisf;
    }

    @Override
    public String toString() {
        return nomfou ;
    }
}
