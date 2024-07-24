package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.ORDER_HISTORY_CONTROLLER;
import static by.itclass.constants.JspConst.*;

@WebServlet(ORDER_HISTORY_CONTROLLER)
public class OrderHistoryController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userId = ((User) req.getSession().getAttribute(USER_ATTR)).getId();
        var orders = orderHistoryService.getOrders(userId);
        req.setAttribute(ORDERS_ATTR, orders);
        forward(req, resp, ORDERS_JSP);
    }
}
