package Employee_Expense_Program;

public  class Expense {
    private String Category;
    private double budgetAmount;
    private double expenseAmount;

    //1.	Constructor with expense category and budget amount
    public Expense(String cat, double budget) {
        this.Category = cat;
        this.budgetAmount = budget;
    }

    //3.	Create the getters and setters for the instance variables
    public String getCategory() {return Category;}

    public void setCategory(String category) {
        Category = category;
    }

    public double getBudgetAmount() {
        return budgetAmount;
    }

    public void setBudgetAmount(double budgetAmount) {
        this.budgetAmount = budgetAmount;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

}