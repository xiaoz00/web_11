package xin.oneplece.www.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Created by zk on 2017/9/4.
 */
public class JdbcUtils2
{

    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
    static
    {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("jdbc.driver");
        String url = resourceBundle.getString("jdbc.url");
        String user = resourceBundle.getString("jdbc.user");
        String password = resourceBundle.getString("jdbc.password");
    }
    public static Connection getConection() throws ClassNotFoundException, SQLException
    {
        Connection connection;
        Class.forName(driver);
        connection = DriverManager.getConnection(url,user,password);
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
