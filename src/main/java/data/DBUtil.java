package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String USERNAME = "root";
  private static final String PASSWORD = "sesame";
  //    private static final String URL = "jdbc:mysql://localhost/healthCare";
  private static final String URL = "jdbc:mysql://localhost/budget?serverTimezone=UTC&noAccessToProcedureBodies=true&useSSL=false";

  public static Connection getConnection() {
    Connection conn = null;
    try {
      Class.forName(DRIVER);
      conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException | ClassNotFoundException se) {
      se.printStackTrace();
    }
    return conn;
  }

  public static void processException(SQLException e) {
    System.err.println("Error message: " + e.getMessage());
    System.err.println("Error code: " + e.getErrorCode());
    System.err.println("SQL state: " + e.getSQLState());
  }

  public static void closeMe (AutoCloseable ac) {
    try {
      if (ac != null) ac.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
