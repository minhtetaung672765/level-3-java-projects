import java.util.ArrayList;

public class Employee {

    String empName;
    String empDep;
    double empSalary;
    ArrayList <Double> expenses;

    // Constructor for employee
    public Employee(String empName, String empDep) {
        this.empName = empName;
        this.empDep = empDep;
    }
    public void calculateSaving (ArrayList <Employee> employees, ArrayList <Expense> expenseInfo) {

        System.out.println("\n| Expense Details of Each Employee :");
        for (Employee emp : employees) {
            System.out.println("______________________________________________________________________________");
            System.out.println("______________________________________________________________________________");
            System.out.printf("%-20s %-20s %-20s\n" , "(Name)", "(Department)", "(Salary)");
            System.out.printf("%-20s %-20s %-20s\n\n" ,emp.getEmpName(), emp.getEmpDep(), emp.getEmpSalary());

            int indexCount = 0;
            double totalExp = 0;
            String status = "";

            System.out.printf("%-20s %-20s %-20s %-20s\n", "(Category)", "(Budget)", "(Expense)", "(Status)");

            for (Expense ex : expenseInfo) {
                double expForThisCat = emp.getExpenses().get(indexCount);
                totalExp += expForThisCat;

                if (expForThisCat >= ex.getBudget()) {
                    status = "Above";
                }else{
                    status = "Below";
                }

                System.out.printf("%-20s %-20s %-20s %-20s\n"
                        ,ex.getCategory()
                        ,ex.getBudget()
                        ,expForThisCat
                        ,status);
                indexCount++;
            }
            double result = emp.getEmpSalary() - totalExp;
            System.out.println("-----------------------------------------------------------------------------");
            if ( result <= -1){
                System.out.printf("Saving = 0 %10s %20s %s\n\n", "|", "Extra Cost = ", result);
            }else{
                System.out.println("Saving = " + result + "\n");
            }

        }
    }

    // Getters and Setters
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public String getEmpDep() {
        return empDep;
    }
    public void setEmpDep(String empDep) {
        this.empDep = empDep;
    }
    public double getEmpSalary() {
        return empSalary;
    }
    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public ArrayList<Double> getExpenses() {
        return expenses;
    }

    public void setExpenses(ArrayList<Double> expenses) {
        this.expenses = expenses;
    }

}
