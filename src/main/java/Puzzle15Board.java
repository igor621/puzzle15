import helpers.Constants;
import utils.Shuffler;
import utils.Tuple;

import java.util.Formatter;
import java.util.Optional;

public class Puzzle15Board implements Board {
   
    private int[][] gameField;

    static private int[] solvedPuzzle = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, Constants.EMPTY_VALUE};

    Puzzle15Board() {
      init();
      int[] shuffledPuzzle = Shuffler.immutableShuffle(this.solvedPuzzle);
      buildGameField(shuffledPuzzle); 
    }

    Puzzle15Board(int[] tiles) {
      if (tiles == null || tiles.length / Constants.BOARD_SIZE != Constants.BOARD_SIZE){
         throw new IllegalArgumentException("couldn't process tiles argument");
      }
      init();
      buildGameField(tiles);
    }

    private void init(){
      this.gameField = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    }

    private void buildGameField(int[] tiles) {
      for (int i = 0; i < Constants.BOARD_SIZE; i++) {
        for (int j = 0; j < Constants.BOARD_SIZE; j++) {
          this.gameField[i][j] = tiles[i * Constants.BOARD_SIZE + j];
        }
      }
    }

    private Optional<Tuple<Integer, Integer>>getPositionByValue(int v) {
      for (int i = 0; i < Constants.BOARD_SIZE; i++) {
        for (int j = 0; j < Constants.BOARD_SIZE; j++) {
          if (this.gameField[i][j] == v) {
            return Optional.of(new Tuple<Integer, Integer>(i, j));
          }
        }
      }
      return Optional.empty();
    }

    private boolean canBeSwapped(Tuple<Integer, Integer> fst, Tuple<Integer, Integer> snd) {
      if (fst.x == snd.x && Math.abs(fst.y - snd.y) == 1) {
        return true;
      }
      if (fst.y == snd.y && Math.abs(fst.x - snd.x) == 1) {
        return true;
      }
      return false;
    }

    private void swap(Tuple<Integer, Integer> fst, Tuple<Integer, Integer> snd) {
      int tmp = this.gameField[fst.x][fst.y];
      this.gameField[fst.x][fst.y] = this.gameField[snd.x][snd.y];
      this.gameField[snd.x][snd.y] = tmp;
    }

    @Override
    public boolean moveTile(Integer value) {
        if (value != null) {
          Optional<Tuple<Integer, Integer>>tilePosition = getPositionByValue(value);
          Optional<Tuple<Integer, Integer>>emptyPosition = getPositionByValue(Constants.EMPTY_VALUE);
          if (tilePosition.isPresent() && emptyPosition.isPresent()) {
            if (canBeSwapped(tilePosition.get(), emptyPosition.get())) {
              swap(tilePosition.get(), emptyPosition.get());
              return true;
            }
          }
        }
        return false;
    }

    @Override
    public boolean isSolved() {
      for (int i = 0; i < Constants.BOARD_SIZE; i++) {
        for (int j = 0; j < Constants.BOARD_SIZE; j++) {
          if (this.gameField[i][j] != this.solvedPuzzle[i * Constants.BOARD_SIZE + j]) {
            return false;
          }
        }
      }
      return true;
    }

   @Override
   public String toString() {
     StringBuilder sb = new StringBuilder();
     Formatter fmt = new Formatter(sb);
     sb.append("Board");
     for (int i = 0; i < Constants.BOARD_SIZE; i++) {
        sb.append("\n");
        for (int j = 0; j < Constants.BOARD_SIZE; j++) {
          fmt.format("%-3d", gameField[i][j]);
        }
     }
     sb.append("\n");
     return sb.toString();
   }
}
