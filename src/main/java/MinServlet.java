import business.Expense;
import data.ExpenseManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static data.ExpenseManager.createExpense;

@WebServlet("/MinServlet")
public class MinServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    HttpSession s = request.getSession();
    String url = "/showExpenses.jsp";
    String[] months = {"januar", "februar", "marts", "april", "maj", "juni", "juli", "august", "september", "oktober", "november", "december"};
    s.setAttribute("months", months);


    // get current action
    String action = request.getParameter("action");
    if (action == null) {
      url = "/showExpenses.jsp";  // default action
    } else {
      switch (action) {
        case "showExpenses":
          url = "/showExpenses.jsp";
        case "create":
          url = create(request, response);
      }
    }
    List<Expense> expenses = ExpenseManager.getExpenses();
    s.setAttribute("expenses", expenses);
    request.getRequestDispatcher(url).forward(request, response);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    doPost(request,response);
  }

  private String create(HttpServletRequest request, HttpServletResponse response) {
    String frequency = "";
    String expenseName = request.getParameter("name");
    String[] months = request.getParameterValues("month");
    if (months != null) {
      frequency = String.join("-", months);
    } else {frequency = "0";}
    double amount = Double.parseDouble(request.getParameter("amount"));
    Expense expense = new Expense(expenseName, frequency, amount);
    expense.setName(expenseName);
    expense.setFrequency(frequency);
    expense.setAmount(amount);
    System.out.println(expense.getName());
    createExpense(expense);
    return "showExpenses.jsp";
  }
}
