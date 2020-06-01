package business;

import misc.MyUtil;

import java.io.Serializable;

public class Expense implements Serializable {
  private String name;
  private double amount;
  private String frequency;

  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public Expense(String expenseName, String freq, double yearlyAmount) {
    this.name = expenseName;
    this.amount = amount;
    this.frequency = freq;
  }

  public Expense() {
    this.name = "";
    this.amount = 0.0;
    this.frequency = "0";
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

  public static void main(String[] args) {
    Expense exp = new Expense("Benzin", "1-3", 1500.0);
    System.out.println(exp.getName());
  }
}
