package com.wyett.mysql.simplejdbc;

import java.sql.*;

import static java.lang.Class.forName;

/**
 * @author : wyettLei
 * @date : Created in 2019/11/1 16:06
 * @description: TODO
 */

public class SimpleJdbc {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // load driver
            Class.forName("com.mysql.jdbc.Driver");

            // get Connection
            String url = "jdbc:mysql://192.168.56.101:3306/wyett";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);

            // get preparedStatement
            String sql = "select * from tb_user where id=?";
            preparedStatement = connection.prepareStatement(sql);

            // set param
            preparedStatement.setLong(1, 1l);

            // get resultSet
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                System.out.println(resultSet.getString("user_name"));
                System.out.println(resultSet.getInt("age"));
                System.out.println(resultSet.getDate("birthday"));
                System.out.println(resultSet.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if(resultSet == null) {
                resultSet.close();
            }
            if(preparedStatement == null) {
                preparedStatement.close();
            }
            if(connection == null) {
                connection.close();
            }
        }
    }
}
