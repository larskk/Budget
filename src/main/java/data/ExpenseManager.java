package data;
import business.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;;

public class ExpenseManager {
  public static boolean createExpense(Expense e) {

    String sql = "Insert into expense (expenseName, frequency, amount) values (?,?,?)";
    System.out.println(e.getName());
    System.out.println(e.getFrequency());
    System.out.println(e.getAmount());
    try {
      Connection conn = DBUtil.getConnection();
      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setString(1, e.getName());
      ps.setString(2, e.getFrequency());
      ps.setDouble(3, e.getAmount());
      ps.executeUpdate();
      return true;
    } catch (SQLException ex) {
      DBUtil.processException(ex);
      return false;
    }
  }

  public static List<Expense> getExpenses() {
    String sql = "SELECT * FROM expense";
    List<Expense> expenses = new ArrayList();
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement ps = null;
    try {
      conn = DBUtil.getConnection();
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        String expenseName = rs.getString("expenseName");
        String frequency = rs.getString("frequency");
        double amount = rs.getDouble("amount");
        Expense expense = new Expense(expenseName, frequency, amount);
        expenses.add(expense);
      }

    } catch (SQLException ex) {
      ex.printStackTrace();
    } finally {
      DBUtil.closeMe(rs);
      DBUtil.closeMe(ps);
      DBUtil.closeMe(conn);
    }
    return expenses;
  }
}
