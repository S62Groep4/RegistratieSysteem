package interfaces;

import java.io.Serializable;

public class TransLocationDto implements Serializable {

    private Double lat;
    private Double lon;
    private String dateTime;
    private String serialNumber;
    private String countryCode; //Country the car is driving in

    public TransLocationDto() {

    }

    public TransLocationDto(Double lat, Double lon, String dateTime, String serialNumber, String countryCode) {
        this.serialNumber = serialNumber;
        this.lat = lat;
        this.lon = lon;
        this.dateTime = dateTime;
        this.countryCode = countryCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
