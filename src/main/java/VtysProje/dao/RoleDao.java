package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.Role;
import VtysProje.util.Converter;

import java.sql.ResultSet;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class RoleDao {
    private DatabaseConnection connection = MainDao.getConnection();

    public Role getById(int id) {
        Role role = new Role();

        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Roles\" WHERE id=" + id;
            ResultSet resultSet = connection.executeSelectQuery(sql);
            if (!resultSet.isClosed() && resultSet.next()) {
                role = Converter.initRoleFromResultSet(resultSet);
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;
    }
}
