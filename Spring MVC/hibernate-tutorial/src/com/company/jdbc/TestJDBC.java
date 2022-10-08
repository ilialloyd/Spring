package com.company.jdbc;
/*
 *           Leave your comment below if you have
 --------------------------------------------------------
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        //we use useSSL to prevent warning
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";
        try{
            System.out.println("Connecting to database: "+jdbcUrl);

            Connection connection=
            DriverManager.getConnection(jdbcUrl,user,password);

            System.out.println("Connection successful");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
