package by.itclass.model.dao;

import by.itclass.model.db.ConnectionManager;
import by.itclass.model.entities.Order;

import java.util.List;

public class OrderHistoryDao {
    private static OrderHistoryDao dao;

    public OrderHistoryDao() {
        ConnectionManager.init();
    }

    public static OrderHistoryDao getInstance() {
        return dao == null ? new OrderHistoryDao() : dao;
    }

    public List<Order> selectOrders(int userId) {
        return null;
    }
}
