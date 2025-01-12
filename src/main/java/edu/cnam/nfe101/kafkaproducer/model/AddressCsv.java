package edu.cnam.nfe101.kafkaproducer.model;

import com.opencsv.bean.CsvBindByName;

public class AddressCsv {
    @CsvBindByName(column = "cle_interop")
    private String cleInterop;

    @CsvBindByName(column = "voie_nom")
    private String voieNom;

    @CsvBindByName(column = "numero")
    private Integer numero;

    @CsvBindByName(column = "suffixe")
    private String suffixe;

    @CsvBindByName(column = "cad_parcelles")
    private String cadParcelles;

    @CsvBindByName(column = "x")
    private String x;

    @CsvBindByName(column = "y")
    private String y;

    @CsvBindByName(column = "long")
    private String longitude;

    @CsvBindByName(column = "lat")
    private String latitude;

    public String getCleInterop() {
        return cleInterop;
    }

    public void setCleInterop(String cleInterop) {
        this.cleInterop = cleInterop;
    }

    public String getVoieNom() {
        return voieNom;
    }

    public void setVoieNom(String voieNom) {
        this.voieNom = voieNom;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getSuffixe() {
        return suffixe;
    }

    public void setSuffixe(String suffixe) {
        this.suffixe = suffixe;
    }

    public String getCadParcelles() {
        return cadParcelles;
    }

    public void setCadParcelles(String cadParcelles) {
        this.cadParcelles = cadParcelles;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
