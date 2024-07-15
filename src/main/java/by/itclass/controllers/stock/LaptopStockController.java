package by.itclass.controllers.stock;

import by.itclass.controllers.AbstractController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.AbstractCollection;

import static by.itclass.constants.AppConst.LAPTOP_CONTROLLER;
import static by.itclass.constants.JspConst.LAPTOPS_ATTR;
import static by.itclass.constants.JspConst.LAPTOP_PAGE_JSP;

@WebServlet(LAPTOP_CONTROLLER)
public class LaptopStockController extends AbstractController {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var laptops = laptopService.getLaptops(req.getParameterMap());
        req.setAttribute(LAPTOPS_ATTR, laptops);
        forward(req, resp, LAPTOP_PAGE_JSP);
    }
}
