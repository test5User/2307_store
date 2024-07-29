package by.itclass.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.itclass.constants.AppConst.*;
import static by.itclass.constants.JspConst.*;

@WebFilter({TV_CONTROLLER, LAPTOP_CONTROLLER, ORDER_CONTROLLER, HOME_JSP, CART_JSP})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var session = ((HttpServletRequest) servletRequest).getSession();
        var user = session.getAttribute(USER_ATTR);
        if (user == null) {
            var resp = (HttpServletResponse) servletResponse;
            resp.sendRedirect(LOGIN_JSP);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
