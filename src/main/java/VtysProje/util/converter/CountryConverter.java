package VtysProje.util.converter;

import VtysProje.model.Country;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class CountryConverter {
    public static List<Country> getCountryListFromResultSet(ResultSet resultSet) {
        List<Country> countries = new ArrayList<>();
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    Country country = new Country();
                    country.setId(resultSet.getInt("id"));
                    country.setName(resultSet.getString("name"));
                    country.setCode(resultSet.getInt("code"));

                    countries.add(country);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return countries;
    }

    public static Country getCountryFromResultSet(ResultSet resultSet) {
        Country country = new Country();
        try {
            if (resultSet != null && resultSet.next()) {

                country.setId(resultSet.getInt("id"));
                country.setName(resultSet.getString("name"));
                country.setCode(resultSet.getInt("code"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return country;
    }
}
