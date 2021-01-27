package com.bh.oneproject.dao;

import com.bh.oneproject.pojo.Customer;
import com.bh.oneproject.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


/**
 * @Author:JL
 * @Date:2021/1/27
 */
public class CustomerDao {
    /**
     * sql
     * 参数
     */
    private QueryRunner qr = new QueryRunner();
    //添加一个顾客
    public int addCustomer(Customer c){
        //获取数据源
        DataSource ds = JdbcUtils.getDataSource();
        //生成QueryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        String sql = "insert into tb_customer values (?,?,?,?,?,?,?)";
        Object[] objects = {c.getCid(),c.getCname(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getDescription()};
        int rows = 0;
        try {
            rows = qr.update(sql,objects);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }
    //查询所有顾客
    public List queryCustomer(){
        List<Customer> list = null;
        //获取数据源
        DataSource ds = JdbcUtils.getDataSource();
        //生成QueryRunner对象
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from tb_customer";
        try {
            list = qr.query(sql, new BeanListHandler<>(Customer.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
        return list;
    }
}
