package by.itclass.model.services;

import by.itclass.model.dao.OrderHistoryDao;
import by.itclass.model.entities.Order;

import java.util.List;
import java.util.Objects;

public class OrderHistoryService implements Service {
    private OrderHistoryDao dao;

    public OrderHistoryService() {
        dao = new OrderHistoryDao();
    }

    public List<Order> getOrders(int userId) {
        return dao.selectOrders(userId);
    }
}
