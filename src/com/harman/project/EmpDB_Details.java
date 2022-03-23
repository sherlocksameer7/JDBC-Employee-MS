package com.harman.project;


import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Scanner;

public class EmpDB_Details
{

    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        int option;
        while (true)
        {
            System.out.println("Enter any Options to Perform an Operation: ");

            System.out.println("1. Add an Employee into this Database: ");
            System.out.println("2. View all Employee Details through the Database: ");

            System.out.println("3. Exit: ");

            option = inp.nextInt();

            switch (option)
            {



                case 1:

                    try
                    {
                        String emp_code, name, phone, email, designation, salary,  company_name, address;

                        System.out.println("Enter an Employee Code: ");
                        emp_code = inp.next();
                        System.out.println("Enter an Employee Name: ");
                        name = inp.next();
                        System.out.println("Enter an Employee Phone: ");
                        phone = inp.next();
                        System.out.println("Enter an Employee's Email ID: ");
                        email = inp.next();
                        System.out.println("Enter an Employee Designation: ");
                        designation = inp.next();
                        System.out.println("Enter an Employee Salary: ");
                        salary = inp.next();
                        System.out.println("Enter an Employee's Company Name: ");
                        company_name = inp.next();
                        System.out.println("Enter an Employee Address: ");
                        address = inp.next();

                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db?autoReconnect=true&useSSL=false", "root", "");

                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("INSERT INTO `employees`(`emp_code`, `name`, `phone`, `email`, `designation`, `salary`, `company_name`, `address`)" +
                                " VALUES("+emp_code+", '"+name+"', "+phone+", '"+email+"', '"+designation+"', "+salary+", '"+company_name+"', '"+address+"')");

                        System.out.println("Employee Details Added or Inserted Successfully !!! ");
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;



                case 2:

                    System.out.println("View all the Employee Details: ");

                    try
                    {
                        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db?autoReconnect=true&useSSL=false", "root", "");

                        Statement stmt = c.createStatement();
                        ResultSet rs = stmt.executeQuery("SELECT `id`, `emp_code`, `name`, `phone`, `email`, `designation`, `salary`, `company_name`, `address` FROM `employees` WHERE 1");

                        while (rs.next())
                        {
                            System.out.println("id=" +rs.getInt("id"));
                            System.out.println("emp_code=" +rs.getInt("emp_code"));
                            System.out.println("name=" +rs.getString("name"));
                            System.out.println("phone=" +rs.getBigDecimal("phone"));
                            System.out.println("email=" +rs.getString("email"));
                            System.out.println("designation=" +rs.getString("designation"));
                            System.out.println("salary=" +rs.getInt("salary"));
                            System.out.println("company_name=" +rs.getString("company_name"));
                            System.out.println("address=" +rs.getString("address"));
                        }


                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;


                case 3:

                    System.exit(0);



                default:

                    System.out.println("Invalid Choice *** Re-Enter the Choice Again !!!");
            }
        }
    }
}
