package BTECFinalAssessment1;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeExpense {
    public static void main(String[] args) {
        ArrayList<Expense> expenses = new ArrayList<>();  //ArrayList class is a resizable array
        ArrayList<Employee> employees = new ArrayList<>();

        int noOfCat =0;

        //Ask user for No of Category (min. 3)
        //Then get details of each expense category

        do {
            System.out.println("Please enter No. of Expense Category (min. 3): ");
            Scanner input = new Scanner(System.in);
            noOfCat = input.nextInt();
        } while (noOfCat < 3);


        for (int i = 0 ; i < noOfCat ; i++) {
            System.out.printf("Enter details of expense category %d\n", i+1);
            System.out.printf("Category - ");
            Scanner input = new Scanner(System.in);
            String cat = input.next();
            System.out.printf("Budget - ");
         //   input = new Scanner(System.in);
            double bud = input.nextDouble();

            expenses.add(new Expense(cat,bud));

        }

        for (Expense ex : expenses) {
            System.out.printf("%20s   budget:%10.2f\n", ex.getCategory(), ex.getBudgetAmount());
        }

        //Get employees details (min. 3) - Name, department, salary)
        //Get the expenses per category
        //Calculate saving of the employee

        do {
            System.out.printf("Please enter No. of Employees (min. 3): ");
            Scanner input = new Scanner(System.in);
            noOfCat = input.nextInt();
        } while (noOfCat < 3);


        for (int i = 0 ; i < noOfCat ; i++) {
            System.out.printf("Enter details of employee %d\n", i+1);
            System.out.printf("Name - ");
            Scanner input = new Scanner(System.in);
            String name = input.next();

            System.out.printf("Department - ");
            input = new Scanner(System.in);
            String dept = input.next();

            System.out.printf("Salary - ");
            input = new Scanner(System.in);
            double salary = input.nextDouble();


            //Create obj and add the list of employees
            employees.add(new Employee(name, dept));
            employees.get(employees.size()-1).setSalary(salary);
            employees.get(employees.size()-1).setExpenses(expenses);

            Employee thisEmp = employees.get(employees.size()-1);

            for (Expense ex: thisEmp.getExpenses()) {
                System.out.printf("Expense Amount for category %s - ", ex.getCategory());
                input = new Scanner(System.in);
                double catExpense = input.nextDouble();

                //to-do -the last entries override hte previous one.
                ex.setExpenseAmount(catExpense);
            }

        }

        for (Employee emp : employees) {
            double savings = emp.calculateSavings(expenses);
            System.out.printf("Savings = %.2f", savings);
            System.out.println("\n---------------------------------------------------------------------------");
        }


    }
}

