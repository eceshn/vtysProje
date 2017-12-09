package VtysProje.util;

import VtysProje.model.City;
import VtysProje.model.Country;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class Converter {
    public static Country initCountryFromResultSet(ResultSet resultSet) {
        Country country = new Country();
        try {
            country.setId(resultSet.getInt("id"));
            country.setName(resultSet.getString("name"));
            country.setCode(resultSet.getInt("code"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return country;
    }

    public static City initCityFromResultSet(ResultSet resultSet) {
        City city = new City();
        try {
            city.setId(resultSet.getInt("id"));
            city.setName(resultSet.getString("name"));
            city.setCode(resultSet.getInt("code"));
            city.setCountryId(resultSet.getInt("country_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }
}
