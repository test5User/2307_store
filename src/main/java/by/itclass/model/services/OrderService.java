package by.itclass.model.services;

import by.itclass.model.dao.OrderDao;
import by.itclass.model.entities.Receipt;
import jakarta.servlet.http.HttpSession;

public class OrderService implements Service {
    private OrderDao dao;

    public OrderService() {
        dao = new OrderDao();
    }

    public boolean saveOrder(HttpSession session, String address) {
        return dao.insertOrder(session, address);
    }

    public Receipt buildReceipt(String orderId) {
        return dao.buildReceipt(orderId);
    }
}
