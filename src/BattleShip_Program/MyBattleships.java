package BattleShip_Program;

import java.util.Random;
import java.util.Scanner;

public class MyBattleships {

    public static int rows = 10;
    public static int columns = 10;
    public static int playerShips;
    public static int computerShips;
    public static String[][] grid = new String[rows][columns];
    public static int[][] missedGuesses = new int[rows][columns];

    public static void main(String[] args) {
        System.out.println("~~~~  Welcome to Battle Ships game ~~~~ ");
        System.out.println("        Right now, sea is empty\n");

        createGameBoard();
        deployPlayerShips();
        deployComputerShips();
        startBattle();
        gameResult();

    }
    public static void createGameBoard() {
        System.out.print("   ");
        for (int i = 0; i < columns; i++)
            System.out.print(i+"  ");
        System.out.println();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = "   ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int i = 0; i < columns; i++)
            System.out.print(i+"  ");
        System.out.println();
    }

    public static void deployPlayerShips() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nDeploy your ships : ");

        playerShips = 5;
        for (int i = 1; i <= playerShips;) {
            System.out.print("Enter X coordinate for your " + i + " ship: ");
            int x = input.nextInt();
            System.out.print("Enter Y coordinate for your " + i + " ship: ");
            int y = input.nextInt();

            if ((x >= 0 && x < rows) && (y >= 0 && y < columns) && (grid[x][y] == "   ")) {
                grid[x][y] = " @ ";
                i++;
            } else if ((x >= 0 && x < rows) && (y >= 0 && y < columns) && grid[x][y] == " @ ")
                System.out.println("You can't place two or more ships on the same location");
            else if ((x < 0 || x >= rows) || (y < 0 || y >= columns))
                System.out.println("You can't place ships outside the " + rows + " by " + columns + " grid");
        }
        printOceanMap();
    }

    public static void deployComputerShips() {
        System.out.println("\nComputer is deploying ships\n");
        computerShips = 5;
        for (int i = 1; i <= computerShips;) {
           Random ram = new Random();
           int x = ram.nextInt(10);
           int y = ram.nextInt(10);

            if ((x >= 0 && x < rows) && (y >= 0 && y < columns) && (grid[x][y] == "   ")) {
                grid[x][y] = " C ";
                System.out.println("Computer ship "+i+" deployed.");
                i++;
            }
        }
        printOceanMap();
    }

    public static void Battle() {
        playerTurn();
        computerTurn();
        printOceanMap();

        System.out.println();
        System.out.println("Your ships left : " + playerShips + " | Computer's ships left : " + computerShips);
        System.out.println();
    }
    public static void startBattle(){
        System.out.println();
        System.out.println("All set now, let's destroy all the enemy's ships.");
        System.out.println(" Are you ready? Type 'yes' if you are ready : ");
        Scanner confirmInput = new Scanner(System.in);
        String confirm = confirmInput.next();

        if ((confirm.equals("yes")) || confirm.equals("YES") || confirm.equals("Yes")) {
            do {
                Battle();
            } while (playerShips != 0 && computerShips != 0);
        }
    }

    public static void playerTurn() {
        System.out.println("\nYOUR TURN");
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate to guess your opponent's ship : ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate to guess your opponent's ship : ");
            y = input.nextInt();

            if ((x >= 0 && x < rows) && (y >= 0 && y < columns))
            {
                if (grid[x][y] == " C ") {
                    System.out.println("You hit and destroyed one of your opponent's ships.");
                    grid[x][y] = " ! ";
                    --computerShips;
                } else if (grid[x][y] == " @ ") {
                    System.out.println("Unfortunately, you hit and destroyed one of your own ships.");
                    grid[x][y] = " x ";
                    --playerShips;
                } else if (grid[x][y] == "   ") {
                    System.out.println("Sorry, you missed");
                    grid[x][y] = " - ";
                }
            } else if ((x < 0 || x >= rows) || (y < 0 || y >= columns))
                System.out.println("You cannot shoot to the locations outside the " + rows + " by " + columns + " grid.");


        } while ((x < 0 || x >= rows) || (y < 0 || y >= columns));
    }

    public static void computerTurn() {
        Random ram = new Random();
        System.out.println("\nCOMPUTER'S TURN");
        int x = -1, y = -1;
        do {
            x = ram.nextInt(10);
            y = ram.nextInt(10);

            if ((x >= 0 && x < rows) && (y >= 0 && y < columns)) {
                if (grid[x][y] == " @ ") {
                    System.out.println("Computer hit and destroyed one of your ships.");
                    grid[x][y] = " x ";
                    --playerShips;
                } else if (grid[x][y] == " C ") {
                    System.out.println(" Computer accidentally hit and destroyed one of its own ships.");
                    --computerShips;
                    grid[x][y] = " ! ";
                } else if (grid[x][y] == "   ") {
                    System.out.println("Computer missed");
                    grid[x][y] = " - ";

                    if (missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1;
                }
            }
        } while ((x < 0 || x >= rows) || (y < 0 || y >= columns));
    }

    public static void gameResult() {
        System.out.println("Your ships left : " + playerShips + " | Computer's ships left : " + computerShips);
        if (playerShips > 0 && computerShips <= 0)
            System.out.println(" \" You Won the Battle \" ");
        else
            System.out.println(" \" You Lost The Battle \" ");
        System.out.println();

    }
    public static void printOceanMap() {
        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < columns; i++)
            System.out.print(i+"  ");
        System.out.println();

        for (int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");
            for (int y = 0; y < grid[x].length; y++) {
                System.out.print(grid[x][y]);
            }
            System.out.println("|" + x);
        }

        System.out.print("   ");
        for (int i = 0; i < columns; i++)
            System.out.print(i+"  ");
        System.out.println();
    }

}