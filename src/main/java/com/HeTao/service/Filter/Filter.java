package com.HeTao.service.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/*")
public class Filter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest servlet = (HttpServletRequest) servletRequest;

        //�ѵ�¼��ע�����Դ����
        String[] loginResource = {"/User/register", "/css/", "/images/", "index.html", "/User/login", "/User/checkCode", "/js/"};

        String requestURL = servlet.getRequestURL().toString();

        for (String e : loginResource)
            if (requestURL.contains(e)) {
                //�ҵ��� ����
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        //����δ��¼
        HttpSession session = servlet.getSession();
        Object user = session.getAttribute("user");
        if (user == null)
        {
            //δ��¼
            servletRequest.setAttribute("login_msg", "���¼��");
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }else {
            //�ҵ��� ����
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
