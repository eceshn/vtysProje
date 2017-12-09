package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;

import java.sql.SQLException;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class MainDao {
    private static DatabaseConnection connection;

    public static DatabaseConnection getConnection() {
        try {
            if (connection == null) {
                connection = new DatabaseConnection();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
