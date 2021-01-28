package com.bh.oneproject.servlet;

import com.bh.oneproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:JL
 * @Date:2021/1/28
 */
@WebServlet(name="CustomerQueryIdServlet",urlPatterns="/load")
public class CustomerQueryIdServlet extends HttpServlet {
    //@Autowired
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 获取id
         * 根据cid获取数据
         * 保存信息到
         * 转发信息到edit
         */
        String id = req.getParameter("cid");

        req.setAttribute("crm", customerService.queryID(id));
        req.getRequestDispatcher("edit.jsp").forward(req, resp);
    }
}
