public class Main {

    public static void main(String[] args) {
        Board board = new Puzzle15Board();
        while (!board.isSolved()) {
            IO.printBoard(board);
            IO.printInstructions();
            boolean moved = board.moveTile(IO.readPlayerMove());
            if (!moved) {
                IO.printError();
            }
        }
        IO.printWinningMessage();
    }
}
