package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static by.itclass.constants.DbConst.*;

public class OrderHistoryDao {

    private static final String SELECT_ORDERS = "SELECT id, date, address FROM orders WHERE userId = ? ORDER BY id DESC";
    private static OrderHistoryDao dao;

    public OrderHistoryDao() {
        ConnectionManager.init();
    }

    public static OrderHistoryDao getInstance() {
        return dao == null ? new OrderHistoryDao() : dao;
    }

    public List<Order> selectOrders(int userId) {
        var orders = new ArrayList<Order>();
        try (var cn = ConnectionManager.getConnection();
            var ps = cn.prepareStatement(SELECT_ORDERS)) {
            ps.setInt(1, userId);
            var rs = ps.executeQuery();
            while (rs.next()) {
                var id = rs.getString(ID_COL);
                var date = rs.getString(DATE_COL);
                var address = rs.getString(ADDRESS_COL);
                orders.add(new Order(id, date, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
