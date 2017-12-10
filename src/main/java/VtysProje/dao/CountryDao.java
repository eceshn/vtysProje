package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.Country;
import VtysProje.util.Converter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017 part of project vtysProje
 */
public class CountryDao {

    private DatabaseConnection connection = MainDao.getConnection();

    public List<Country> getAll() {
        List<Country> countries = new ArrayList<>();
        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Countries\"";
            ResultSet resultSet = connection.executeSelectQuery(sql);

            while (!resultSet.isClosed() && resultSet.next()) {
                countries.add(Converter.initCountryFromResultSet(resultSet));
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countries;
    }

    public Country getById(int id) {
        Country country = new Country();
        try {

            connection.openStatement();
            String sql = "SELECT * FROM \"Countries\" WHERE id=" + id;
            ResultSet resultSet = connection.executeSelectQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                country = Converter.initCountryFromResultSet(resultSet);
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return country;
    }

    public Country getByCode(int code) {
        Country country = new Country();
        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Countries\" WHERE code=" + code;
            ResultSet resultSet = connection.executeSelectQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                country = Converter.initCountryFromResultSet(resultSet);
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return country;
    }

    public boolean add(Country country) {
        boolean added = false;
        try {
            connection.openStatement();

            String sql = "INSERT INTO \"Countries\"(name, code) VALUES ('" + country.getName() + "', " + country.getCode() + ")";
            added = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return added;
    }

    public boolean update(Country country) {
        boolean updated = false;

        try {
            connection.openStatement();

            String sql = "UPDATE \"Countries\" SET name='" + country.getName() + "', code=" + country.getCode()
                    + "WHERE id=" + country.getId();
            updated = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated;
    }

    public boolean delete(int id) {
        boolean deleted = false;

        try {
            connection.openStatement();

            String sql = "DELETE FROM \"Countries\" WHERE id=" + id;
            deleted = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
