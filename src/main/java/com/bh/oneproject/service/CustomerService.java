package com.bh.oneproject.service;

import com.bh.oneproject.dao.CustomerDao;
import com.bh.oneproject.pojo.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


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
    //查询所有客户
    public List  query_(){
        List list = customerDao.queryCustomer();
        return list;
    }
    //根据id查询顾客
    public Customer queryID(String id){
        return customerDao.queryIdCustomer(id);
    }
    //修改用户
    public int editCustomer(Customer c){
        int rows = customerDao.editCustomer(c);
        return rows;
    }
    //删除一个用户
    //隐藏用户
    public int deleteCustomer(String id){
        int rows = customerDao.deleteCustomer(id);
        return rows;
    }
    //根据条件查询用户
    public List seniorQuery(Customer c){
        List list = customerDao.seniorQuery(c);
        return list;
    }
    //查询所有行数
    public Object getRows(){
       return customerDao.getAlleRows();
    }
    //设置行数
    public List getCustomerById(int pageNo){
        int pageSize = 10;
        return this.getCustomerByPage(pageNo, pageSize);
    }
    //设置每页显示的行数
    public List getCustomerByPage(int pageNo,int pageSize){
        return customerDao.queryPage(pageNo,pageSize);
    }
   /* //可以在页面调整每页显示的行数
    public List<CartoonType> getCartoonTypeByPage(int pageNo,int pageSize){
        CartoonTypeDAO ctDao = new CartoonTypeDAO();
        List<CartoonType> list = ctDao.query(pageNo, pageSize);
        return list;
    }

    //页面上没有设置每页显示的行数
    public List<CartoonType> getCartoonTypeById(int pageNo){
        int pageSize = 5;
        return this.getCartoonTypeByPage(pageNo, pageSize);
    }

   */
}
