package VtysProje.util;

import VtysProje.model.*;
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

    public static User initUserFromResultSet(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setPassword(resultSet.getString("password"));
            user.setAddress(resultSet.getString("address"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setRoleId(resultSet.getInt("role_id"));
            user.setCityId(resultSet.getInt("city_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static Product initProductFromResultSet(ResultSet resultSet) {
        Product product = new Product();
        try {
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDetail(resultSet.getString("detail"));
            product.setUnitPrice(resultSet.getInt("unit_price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    public static Role initRoleFromResultSet(ResultSet resultSet) {
        Role role = new Role();
        try {
            role.setId(resultSet.getInt("id"));
            role.setRole_name(resultSet.getString("role_name"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public static Stock initStockFromResultSet(ResultSet resultSet) {
        Stock stock = new Stock();
        try {
            stock.setId(resultSet.getInt("id"));
            stock.setName(resultSet.getString("name"));
            stock.setQuantity(resultSet.getInt("quantity"));
            stock.setUnitPrice(resultSet.getInt("unit_price"));
            stock.setProductId(resultSet.getInt("product_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stock;
    }
}
