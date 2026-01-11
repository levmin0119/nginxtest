package com.levmin.nginxtest.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {
    public static void main(String[] args) throws Exception {
        String url =
                "jdbc:mysql://192.168.1.176:3306/levmin"
                        + "?useSSL=false"
                        + "&serverTimezone=Asia/Shanghai"
                        + "&allowPublicKeyRetrieval=true";

        Connection conn = DriverManager.getConnection(
                url, "root", "Zy5201ljf&"
        );

        System.out.println("连接成功：" + conn);
    }
}

