package com.bh.oneproject.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @Author:JL
 * @Date:2021/1/25
 */
public class JdbcUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    public static DataSource getDataSource(){
        return dataSource;
    }
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    public static String getId(){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }
}
