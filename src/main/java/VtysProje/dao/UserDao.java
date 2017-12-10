package VtysProje.dao;

import VtysProje.dao.connection.DatabaseConnection;
import VtysProje.model.User;
import VtysProje.util.Converter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 12043 on 9.12.2017 part of project vtysProje
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

            String sql = "SELECT "
                    + "id"
                    + ", first_name"
                    + ", last_name"
                    + ", user_name"
                    + ", password"
                    + ", address"
                    + ", phone_number"
                    + ", role_id"
                    + ", city_id"
                    + ", TO_CHAR(birthday, 'mm/dd/yyyy') AS birthday"
                    + " FROM \"Users\"";
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

            String sql = "SELECT "
                    + "id"
                    + ", first_name"
                    + ", last_name"
                    + ", user_name"
                    + ", password"
                    + ", address"
                    + ", phone_number"
                    + ", role_id"
                    + ", city_id"
                    + ", TO_CHAR(birthday, 'mm/dd/yyyy') AS birthday"
                    + " FROM \"Users\" WHERE id=" + id;
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

    public boolean add(User user) {
        boolean added = false;
        try {
            connection.openStatement();

            String sql = "INSERT INTO \"Users\"("
                    + "first_name, last_name, user_name, password, address, phone_number, role_id, city_id, birthday) VALUES " + "("
                    + "'" + user.getFirstName() + "'"
                    + ", '" + user.getLastName() + "'"
                    + ", '" + user.getUserName() + "'"
                    + ", '" + user.getPassword() + "'"
                    + ", '" + user.getAddress() + "'"
                    + ", '" + user.getPhoneNumber() + "'"
                    + ", " + user.getRoleId()
                    + ", " + user.getCityId()
                    + ", TO_DATE('" + user.getBirthDay() + "', 'mm/dd/yyyy')"
                    + ")";

            added = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return added;
    }

    public boolean update(User user) {
        boolean updated = false;

        try {
            connection.openStatement();

            String sql = "UPDATE \"Users\" SET "
                    + "first_name='" + user.getFirstName() + "'"
                    + ", last_name='" + user.getLastName() + "'"
                    + ", user_name='" + user.getUserName() + "'"
                    + ", password='" + user.getPassword() + "'"
                    + ", address='" + user.getAddress() + "'"
                    + ", phone_number='" + user.getPhoneNumber() + "'"
                    + ", role_id=" + user.getRoleId()
                    + ", city_id=" + user.getCityId()
                    + ", birthday=TO_DATE('" + user.getBirthDay() + "', 'mm/dd/yyyy')"
                    + " WHERE id=" + user.getId();

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

            String sql = "DELETE FROM \"Users\" WHERE id=" + id;
            deleted = connection.executeUpdateQuery(sql);

            connection.closeStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deleted;
    }
}
