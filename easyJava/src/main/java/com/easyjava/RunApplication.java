package com.easyjava;

import com.easyjava.builder.BuildTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RunApplication {
    public static void main(String[] args) {
        BuildTable.getTables();
//        String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
//        String user = "root";
//        String password = "你的新密码"; // ← 这里换成真实密码
//
//        try (Connection c = DriverManager.getConnection(url, user, password)) {
//            System.out.println("ok");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
