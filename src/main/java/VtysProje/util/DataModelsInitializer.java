package VtysProje.util;

import VtysProje.model.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by 12043 on 9.12.2017 part of project vtysProje
 */
public class DataModelsInitializer {

    public static DefaultTableModel initCountriesTableModel(List<Country> countries) {
        DefaultTableModel countriesModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Code"});

        for (Country country : countries) {
            countriesModel.addRow(new Object[]{country.getId(), country.getName(), country.getCode()});
        }

        return countriesModel;
    }

    public static DefaultTableModel initCitiesTableModel(List<City> cities) {
        DefaultTableModel citiesModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Code", "Country"});

        for (City city : cities) {
            citiesModel.addRow(new Object[]{city.getId(), city.getName(), city.getCode(), city.getCountry().getName()});
        }

        return citiesModel;
    }

    public static DefaultTableModel initUsersTableModel(List<User> users) {
        DefaultTableModel usersModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "City", "Username", "First name", "Last name", "Password", "Address", "Phone number", "Role", "Birthday"});

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
                user.getRole().getRole_name(),
                user.getBirthDay()
            });
        }

        return usersModel;
    }

    public static DefaultTableModel initProductsTableModel(List<Product> products) {
        DefaultTableModel productsModel = new DefaultTableModel(new Object[][]{}, new String[]{"ID", "Name", "Unit price", "Detail"});

        for (Product product : products) {
            productsModel.addRow(new Object[]{product.getId(), product.getName(), product.getUnitPrice(), product.getDetail()});
        }

        return productsModel;
    }

    public static DefaultTableModel initStocksTableModel(List<Stock> stocks) {
        DefaultTableModel stocksModel = new DefaultTableModel(new Object[][]{}, new String[]{
            "ID", "Stock name", "Unit price", "Unit price in stock", "Quantity", "Detail"
        });

        for (Stock stock : stocks) {
            stocksModel.addRow(new Object[]{
                stock.getId(), stock.getName(), stock.getProduct().getName(),
                stock.getProduct().getUnitPrice(), stock.getUnitPrice(),
                stock.getQuantity(), stock.getProduct().getDetail()
            });
        }

        return stocksModel;
    }

    public static DefaultComboBoxModel<String> initCountriesComboBoxModel(List<Country> countries) {
        Vector<String> names = new Vector<>();
        names.add("Select...");

        for (Country country : countries) {
            names.add(country.getName());
        }

        return new DefaultComboBoxModel<>(names);
    }

    public static DefaultComboBoxModel<String> initCitiesComboBoxModel(List<City> cities) {
        Vector<String> names = new Vector<>();
        names.add("Select...");

        for (City city : cities) {
            names.add(city.getName());
        }

        return new DefaultComboBoxModel<>(names);
    }

    public static DefaultComboBoxModel<String> initRolesComboBoxModel(List<Role> roles) {
        Vector<String> names = new Vector<>();
        names.add("Select...");

        for (Role role : roles) {
            names.add(role.getRole_name());
        }

        return new DefaultComboBoxModel<>(names);
    }

    public static DefaultComboBoxModel<String> initUsersComboBoxModel(List<User> users) {
        Vector<String> names = new Vector<>();
        names.add("Select...");

        for (User user : users) {
            names.add(user.getUserName());
        }

        return new DefaultComboBoxModel<>(names);
    }

    public static DefaultComboBoxModel<String> initProductsComboBoxModel(List<Product> products) {
        Vector<String> names = new Vector<>();
        names.add("Select...");

        for (Product product : products) {
            names.add(product.getName());
        }

        return new DefaultComboBoxModel<>(names);
    }

    public static DefaultComboBoxModel<String> initStocksComboboxModel(List<Stock> stocks) {
        Vector<String> names = new Vector<>();
        names.add("Select...");

        for (Stock stock : stocks) {
            names.add(stock.getName());
        }

        return new DefaultComboBoxModel<>(names);
    }
}
