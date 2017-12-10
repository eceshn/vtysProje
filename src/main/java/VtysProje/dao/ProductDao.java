/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.Product;
import VtysProje.util.Converter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 12043
 */
public class ProductDao {

    private DatabaseConnection connection = MainDao.getConnection();

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Products\"";
            ResultSet resultSet = connection.executeSelectQuery(sql);

            while (!resultSet.isClosed() && resultSet.next()) {
                products.add(Converter.initProductFromResultSet(resultSet));
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product getById(int id) {
        Product product = new Product();
        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Products\" WHERE id=" + id;
            ResultSet resultSet = connection.executeSelectQuery(sql);

            if (!resultSet.isClosed() && resultSet.next()) {
                product = Converter.initProductFromResultSet(resultSet);
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return product;
    }

    public boolean add(Product product) {
        boolean added = false;
        try {
            connection.openStatement();

            String sql = "INSERT INTO \"Products\"(name, unit_price, detail) VALUES ("
                    + "'" + product.getName() + "'"
                    + ", " + product.getUnitPrice()
                    + ", '" + product.getDetail() + "'"
                    + ")";
            added = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return added;
    }

    public boolean update(Product product) {
        boolean updated = false;

        try {
            connection.openStatement();

            String sql = "UPDATE \"Products\" SET "
                    + "name='" + product.getName() + "'"
                    + ", unit_price=" + product.getUnitPrice()
                    + ", detail='" + product.getDetail() + "'"
                    + "WHERE id=" + product.getId();
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

            String sql = "DELETE FROM \"Products\" WHERE id=" + id;
            deleted = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
