package xin.oneplece.www.Web_08;

import com.mysql.jdbc.Connection;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by zk on 2017/9/4.
 */

/*
JDBC步骤：
1  注册驱动
2  获取连接
3  获取statement
4  书写查询语句
5  遍历结果集
6  关闭资源
 */
public class JDBCtest01
{


    public static Connection getConnection() throws ClassNotFoundException, SQLException
    {
//      注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/web_08";
//      获取连接
        java.sql.Connection connection = DriverManager.getConnection(url, "root", "123456");
        return (Connection) connection;
    }

    @Test
    public void query()
    {
        Connection connection = null;
        Statement statement = null;
        ResultSet result = null;
        try
        {
            connection = getConnection();
//      获取statement
            statement = connection.createStatement();
//      获取查询语句
            String sql = "select * from user";
            result = statement.executeQuery(sql);
//      遍历结果集
            while (result.next())
            {
                int uid = result.getInt(1);
                String useName = result.getString(2);
                String password = result.getString(3);
                System.out.println(uid + "  "+ useName + " : " + password);
            }

        }
        catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
//        无论如何都要在获取结果以后关闭 connection statement result 而且关闭的顺序是后获得先关闭
        finally
        {
             try
            {
                if (result != null) result.close();
                if (statement != null) statement.close();
                if (connection != null)connection.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}