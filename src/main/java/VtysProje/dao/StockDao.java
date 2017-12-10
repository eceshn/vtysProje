/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.Stock;
import VtysProje.util.Converter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 12043
 */
public class StockDao {

    private DatabaseConnection connection = MainDao.getConnection();

    private ProductDao productDao;

    public StockDao() {
        productDao = new ProductDao();
    }

    public List<Stock> getAll() {
        List<Stock> stocks = new ArrayList<>();
        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Stocks\"";
            ResultSet resultSet = connection.executeSelectQuery(sql);

            while (!resultSet.isClosed() && resultSet.next()) {
                Stock stock = Converter.initStockFromResultSet(resultSet);
                stock.setProduct(productDao.getById(stock.getProductId()));
                stocks.add(stock);
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stocks;
    }

    public boolean add(Stock stock) {
        boolean added = false;
        try {
            connection.openStatement();

            String sql = "INSERT INTO \"Stocks\"(name, product_id, quantity, unit_price) VALUES ("
                    + "'" + stock.getName() + "'"
                    + ", " + stock.getProductId()
                    + ", " + stock.getQuantity()
                    + ", " + stock.getUnitPrice()
                    + ")";

            added = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return added;
    }

    public boolean update(Stock stock) {
        boolean updated = false;

        try {
            connection.openStatement();

            String sql = "UPDATE \"Stocks\" SET "
                    + "name='" + stock.getName() + "'"
                    + ", product_id=" + stock.getProductId()
                    + ", quantity=" + stock.getQuantity()
                    + ", unit_price=" + stock.getUnitPrice()
                    + " WHERE id=" + stock.getId();

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

            String sql = "DELETE FROM \"Stocks\" WHERE id=" + id;
            deleted = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
