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
import java.util.List;

/**
 * @Author:JL
 * @Date:2021/1/27
 */
@WebServlet(name="CustomerQueryServlet",urlPatterns="/CustomerQueryServlet")
public class CustomerQueryServlet extends HttpServlet {
    //@Autowired
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List  list = customerService.query_();

        req.setAttribute("list", list);
        req.getRequestDispatcher("/PageServlet").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
