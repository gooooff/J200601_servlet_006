package com.hqyj.emb.system.test;

import frame.dbuitl.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) {
        try {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
