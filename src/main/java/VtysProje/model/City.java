package VtysProje.model;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class City {
    private int id;
    private String name;
    private int code;
    private int countryId;

    private Country country;

    public City() {
    }

    public City(int id, String name, int code, int countryId, Country country) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.countryId = countryId;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
