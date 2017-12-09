package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.Country;
import VtysProje.util.converter.CountryConverter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class CountryDao {
    private DatabaseConnection databaseConnection;

    public CountryDao() {
        try {
            databaseConnection = new DatabaseConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Country> getAll() {
        List<Country> countries = new ArrayList<>();
        try {

            databaseConnection.open();
            String sql = "SELECT * FROM \"Countries\"";
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            countries = CountryConverter.getCountryListFromResultSet(resultSet);

            databaseConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

    public Country getById(int id) {
        Country country = new Country();
        try {

            databaseConnection.open();
            String sql = "SELECT * FROM \"Countries\" WHERE id=" + id;
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            country = CountryConverter.getCountryFromResultSet(resultSet);

            databaseConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return country;
    }

    public Country getByCode(int code) {
        Country country = new Country();
        try {

            databaseConnection.open();
            String sql = "SELECT * FROM \"Countries\" WHERE code=" + code;
            ResultSet resultSet = databaseConnection.executeQuery(sql);
            country = CountryConverter.getCountryFromResultSet(resultSet);

            databaseConnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return country;
    }
}
