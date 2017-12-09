package VtysProje;

import VtysProje.model.City;
import VtysProje.model.Country;
import VtysProje.model.User;

import javax.swing.table.DefaultTableModel;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class DataListsCache {
    public static DefaultTableModel countriesModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Code"});
    public static DefaultTableModel citiesModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Code", "Country"});
    public static DefaultTableModel usersModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "City", "Username", "First name", "Last name", "Password", "Address", "Phone number", "Role"});
    public static DefaultTableModel productsModel = new DefaultTableModel();
    public static DefaultTableModel stocksModel = new DefaultTableModel();

    public static DefaultTableModel refreshCountries(List<Country> countries) {
        for (Country country : countries) {
            countriesModel.addRow(new Object[]{country.getId(), country.getName(), country.getCode()});
        }

        return countriesModel;
    }

    public static DefaultTableModel refreshCities(List<City> cities) {
        for (City city : cities) {
            citiesModel.addRow(new Object[]{city.getId(), city.getName(), city.getCode(), city.getCountry().getName()});
        }

        return citiesModel;
    }

    public static DefaultTableModel refreshUsers(List<User> users) {
        for (User user : users) {
            usersModel.addRow(new Object[]{
                    user.getId(),
                    user.getCity().getName(),
                    user.getUserName(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPassword(),
                    user.getAddress(),
                    user.getPhoneNumber(),
                    user.getRole()
            });
        }

        return usersModel;
    }
}
