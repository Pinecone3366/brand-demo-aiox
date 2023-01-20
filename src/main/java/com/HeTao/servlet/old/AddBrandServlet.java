package com.HeTao.servlet.old;

import com.HeTao.pojo.Brand;
import com.HeTao.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addBrandServlet")
public class AddBrandServlet extends HttpServlet {
    private final BrandServiceImpl brandService = new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //��ȡBrand����
        BufferedReader reader = request.getReader();
        String readLine = reader.readLine();
        //תΪBrand
        Brand brand = JSON.parseObject(readLine, Brand.class);

        //����service���
        brandService.addBrand(brand);
        response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
