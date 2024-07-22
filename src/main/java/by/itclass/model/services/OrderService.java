package by.itclass.model.services;

import by.itclass.model.dao.OrderDao;
import jakarta.servlet.http.HttpSession;

public class OrderService {
    private static OrderService service;
    private OrderDao dao;

    private OrderService() {
        dao = OrderDao.getInstance();
    }

    public static OrderService getInstance() {
        return service == null ? new OrderService() : service;
    }

    public boolean saveOrder(HttpSession session, String address) {
        return dao.insertOrder(session, address);
    }
}
