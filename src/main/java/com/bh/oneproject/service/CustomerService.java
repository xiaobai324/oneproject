package com.bh.oneproject.service;

import com.bh.oneproject.dao.CustomerDao;
import com.bh.oneproject.pojo.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @Author:JL
 * @Date:2021/1/27
 */
@Service
public class CustomerService {
    private CustomerDao customerDao = new CustomerDao();
    //添加客户
    public int add(Customer c){
        int rows = customerDao.addCustomer(c);
        return rows;
    }
    //查询客户
    public List  query(){
        List list = customerDao.queryCustomer();
        return list;
    }
}
