import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeExpense {

    public static void main(String[] args) {

        Employee employee = new Employee("", "");
        ValidateInput validateInput = new ValidateInput();

        ArrayList <Expense> expenseInfo = new ArrayList<>();
        ArrayList <Double> expenses = new ArrayList<>();
        ArrayList <Employee> employees = new ArrayList<>();

        int noOfCat = 0;
        int noOfEmp = 0;

        // Get number of expense categories from user
        System.out.println("****** Expense Tracking For Employees ******\n");
        do {
            System.out.print("Enter no. of expense category (min 2) : ");
            Scanner scan = new Scanner(System.in);
            noOfCat = validateInput.validateInteger(scan);
        }while(noOfCat < 2 );

        // Get details for each category
        for (int i = 1; i <= noOfCat; i++){
            System.out.print("Enter the name of \"category\" " + i + " : ");
            Scanner scan = new Scanner(System.in);
            String category = scan.next();

            System.out.print("Enter the \"budget\" : ");
            scan = new Scanner(System.in);
            double budget = validateInput.validateFloat(scan);

            expenseInfo.add(new Expense(category, budget));

        }

        // Show details of categories to user
        System.out.println("_____________________________________________________________");
        for (Expense exp : expenseInfo) {
            System.out.printf("%20s  \t\tBudget : %.2f\n",exp.getCategory(), exp.getBudget());
        }
        System.out.println("_____________________________________________________________");

        // Get number of employees from user
        do {
            System.out.print("\nEnter no. of employees (min 1) : ");
            Scanner scan = new Scanner(System.in);
            noOfEmp = validateInput.validateInteger(scan);
            if(noOfEmp < 1){
                System.out.println("You should have at least 1 employee.");
            }
        }while(noOfEmp < 1);

        // Get details of each employee
        for (int i = 1; i <= noOfEmp; i++){
            System.out.print("\nEnter the \"name\" of employee " + i + " : ");
            Scanner scan = new Scanner(System.in);
            String empName = scan.next();

            System.out.print("Enter his/her \"department\" : ");
            scan = new Scanner(System.in);
            String empDept = scan.next();

            System.out.print("Enter his/her \"salary\" : ");
            scan = new Scanner(System.in);
            double salary = validateInput.validateFloat(scan);

            employees.add(new Employee(empName, empDept));
            // get employee index from 'employees arraylist'
            int thisEmployee = employees.size() - 1 ;

            employees.get(thisEmployee).setEmpSalary(salary);

            for (Expense exp : expenseInfo) {
                System.out.print("Enter \"expense amount\" for category ("+exp.getCategory()+") : ");
                scan = new Scanner(System.in);
                double expAmount = validateInput.validateFloat(scan);

               expenses.add(expAmount);
            }
            // Store the expenses of employee as a new arraylist in his own arraylist index
            employees.get(thisEmployee).setExpenses(new ArrayList<>(expenses));
            // Reset the arraylist to empty, to accept another employee expenses
            expenses.clear();

        }

        // Calculate saving for each employee
        employee.calculateSaving (employees, expenseInfo);

    }
}
