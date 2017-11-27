package com.zp.excel.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Author:zp
 * Date:2017/11/23 0023
 * Description:
 */
public class C3P0PoolTest {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();
        Connection connection = dataSource.getConnection();
        if (!connection.isClosed()) {
            System.out.println("connected!");
        }
    }
}
