package DBTest;

import java.sql.*;

public class DataBaseTest {
    public static void main(String[] args) {
        /* to build the connection with the database
    we need 3 things, URL, username, password
     */
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";
        try {
            Connection conn=DriverManager.getConnection(url,username,password);
            System.out.println("Connection is created for batch 15");
            //create statement to send url
            Statement statement=conn.createStatement();

            //when they send any quary to the database then database returns
            //result set(table with rows and columns)
           ResultSet rset= statement.executeQuery("Select firstname,lastname from person");
            rset.next();
            String fname=rset.getString("Firstname");
            String lname=rset.getString("LastName");
            System.out.println(fname+" "+lname);


        } catch (SQLException e) {
           e.printStackTrace();
        }

    }
}
