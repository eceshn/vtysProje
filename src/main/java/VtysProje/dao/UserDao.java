package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.User;
import VtysProje.util.Converter;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017
 * part of project vtysProje
 */

public class UserDao {
    private DatabaseConnection connection = MainDao.getConnection();

    private CityDao cityDao;
    private RoleDao roleDao;

    public UserDao() {
        cityDao = new CityDao();
        roleDao = new RoleDao();
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Users\"";
            ResultSet resultSet = connection.executeSelectQuery(sql);

            while (!resultSet.isClosed() && resultSet.next()) {
                User user = Converter.initUserFromResultSet(resultSet);
                user.setCity(cityDao.getById(user.getCityId()));
                user.setRole(roleDao.getById(user.getRoleId()));
                users.add(user);
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public User getById(int id) {
        User user = new User();

        try {
            connection.openStatement();

            String sql = "SELECT * FROM \"Users\" WHERE id=" + id;
            ResultSet resultSet = connection.executeSelectQuery(sql);
            if (!resultSet.isClosed() && resultSet.next()) {
                user = Converter.initUserFromResultSet(resultSet);
                user.setCity(cityDao.getById(user.getCityId()));
                user.setRole(roleDao.getById(user.getRoleId()));
            }

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
