package xin.oneplece.www.utils;

import java.sql.*;

/**
 * Created by zk on 2017/9/4.
 *
 */
public class JdbcUtils
{

    public static Connection getConnection()
    {
        Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/web_08", "root", "123456");
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }
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
