package FAssignment2;


import java.util.Scanner;

public class MTRBattleship {
    public static int numRows = 10;
    public static int numCols = 10;
    public static int playerShips;
    public static int computerShips;
    public static String[][] grid = new String[numRows][numCols];
    public static int[][] missedGuesses = new int[numRows][numCols];

    public static void main(String[] args){
        System.out.println("~~~~ Welcome to Battle Ships ~~~~");
        System.out.println("Right now, map is empty\n");

        createMap();

        deployPlayerShips();

        deployComputerShips();

        do {
            Battle();
        }while(playerShips != 0 && computerShips != 0);

        gameOver();
    }

    public static void createMap(){
        System.out.print("   ");
        for(int i = 1; i <= numCols; i++)
            System.out.print(i+"  " );
        System.out.println();

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = "   ";
                if (j == 0)
                    System.out.print((i+1) + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + (i+1));
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        System.out.print("   ");
        for(int i = 1; i <= numCols; i++)
            System.out.print(i+"  ");
        System.out.println();
    }

    public static void deployPlayerShips(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeploy your ships:");

        playerShips = 5;
        for (int i = 1; i <= playerShips; ) {
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " ship: ");
            int y = input.nextInt();

            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == "   "))
            {
                grid[x][y] =   "@  ";
                i++;
            }
            else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@  ")
                System.out.println("You can't place two or more ships on the same location");
            else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }
        printMap();
    }

    public static void deployComputerShips(){
        //you need to develop code
    }

    public static void Battle(){
        playerTurn();
        computerTurn();

        printMap();

        System.out.println();
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        System.out.println();
    }

    public static void playerTurn(){
        //you need to develop code
    }

    public static void computerTurn(){
        //you need to develop code
    }

    public static void gameOver(){
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        if(playerShips > 0 && computerShips <= 0)
            System.out.println("Hooray! You won the battle :)");
        else
            System.out.println("Sorry, you lost the battle");
        System.out.println();
    }

    public static void printMap(){
        System.out.println();
        System.out.print("  ");
        for(int i = 1; i <= numCols; i++)
            System.out.print(i+"  ");
        System.out.println();

        for(int x = 0; x < grid.length; x++) {
            System.out.print((x+1) + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x] [y]);
            }

            System.out.println("|" + (x+1));
        }

        System.out.print("  ");
        for(int i = 1; i <= numCols; i++)
            System.out.print(i+"  ");
        System.out.println();
    }
}