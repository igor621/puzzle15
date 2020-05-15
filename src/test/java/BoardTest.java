import org.junit.jupiter.api.Test;

import static helpers.Constants.EMPTY_VALUE;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    @Test
    public void testIsSolved() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, EMPTY_VALUE, 15};
        Board board = new Puzzle15Board(tiles);
        assertTrue(board.moveTile(15));
        assertTrue(board.isSolved());
    }

    @Test
    public void testIsSolvedFalse() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, EMPTY_VALUE, 13, 14, 15, 12};
        Board board = new Puzzle15Board(tiles);
        assertTrue(board.moveTile(11));
        assertFalse(board.isSolved());
    }

    @Test
    public void testValidMoveTileUp() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, EMPTY_VALUE, 13, 14, 15, 12};
        Board board = new Puzzle15Board(tiles);
        assertTrue(board.moveTile(12));
    }

    @Test
    public void testValidMoveTileDown() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, EMPTY_VALUE, 13, 14, 15, 12};
        Board board = new Puzzle15Board(tiles);
        assertTrue(board.moveTile(8));
    }

    @Test
    public void testValidMoveTileLeft() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, EMPTY_VALUE, 15};
        Board board = new Puzzle15Board(tiles);
        assertTrue(board.moveTile(15));
    }

    @Test
    public void testValidMoveTileRight() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, EMPTY_VALUE, 15};
        Board board = new Puzzle15Board(tiles);
        assertTrue(board.moveTile(14));
    }


    @Test
    public void testInValidMoveTile() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, EMPTY_VALUE};
        Board board = new Puzzle15Board(tiles);
        assertFalse(board.moveTile(5));
    }

    @Test
    public void testInValidMoveNullTile() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, EMPTY_VALUE};
        Board board = new Puzzle15Board(tiles);
        assertFalse(board.moveTile(null));
    }

    @Test
    public void testInValidMoveNonExistinglTile() {
        int[] tiles = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, EMPTY_VALUE};
        Board board = new Puzzle15Board(tiles);
        assertFalse(board.moveTile(10000));
    }

}
