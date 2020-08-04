package frame.dbuitl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
    private static Properties pp = new Properties();
    static {
        try {
            pp.load(JdbcUtils.class.getResourceAsStream("jdbc.properties"));
            Class.forName(pp.getProperty("driverClass"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(pp.getProperty("url"),pp.getProperty("name"),pp.getProperty("password"));
    }

    public static void main(String[] args) {

    }
}
