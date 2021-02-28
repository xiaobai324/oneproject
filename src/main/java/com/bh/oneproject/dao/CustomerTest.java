package com.bh.oneproject.dao;

import com.bh.oneproject.pojo.Customer;
import com.bh.oneproject.utils.JdbcUtils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:JL
 * @Date:2021/1/29
 */
public class CustomerTest {
    CustomerDao customerDao = new CustomerDao();
    @Test
    public void addC(){
        for (int i =20; i < 1005; i++) {
            Customer c = new Customer();
            c.setCid(JdbcUtils.getId());
            c.setCname("name"+i);
            c.setGender(i%2==0?"男":"女");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            //String t = sdf.format(2000-01-01);
                Date d = null;
            try {
                 d = sdf.parse("2000-01-01");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            c.setBirthday(d);
            c.setCellphone("178"+i);
            c.setEmail("324"+i);
            c.setDescription("11"+i);
            customerDao.addCustomer(c);
        }
    }
}
