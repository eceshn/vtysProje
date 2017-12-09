package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.Country;
import VtysProje.util.Converter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class CountryDao {
    private DatabaseConnection connection = MainDao.getConnection();

    public CountryDao() {

    }

    public List<Country> getAll() {
        List<Country> countries = new ArrayList<>();
        try {

            connection.open();
            String sql = "SELECT * FROM \"Countries\"";
            ResultSet resultSet = connection.executeQuery(sql);

            while (!resultSet.isClosed() && resultSet.next()) {
                countries.add(Converter.initCountryFromResultSet(resultSet));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

    public Country getById(int id) {
        Country country = new Country();
        try {
            connection.open();
            String sql = "SELECT * FROM \"Countries\" WHERE id=" + id;
            ResultSet resultSet = connection.executeQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                country = Converter.initCountryFromResultSet(resultSet);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return country;
    }

    public Country getByCode(int code) {
        Country country = new Country();
        try {

            connection.open();
            String sql = "SELECT * FROM \"Countries\" WHERE code=" + code;
            ResultSet resultSet = connection.executeQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                country = Converter.initCountryFromResultSet(resultSet);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return country;
    }
}
