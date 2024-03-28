package FAssignment2;

import java.util.* ;

public class MTRBattleShips2 {
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

        do{
            Battle();
        }while(playerShips != 0 && computerShips != 0);

        gameOver();
    }

    public static void createMap(){
        System.out.print("   ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
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
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
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


            if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && (grid[x][y] == " ")) {
                grid[x][y] =   "@";
                i++;
            }
            else if((x >= 0 && x < numRows) && (y >= 0 && y < numCols) && grid[x][y] == "@")
                System.out.println("You can't place two or more ships on the same location");
            else if((x < 0 || x >= numRows) || (y < 0 || y >= numCols))
                System.out.println("You can't place ships outside the " + numRows + " by " + numCols + " grid");
        }
        printMap();
    }

    public static void deployComputerShips(){

        Random ram = new Random();
        System.out.println("\n Computer is deploying ships.\n");
        computerShips = 5;

        for(int i = 1; i<=computerShips;){
            int x = ram.nextInt(10);
            int y = ram.nextInt(10);

            if((x>=0 && x<numRows) && (y>=0 && y<numCols) && (grid[x][y] ==" ")){
                grid[x][y] = "C";
                System.out.println("Computer ship "+i+" deployed.");
                i++;
            }
        }
        printMap();
    }


    public static void Battle(){
        playerTurn();
        computerTurn();
        printMap();

        System.out.println();
        System.out.println("Your ships: " + playerShips + " | Computer ships: " +computerShips);
        System.out.println();
    }


    public static void playerTurn(){

        System.out.println("\n YOUR TURN");
        int x = -1 ; int y = -1;

        do{
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter X coordinate to guess opponent's ship : ");
            x = scn.nextInt();
            System.out.print("Enter Y coordinate to guess opponent's ship : ");
            y = scn.nextInt();

            if((x>=0 && x< numRows) && (y>=0 && y < numCols)){

                if(grid[x][y]=="C"){
                    System.out.println("You hit and destroyed one of your opponent's ships.");
                    grid[x][y] = "!";
                    --computerShips;
                }else if(grid[x][y] == "@"){
                    System.out.println("Unfortunately, you hit and destroyed one of your own ships.");
                    grid[x][y] = "X";
                    --playerShips;
                }else if (grid[x][y]==" "){
                    System.out.println("Sorry, You missed.");
                    grid[x][y] = "-";
                }

            }else if ((x<0 || x>=numRows) || (y<0 || y>=numCols)){
                System.out.println("You cannot shoot to the locations outside the "+numRows+" by "+numCols+" grid.");
            }
        }while((x<0 || x>=numRows) || (y<0 || y >=numCols));
    }

    public static void computerTurn(){
        Random ram = new Random();
        System.out.println("\n COMPUTER'S TURN ");
        int x = -1; int y = -1 ;

        do{
            x = ram.nextInt(10);
            y = ram.nextInt(10);

            if((x>=0 && x< numRows) && (y>=0 && y < numCols)){
                if(grid[x][y]=="@"){
                    System.out.println("Computer hit and destroyed one of your ships.");
                    grid[x][y] = "X";
                    --playerShips;
                }else if(grid[x][y] == "C"){
                    System.out.println(" Computer accidentally hit and destroyed one of its own ships.");
                    --computerShips;
                    grid[x][y] = "!";
                }else if (grid[x][y]==" "){
                    System.out.println("Computer missed.");

                if(missedGuesses[x][y] != 1)
                    missedGuesses[x][y] = 1;
                }
            }
        }while((x<0 || x>=numRows) || (y<0 || y >=numCols));

    }

    public static void gameOver(){
        System.out.println("Your ships: " + playerShips + " | Computer ships: " + computerShips);
        if(playerShips > 0 && computerShips <= 0)
            System.out.println(" \" You Won the Battle \" ");
        else
            System.out.println(" \" You Lost The Battle \" ");
        System.out.println();
    }

    public static void printMap(){
        System.out.println();
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();

        for(int x = 0; x < grid.length; x++) {
            System.out.print(x+ "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }
            System.out.println("|" + x);
        }
        System.out.print("  ");
        for(int i = 0; i < numCols; i++)
            System.out.print(i);
        System.out.println();
    }
}

