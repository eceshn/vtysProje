/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VtysProje.util;

import VtysProje.dao.CityDao;
import VtysProje.dao.CountryDao;
import VtysProje.dao.ProductDao;
import VtysProje.dao.RoleDao;
import VtysProje.dao.StockDao;
import VtysProje.dao.UserDao;
import VtysProje.model.*;
import java.util.List;

/**
 *
 * @author 12043
 */
public class DataCache {

    public static CountryDao countryDao = new CountryDao();
    public static CityDao cityDao = new CityDao();
    public static RoleDao roleDao = new RoleDao();
    public static UserDao userDao = new UserDao();
    public static ProductDao productDao = new ProductDao();
    public static StockDao stockDao = new StockDao();

    public static List<Country> countries;
    public static List<City> cities;
    public static List<Role> roles;
    public static List<User> users;
    public static List<Product> products;
    public static List<Stock> stocks;

    public static void initializeData() {
        countries = countryDao.getAll();
        cities = cityDao.getAll();
        roles = roleDao.getAll();
        users = userDao.getAll();
        products = productDao.getAll();
        stocks = stockDao.getAll();
    }

    public static void refreshCountries() {
        countries = countryDao.getAll();
    }

    public static void refreshCities() {
        cities = cityDao.getAll();
    }

    public static void refreshRoles() {
        roles = roleDao.getAll();
    }

    public static void refreshUsers() {
        users = userDao.getAll();
    }

    public static void refreshProducts() {
        products = productDao.getAll();
    }

    public static void refreshStocks() {
        stocks = stockDao.getAll();
    }
}
