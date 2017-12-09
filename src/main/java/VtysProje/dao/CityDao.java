package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.City;
import VtysProje.model.Country;
import VtysProje.util.Converter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
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

            connection.open();

            String sql = "SELECT * FROM \"Cities\"";
            ResultSet resultSet = connection.executeQuery(sql);

            while (!resultSet.isClosed() && resultSet.next()) {
                City city = Converter.initCityFromResultSet(resultSet);

                String countrySql = "SELECT * FROM \"Countries\" WHERE id=" + city.getCountryId();
                ResultSet countrySet = connection.executeQuery(countrySql);
                if (!countrySet.isClosed() && countrySet.next()) {
                    Country country = Converter.initCountryFromResultSet(countrySet);
                    city.setCountry(country);
                }

                cities.add(city);
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cities;
    }

    public City getById(int id) {
        City city = new City();
        try {

            connection.open();
            String sql = "SELECT * FROM \"Cities\" WHERE id=" + id;
            ResultSet resultSet = connection.executeQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                city = Converter.initCityFromResultSet(resultSet);

                city.setCountry(countryDao.getById(city.getCountryId()));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return city;
    }

    public City getByCode(int code) {
        City city = new City();
        try {

            connection.open();
            String sql = "SELECT * FROM \"Cities\" WHERE code=" + code;
            ResultSet resultSet = connection.executeQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                city = Converter.initCityFromResultSet(resultSet);

                city.setCountry(countryDao.getById(city.getCountryId()));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return city;
    }
}
