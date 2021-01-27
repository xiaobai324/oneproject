package com.bh.oneproject.servlet;

import com.bh.oneproject.pojo.Customer;
import com.bh.oneproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:JL
 * @Date:2021/1/27
 */
@WebServlet(name="CustomerServlet",urlPatterns="/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Autowired
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /**
         * 1.封装对象
         * 2.添加id
         * 3.调用service
         * 4.成功信息
         * 5.跳转页面
         */
        String cname = req.getParameter("cname");
        String gender = req.getParameter("gender");
        String birthday = req.getParameter("birthday");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String cellphone = req.getParameter("cellphone");
        String email = req.getParameter("email");
        String description = req.getParameter("description");
        Date date = new Date();
        Customer crms = new Customer("3",cname,gender,date1,cellphone,email,description);
        int add = customerService.add(crms);
        ServletContext servletContext = this.getServletContext();

        if(1 == add){
            servletContext.setAttribute("msg","添加成功");
            resp.sendRedirect("msg.jsp");
            return;
        }else {
            servletContext.setAttribute("msg","添加失败");
        }
    }
}
