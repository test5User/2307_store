package by.itclass.controllers.order;

import by.itclass.controllers.AbstractController;
import by.itclass.model.entities.OrderItem;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.*;
import static by.itclass.constants.JspConst.*;

@WebServlet(CART_CONTROLLER)
public class CartController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var cartAction = req.getParameter(CART_ACTION_PARAM);
        var itemType = Integer.parseInt(req.getParameter(ITEM_TYPE_PARAM));
        var itemId = Integer.parseInt(req.getParameter(ITEM_ID_PARAM));
        var itemVendor = req.getParameter(ITEM_VENDOR_PARAM);
        var itemModel = req.getParameter(ITEM_MODEL_PARAM);
        var itemPrice = Double.parseDouble(req.getParameter(ITEM_PRICE_PARAM));
        var quantity = Integer.parseInt(req.getParameter(QUANTITY_PARAM));
        var item = new OrderItem(itemType, itemId, itemVendor, itemModel, itemPrice, quantity);
        var session = req.getSession();
        var items = cartService.processCart(session, cartAction, item);
        session.setAttribute(ORDER_ITEMS_ATTR, items);
        if ("add".equals(cartAction)) {
            redirectToProductPage(resp, itemType);
        } else {
            redirect(resp, CART_JSP);
        }
    }

    private void redirectToProductPage(HttpServletResponse resp, int itemType) throws IOException {
        switch (itemType) {
            case 1 -> redirect(resp, TV_CONTROLLER);
            case 2 -> redirect(resp, LAPTOP_CONTROLLER);
        }
    }
}
