package xin.oneplece.www.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by zk on 2017/9/4.
 */
public class JdbcUtils3
{
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static
    {
        try
        {

//        获取当前类的加载器
            ClassLoader classLoader = JdbcUtils3.class.getClassLoader();
//        通过类的方法来加载一个输入流
            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc");
//        新建一个properties对象
            Properties properties = new Properties();
//        通过输入流来加载properties对象
            properties.load(resourceAsStream);
//        获取值
            String driver = properties.getProperty("jdbc.driver");
            String url = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.user");
            String password = properties.getProperty("jdbc.password");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
    public Connection getConnection() throws ClassNotFoundException, SQLException
    {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void release(Connection connection, Statement statement , ResultSet resultSet)
    {
        try
        {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
