import java.util.Scanner;

public class IO {
    private static Scanner input = new Scanner(System.in);

    public static void printBoard(Board board) {
        System.out.println(board.toString());
    }

    public static Integer readPlayerMove() {
        return input.nextInt();
    }

    public static void printInstructions() {
        System.out.println("Enter tile number you want to move.");
    }

    public static void printWinningMessage() {
        System.out.println("Congratulations! You solved the puzzle.");
    }

    public static void printError() {
        System.out.println("Error accrued.");
    }
}
