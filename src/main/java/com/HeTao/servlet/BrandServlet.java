package com.HeTao.servlet;

import com.HeTao.pojo.Brand;
import com.HeTao.pojo.PageBean;
import com.HeTao.service.impl.BrandServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet{
    private final BrandServiceImpl brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        List<Brand> brands = brandService.SelectAll();

        //2.������תΪJSON
        String jsonString = JSON.toJSONString(brands);
        //3.д����,ת��
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        //��ȡBrand����
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        //תΪBrand
        Brand brand = JSON.parseObject(readLine, Brand.class);

        //����service���
        brandService.addBrand(brand);
        resp.getWriter().write("success");
    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        //��ȡBrand����
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        //תΪ����
        int[] ints = JSON.parseObject(readLine, int[].class);
        brandService.deleteById(ints);
        resp.getWriter().write("success");
    }
    //��ҳ��ѯ
    public void selectByPage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //��ȡ����
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);


        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);

        String jsonString = JSON.toJSONString(pageBean);

        //3.д����,ת��
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    //��ҳ������ѯ
    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //��ȡ����
        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);
        //��ȡ��ѯ��������
        //��ȡBrand����
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        //תΪBrand
        Brand brand = JSON.parseObject(readLine, Brand.class);

        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage, pageSize, brand);

        String jsonString = JSON.toJSONString(pageBean);

        //3.д����,ת��
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);
    }
    public void selectById(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        //��ȡBrand����
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        //תΪ����
        Integer integer = JSON.parseObject(readLine, int.class);
        Brand brand = brandService.selectById(integer);

        //����brand
        //3.д����,ת��
        resp.setContentType("text/json;charset=utf-8");
        String jsonString = JSON.toJSONString(brand);
        resp.getWriter().write(jsonString);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        //��ȡBrand����
        BufferedReader reader = req.getReader();
        String readLine = reader.readLine();
        //תΪBrand
        Brand brand = JSON.parseObject(readLine, Brand.class);
        brandService.update(brand);
        resp.getWriter().write("success");
    }
}
