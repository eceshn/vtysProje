/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VtysProje.util;

import VtysProje.dao.CityDao;
import VtysProje.dao.CountryDao;
import VtysProje.dao.RoleDao;
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

    public static List<Country> countries;
    public static List<City> cities;
    public static List<Role> roles;
    public static List<User> users;

    public static void initializeData() {
        countries = countryDao.getAll();
        cities = cityDao.getAll();
        users = userDao.getAll();
    }

    public static void refreshCountries() {
        countries = countryDao.getAll();
    }

    public static void refreshCities() {
        cities = cityDao.getAll();
    }
    
    public static void refreshRoles(){
        roles = roleDao.getAll();
    }

    public static void refreshUsers() {
        users = userDao.getAll();
    }
}
