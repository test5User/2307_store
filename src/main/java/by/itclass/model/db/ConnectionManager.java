package by.itclass.model.db;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass
public class ConnectionManager {
    public static final String URL = "jdbc:mysql://localhost:3306/2307_store_db";
    private Connection cn;

    @SneakyThrows
    public static void init() {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    public static Connection getConnection() throws SQLException {
        if(cn == null || cn.isClosed()) {
            cn = DriverManager.getConnection(URL, "root", "");
        }
        return cn;
    }
}
