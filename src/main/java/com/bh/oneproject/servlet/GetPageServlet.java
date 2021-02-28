package com.bh.oneproject.servlet;


import com.bh.oneproject.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author:JL
 * @Date:2021/1/29
 */
@WebServlet(name = "GetPageServlet",urlPatterns="/PageServlet")
public class GetPageServlet extends HttpServlet {
    CustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strpageNo = req.getParameter("pageNo");
        int pageNo = 1;
        if(strpageNo != null){
            pageNo = Integer.parseInt(strpageNo);
        }
        List list = customerService.getCustomerById(pageNo);
        int num = 0;
        //总页数
         long l = (long)customerService.getRows();
        int rows= (int) l;
        if(rows % 10 == 0){
            num = rows / 10;
        }else{
            num = rows / 10 +1;
        }
        //3.进行跳转
        req.setAttribute("pageNo", pageNo);
        req.setAttribute("list", list);
        req.setAttribute("pageCount", num);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
