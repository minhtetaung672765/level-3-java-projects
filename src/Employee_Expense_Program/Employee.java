package BTECFinalAssessment1;

import java.util.ArrayList;

public  class Employee implements IExpense {
    String employeeName;
    String department;
    double salary;
    ArrayList<Expense> expenses;
    //Java ArrayList class uses a dynamic array for storing the elements.
    // It is like an array, but there is no size limit.
    //We can add or remove elements anytime.
    //It is found in the java.util package.
    //Java ArrayList class can contain duplicate elements.
   //Java ArrayList class maintains insertion order.
   // Java ArrayList allows random access because the array works on an index basis.

    //Constructor with name and dept
    public Employee(String name, String dept){
        this.employeeName = name;
        this.department = dept;
    }

    @Override
    // Calculate the expense and saving
    public double calculateSavings(ArrayList<Expense> expenses) {
        //iterate through each category
        //compare actual employee expense against budget
        //flag "Above budget" if actual > budget, else "Below budget"
        //keep a count of each Above and Below
        //Calc the sum of all expenses
        //Cals Saving - Salary-sum

        String result = "Below";
        int countAbove = 0;
        double sumOfExpenses = 0;
        System.out.printf("%s\t%30s\t%20s\n", this.getEmployeeName(),
                this.getDepartment(),
                this.getSalary());

        for (Expense expCat : expenses) {
            sumOfExpenses += expCat.getExpenseAmount();
            if (expCat.getExpenseAmount() > expCat.getBudgetAmount()) {
                result = "Above";
                countAbove++;
            }
            System.out.printf("\t%s\t%20.2f\t%20.2f\t%20s\n", expCat.getCategory(),
                    expCat.getBudgetAmount(),
                    expCat.getExpenseAmount(),
                    result);
        }
        return this.salary - sumOfExpenses;
    }


    //getter and setter

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        this.expenses = expenses;
    }
}
