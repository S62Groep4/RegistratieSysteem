package interfaces;

import java.io.Serializable;

public class TransLocationDto implements Serializable {

    private String serialNumber;
    private String lat;
    private String lon;
    private String timestamp;
    private String countryCode; //Country the car is driving in

    public TransLocationDto() {

    }

    public TransLocationDto(String serialNumber, String lat, String lon, String timestamp, String countryCode) {
        this.serialNumber = serialNumber;
        this.lat = lat;
        this.lon = lon;
        this.timestamp = timestamp;
        this.countryCode = countryCode;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
