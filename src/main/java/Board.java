/**
 * Game puzzle.Board Interface
 */
public interface Board {

    /**
     * Moves the selected tile to the empty space
     * @return true if move succeeded, false otherwise
     */
    boolean moveTile(Integer tile);


    /**
     * Is the game board solved and the game finished
     * @return true if the board is solved, false otherwise.
     */
    boolean isSolved();

}
