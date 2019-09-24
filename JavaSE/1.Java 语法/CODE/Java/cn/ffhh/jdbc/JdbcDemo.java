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
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from user");
        if(resultSet.next()){
            String name = resultSet.getString(1);
            System.out.println(name);
        }
    }
}
