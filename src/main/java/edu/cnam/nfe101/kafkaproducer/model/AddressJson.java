package edu.cnam.nfe101.kafkaproducer.model;

public class AddressJson {
    private String interoperabilityKey;
    private String address;
    private Integer number;
    private String suffix;
    private String cadastralParcel;
    private String x;
    private String y;
    private String longitude;
    private String latitude;

    public String getInteroperabilityKey() {
        return interoperabilityKey;
    }

    public void setInteroperabilityKey(String interoperabilityKey) {
        this.interoperabilityKey = interoperabilityKey;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getCadastralParcel() {
        return cadastralParcel;
    }

    public void setCadastralParcel(String cadastralParcel) {
        this.cadastralParcel = cadastralParcel;
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
