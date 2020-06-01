package business;

import misc.MyUtil;

import java.io.Serializable;
import java.text.NumberFormat;

public class Expense implements Serializable {
  private String name;
  private double amount;
  private String frequency;

  public Expense(String expenseName, String freq, double yearlyAmount) {
    this.name = expenseName;
    this.amount = yearlyAmount;
    this.frequency = freq;
  }

  public Expense() {
    this.name = "";
    this.amount = 0.0;
    this.frequency = "0";
  }

  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public double getMonthlySaving() {
    return this.getAmount() / 12;
  }

  public String getTotalSaving(int month) {
    double amount;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    int lastMonth = this.getLastPaymentMonth(month);
    int numberOfMonths;
    if (lastMonth <= month) {
      numberOfMonths = month - lastMonth;
    } else {
      numberOfMonths = month + (12 - lastMonth);
    }
    return currency.format(numberOfMonths * this.getMonthlySaving());
  }

  private int getLastPaymentMonth(int month) {
    //case 1: foregående betaling er samme år
    for (int i = month; i >= 1; i--) {
      if (this.isPaymentMonth(i)) {
        return i;
      }
    }
    //case 2: foregående betaling er året før
    for (int i = 12; i >= month+1; i--) {
      if (this.isPaymentMonth(i)) {
        return i;
      }
    }
    return 0;
  }

  private boolean isPaymentMonth(int month) {
    int[] months = this.getPaymentMonths();
    for (int value : months) {
      if (value == month) {
        return true;
      }
    }
    return false;
  }

  public int[] getPaymentMonths() {
    String[] months = this.getFrequency().split("-");
    return MyUtil.stringToIntegerArray(months);
  }

  public static void main(String[] args) {
    System.out.println("TEST");
    Expense e = new Expense("Benzin", "2-8", 3000.0);
    System.out.println(e.getTotalSaving(1));
  }
}

