package com.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeePayroll {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/payroll?useSSL=false";
        String username = "root";
        String password = "123456789";
        Connection con;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded!");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("cannot find the driver in the classpath!", e);
        }
        try {
            System.out.println("connecting to database:" + jdbcURL);
            con = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("connection done successful!!" + con);
            Statement statement=con.createStatement();
            statement.execute("alter table employee add column tax varchar(30)");
//            statement.executeUpdate("update employee set name='Terissa',\n" +
//                    "department='sales-marketing' where id=2;");
            ResultSet resultSet =statement.executeQuery("select * from employee");
            while(resultSet.next()){
                System.out.println("id:"+resultSet.getInt("id"));
                System.out.println("name:"+resultSet.getString("name"));
                System.out.println("salary:"+resultSet.getDouble("salary"));
                System.out.println("department:"+resultSet.getString("department"));
                System.out.println("Joining_Date:"+resultSet.getDate("Joining_Date"));
                System.out.println("Gender:"+resultSet.getString("Gender"));
                System.out.println("Phone:"+resultSet.getString("phone"));
                System.out.println("Address:"+resultSet.getString("address"));
                System.out.println("Tax:"+resultSet.getString("tax"));
            }
        } catch (Exception e) {
            //  e.printStackTrace();
        }
    }
}





