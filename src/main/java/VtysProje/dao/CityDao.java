package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.City;
import VtysProje.util.Converter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017 part of project vtysProje
 */
public class CityDao {

    private DatabaseConnection connection = MainDao.getConnection();

    private CountryDao countryDao;

    public CityDao() {
        countryDao = new CountryDao();
    }

    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Cities\"";
            ResultSet resultSet = connection.executeSelectQuery(sql);

            while (!resultSet.isClosed() && resultSet.next()) {
                City city = Converter.initCityFromResultSet(resultSet);
                city.setCountry(countryDao.getById(city.getCountryId()));
                cities.add(city);
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }

    public City getById(int id) {
        City city = new City();
        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Cities\" WHERE id=" + id;
            ResultSet resultSet = connection.executeSelectQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                city = Converter.initCityFromResultSet(resultSet);
                city.setCountry(countryDao.getById(city.getCountryId()));
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return city;
    }

    public City getByCode(int code) {
        City city = new City();
        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Cities\" WHERE code=" + code;
            ResultSet resultSet = connection.executeSelectQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                city = Converter.initCityFromResultSet(resultSet);
                city.setCountry(countryDao.getById(city.getCountryId()));
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return city;
    }

    public boolean add(City city) {
        boolean added = false;
        try {
            connection.openStatement();

            String sql = "INSERT INTO \"Cities\"(name, code, country_id) VALUES "
                    + "('" + city.getName() + "', " + city.getCode() + ", " + city.getCountryId() + ")";
            added = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return added;
    }

    public boolean update(City city) {
        boolean updated = false;

        try {
            connection.openStatement();

            String sql = "UPDATE \"Cities\" SET \"name\"='" + city.getName() + "', code=" + city.getCode() + ", country_id=" + city.getCountryId()
                    + " WHERE id=" + city.getId();
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

            String sql = "DELETE FROM \"Cities\" WHERE id=" + id;
            deleted = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
