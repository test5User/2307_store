package by.itclass.controllers.abstraction;

import by.itclass.model.services.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.JspConst.MESSAGE_ATTR;

public abstract class AbstractController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void forward(HttpServletRequest req, HttpServletResponse resp,
                        String url) throws ServletException, IOException {
        req.getRequestDispatcher(url).forward(req, resp);
    }

    public void forward(HttpServletRequest req, HttpServletResponse resp,
                        String url, String message) throws ServletException, IOException {
        req.setAttribute(MESSAGE_ATTR, message);
        forward(req, resp, url);
    }

    public void redirect(HttpServletResponse resp, String url) throws IOException {
        resp.sendRedirect(getServletContext().getContextPath() + url);
    }
}
