package com.HeTao.servlet;

import com.HeTao.pojo.User;
import com.HeTao.service.UserService;
import com.HeTao.service.impl.UserServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/User/*")
public class UserServlet extends BaseServlet{
    UserServiceImpl userService = new UserServiceImpl();

    /**
     * �����û����������¼�õ�ǰ�˵��û�����������з�װ
     */
    public boolean login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        /*BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        //��ȡ����
        User user = JSON.parseObject(readLine, User.class);*/

        User user = new User(username, password);

        //��ѯ����
        User select = userService.select(user);

        return select != null;
    }
}
