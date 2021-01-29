package com.bh.oneproject.servlet;

import com.bh.oneproject.pojo.Customer;
import com.bh.oneproject.service.CustomerService;

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
 * @Date:2021/1/28
 */
@WebServlet(name="CustomerDeleteServlet",urlPatterns="/deleteServlet")
public class CustomerDeleteServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("cid");

        int row = customerService.deleteCustomer(id);

        if(1 == row){
            req.setAttribute("msg","删除成功");
        }else {
            req.setAttribute("msg","删除失败");
        }

        req.getRequestDispatcher("msg.jsp").forward(req,resp);

    }
}
