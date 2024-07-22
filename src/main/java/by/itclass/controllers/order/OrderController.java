package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.ORDER_CONTROLLER;
import static by.itclass.constants.JspConst.*;

@WebServlet(ORDER_CONTROLLER)
public class OrderController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var address = req.getParameter(ADDRESS_PARAM);
        var session = req.getSession();
        if (orderService.saveOrder(session, address)) {
            forward(req, resp, HOME_JSP);
        } else {
            forward(req, resp, CART_JSP, "Error while save Order");
        }
    }
}
