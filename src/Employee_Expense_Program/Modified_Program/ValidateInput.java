import java.util.Scanner;

public class ValidateInput {

    public int validateInteger(Scanner scan) {
        int input = 0;
        do {
            try {
                input = scan.nextInt();
                return input;
            } catch (Exception e) {
                System.out.print("Please enter Integers only : ");
                scan.next(); // clear the input buffer
            }
        }while (input == 0);  // keep the loop until return by "try"
        return input;
    }

    public double validateFloat(Scanner scan) {
        double input = 0;
        do {
            try {
                input = scan.nextDouble();
                return input;
            } catch (Exception e) {
                System.out.print("Please enter Integers only : ");
                scan.next();
            }
        }while (input == 0);
        return input;
    }

}
