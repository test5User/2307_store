package by.itclass.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

import static by.itclass.constants.AppConst.*;
import static by.itclass.constants.JspConst.*;

@WebFilter(REGISTRATION_CONTROLLER)
public class EmailFilter implements Filter {
    public static final String EMAIL_PATTERN = "\\w+@\\w+\\.\\w+";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var email = servletRequest.getParameter(EMAIL_PARAM);
        if (!email.matches(EMAIL_PATTERN)) {
            servletRequest.setAttribute("message", "Wrong email");
            servletRequest.getRequestDispatcher(REGISTRATION_JSP).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
     }
}
