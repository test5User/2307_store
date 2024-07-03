package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.User;

import java.sql.SQLException;

import static by.itclass.constants.DbConst.*;

public class UserDao {
    private static final String SELECT_USER = "SELECT id, name, email FROM user WHERE login=? AND password=?";

    private static UserDao dao;

    private UserDao() {
        ConnectionManager.init();
    }

    public static UserDao getInstance() {
        return  dao == null ? new UserDao() : dao;
    }

    public User selectUser(String login, String password) {
        try (var cn = ConnectionManager.getConnection();
            var ps = cn.prepareStatement(SELECT_USER)) {
            ps.setString(1, login);
            ps.setString(2, password);
            var rs = ps.executeQuery();
            if (rs.next()) {
                var id = rs.getInt(ID_COL);
                var name = rs.getString(NAME_COL);
                var email = rs.getString(EMAIL_COL);
                return new User(id, name, email, login, password.toCharArray());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertUser(User user) {
        return false;
    }
}
