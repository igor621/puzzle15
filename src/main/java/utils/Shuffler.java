package utils;

import java.util.Random;

public class Shuffler {

    public static int[] immutableShuffle(int[] ar) {
      int[] array = ar.clone();
      Random rand = new Random();
      for (int i = 0; i < array.length; i++) {
        int randomIndexToSwap = rand.nextInt(array.length);
        int tmp = array[randomIndexToSwap];
        array[randomIndexToSwap] = array[i];
        array[i] = tmp;
      }
      return array;
    }
}