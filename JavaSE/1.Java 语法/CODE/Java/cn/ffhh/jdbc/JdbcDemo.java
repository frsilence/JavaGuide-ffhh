package cn.ffhh.jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @auther FrSilence
 * @date 2019-09-24 16:07
 */
public class JdbcDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        JdbcDemo jdbcDemo = new JdbcDemo();
        jdbcDemo.test();
    }
    public void test() throws ClassNotFoundException, IOException, SQLException {
        Properties jdbcInfo = new Properties();
        //System.err.println(this.getClass().getClassLoader().getResource("cn\\ffhh\\jdbc\\data.properties"));
        jdbcInfo.load(this.getClass().getClassLoader().getResourceAsStream("cn\\ffhh\\jdbc\\data.properties"));
        System.out.println(jdbcInfo.getProperty("jdbc.url"));
        Class.forName(jdbcInfo.getProperty("jdbc.driver"));
        Connection connection = DriverManager.getConnection(jdbcInfo.getProperty("jdbc.url"),jdbcInfo.getProperty("jdbc.username"),jdbcInfo.getProperty("jdbc.password"));
        //Statement
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        while(resultSet.next()){
            System.out.println("name:"+resultSet.getString(1));
            System.out.println("id:"+resultSet.getInt(2));
            System.out.println("birthday:"+resultSet.getTimestamp(3));
        }

        System.out.println("prepareStatment--------------------");

        //prepareStatement
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
        preparedStatement.setInt(1,1);
        ResultSet resultSet1 = preparedStatement.executeQuery();
        while(resultSet1.next()){
            System.out.println("name:"+resultSet1.getString(1));
            System.out.println("id:"+resultSet1.getInt(2));
            System.out.println("birthday:"+resultSet1.getTimestamp(3));
        }
    }
}
