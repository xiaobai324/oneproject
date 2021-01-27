package com.bh.oneproject.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;


import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author:JL
 * @Date:2021/1/25
 */
public class C3P0 {
    @Test
    public void fun1() throws SQLException, PropertyVetoException {

        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE");
        ds.setUser("root");
        ds.setPassword("123456");
        ds.setDriverClass("com.mysql.jc.jdbc.Driver");

        ds.setAcquireIncrement(5);
        ds.setInitialPoolSize(20);
        ds.setMinPoolSize(2);
        ds.setMaxPoolSize(50);
        Connection con = ds.getConnection();
        System.out.println(con);
        con.close();
    }
    @Test
    public void fun3() throws SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        Connection con = ds.getConnection();
        System.out.println(con);
        con.close();
    }
    @Test
    public void fun2() throws  SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource("oracle-config");
        Connection con = ds.getConnection();
        System.out.println(con);
        con.close();
    }
    @Test
    public void testUpdate(){
        QueryRunner qr = new QueryRunner();
        String sql = "insert into student values(?,?,?)";
        try {
            qr.update(JdbcUtils.getConnection(),sql,"4","赵四","444");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void QueryRunnerTest() {
        QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
        String sql = "insert into student values(?,?,?)";
        try {
            qr.update(sql, "5", "王五", "555");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //QueryRunner 还提供了批处理方法：batch()。
    //更新一行记录时需要指定一个 Object[]为参数，如果是批处理，那么就要指定 Object[][]为参数。
    @Test
    public void fun10() throws SQLException {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "insert into student values(?,?,?)";
        Object[][] params = new Object[10][];//表示 要插入10行记录
        for(int i = 0; i < params.length; i++) {
            params[i] = new Object[]{ i+6, "name" + i, "password" + i};
            }
            qr.batch(sql, params);
        }
}
