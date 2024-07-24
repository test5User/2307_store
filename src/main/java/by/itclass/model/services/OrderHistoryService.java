package by.itclass.model.services;

import by.itclass.model.dao.OrderHistoryDao;
import by.itclass.model.entities.Order;

import java.util.List;
import java.util.Objects;

public class OrderHistoryService {
    private static OrderHistoryService service;
    private OrderHistoryDao dao;

    public OrderHistoryService() {
        dao = OrderHistoryDao.getInstance();
    }

    public static OrderHistoryService getInstance() {
        return Objects.isNull(service) ? new OrderHistoryService() : service;
    }

    public List<Order> getOrders(int userId) {
        return dao.selectOrders(userId);
    }
}
