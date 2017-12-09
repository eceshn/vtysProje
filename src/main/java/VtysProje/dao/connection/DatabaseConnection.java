package VtysProje.dao.connection;

import VtysProje.util.Constants;

import java.sql.*;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class DatabaseConnection {
    private Connection connection;
    private Statement statement;

    public DatabaseConnection() throws SQLException {
        connection = DriverManager.getConnection(Constants.databaseUrl, Constants.databaseUserName, Constants.dataBasePassword);
    }

    public ResultSet executeSelectQuery(String query) throws SQLException, Exception {
        if (statement == null || statement.isClosed()) {
            throw new Exception("ERROR: Connection must be opened before execute query.");
        }

        return statement.executeQuery(query);
    }

    public boolean executeUpdateQuery(String query) throws SQLException, Exception {
        if (statement == null || statement.isClosed()) {
            throw new Exception("ERROR: Connection must be opened before execute query.");
        }

        statement.executeUpdate(query);
        return true;
    }

    public void openStatement() throws SQLException {
        statement = connection.createStatement();
    }

    public void closeStatement() throws SQLException {
        statement.close();
    }
}
