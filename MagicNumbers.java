import java.util.ArrayList;
import java.util.List;

/**
 * MagicNumbers.java brute force algorithm,
 * generates all possible 3x3's populated with numbers 1-9
 * then deletes the ones that are not magic squares
 *
 * @author Liam Csiffary
 * @version 1.1
 * @since 2022-04-22
 */

public class MagicNumbers {

  // https://stackoverflow.com/questions/2920315/permutation-of-array#:~:text=You%20take%20first%20element%20of,starting%20with%20i%2Dth%20element.
  public static List<int[]> permute(List<Integer> arr, int k, List<int[]> allSquares) {

    // from the internet, as I understand it, it generates all combinations of the square
    for (int i = k; i < arr.size(); i++) {
      java.util.Collections.swap(arr, i, k);
      permute(arr, k + 1, allSquares);
      java.util.Collections.swap(arr, k, i);
    }
    if (k == arr.size() - 1) {
      // this converts the array of objects that it generates and turns it into an array of ints
      int[] arrayOfNums = arr.stream().mapToInt(i -> i).toArray();
      allSquares.add(arrayOfNums);
      // System.out.println(java.util.Arrays.toString(arr.toArray()));
    }
    // sends allSquares back to main
    return allSquares;
  }

  public static List<int[]> permuteWithShinking(List<Integer> arr, int k, List<int[]> allSquares) {

    // same as before, generates all combinations of a square
    for (int i = k; i < arr.size(); i++) {
      java.util.Collections.swap(arr, i, k);
      permuteWithShinking(arr, k + 1, allSquares);
      java.util.Collections.swap(arr, k, i);
    }
    if (k == arr.size() - 1) {
      // convert array of objects to array of ints
      int[] arrayOfNums = arr.stream().mapToInt(i -> i).toArray();

      if (arrayOfNums[4] == 5) { // center

        if ((arrayOfNums[1]) == 1 || (arrayOfNums[3] == 1) || (
            arrayOfNums[5]) == 1 || (arrayOfNums[7]) == 1) { // edge

          if ((arrayOfNums[0]) == 2 || (arrayOfNums[2] == 2) || (
              arrayOfNums[6]) == 2 || (arrayOfNums[8]) == 2) { // corner

            if ((arrayOfNums[1]) == 3 || (arrayOfNums[3] == 3) || (
                arrayOfNums[5]) == 3 || (arrayOfNums[7]) == 3) { // edge

              if ((arrayOfNums[0]) == 4 || (arrayOfNums[2] == 4) || (
                  arrayOfNums[6]) == 4 || (arrayOfNums[8]) == 4) { // corner

                if ((arrayOfNums[0]) == 6 || (arrayOfNums[2] == 6) || (
                    arrayOfNums[6]) == 6 || (arrayOfNums[8]) == 6) { // corner

                  if ((arrayOfNums[1]) == 7 || (arrayOfNums[3] == 7) || (
                      arrayOfNums[5]) == 7 || (arrayOfNums[7]) == 7) { // edge

                    if ((arrayOfNums[0]) == 8 || (arrayOfNums[2] == 8) || (
                        arrayOfNums[6]) == 8 || (arrayOfNums[8]) == 8) { // corner

                      if ((arrayOfNums[1]) == 9 || (arrayOfNums[3] == 9) || (
                          arrayOfNums[5]) == 9 || (arrayOfNums[7]) == 9) { // edge

                        // if it passes all of these scenarios then add it to the final array 
                        allSquares.add(arrayOfNums);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return allSquares;
  }

  public static List<int[]> isMagicSquare(List<int[]> allPossibleSquares) {
    // array of correctSquares
    List<int[]> correctSquares = new ArrayList<int[]>();
    for (int i = 0; i < allPossibleSquares.size(); i++) {
      // calculates what all the parts fof the square add up to
      int row1 = allPossibleSquares.get(i)[0]
          + allPossibleSquares.get(i)[1] + allPossibleSquares.get(i)[2];
      int row2 = allPossibleSquares.get(i)[3]
          + allPossibleSquares.get(i)[4] + allPossibleSquares.get(i)[5];
      int row3 = allPossibleSquares.get(i)[6]
          + allPossibleSquares.get(i)[7] + allPossibleSquares.get(i)[8];
      int column1 = allPossibleSquares.get(i)[0]
          + allPossibleSquares.get(i)[3] + allPossibleSquares.get(i)[6];
      int column2 = allPossibleSquares.get(i)[1]
          + allPossibleSquares.get(i)[4] + allPossibleSquares.get(i)[7];
      int column3 = allPossibleSquares.get(i)[2]
          + allPossibleSquares.get(i)[5] + allPossibleSquares.get(i)[8];
      int diagonal1 = allPossibleSquares.get(i)[0]
          + allPossibleSquares.get(i)[4] + allPossibleSquares.get(i)[8];
      int diagonal2 = allPossibleSquares.get(i)[2]
          + allPossibleSquares.get(i)[4] + allPossibleSquares.get(i)[6];

      if ((row1 == row2) && (row2 == row3) && (row3 == column1) && (column1 == column2)
          && (column2 == column3) && (column3 == diagonal1) && (diagonal1 == diagonal2)) {
        // if all rows columns and diagonals == the same number add it to the list
        correctSquares.add(allPossibleSquares.get(i));
      }
    }
    return correctSquares;
  }

  public static List<int[]> isMagicSquareReccur(List<int[]> allPossibleSquares, int i, List<int[]> correctSquares) {
    // base case
    if (allPossibleSquares.size() <= i) {
      return correctSquares;

    } else {
      // calculates what all the parts of the square add up to
      int row1 = allPossibleSquares.get(i)[0]
          + allPossibleSquares.get(i)[1] + allPossibleSquares.get(i)[2];
      int row2 = allPossibleSquares.get(i)[3]
          + allPossibleSquares.get(i)[4] + allPossibleSquares.get(i)[5];
      int row3 = allPossibleSquares.get(i)[6]
          + allPossibleSquares.get(i)[7] + allPossibleSquares.get(i)[8];
      int column1 = allPossibleSquares.get(i)[0]
          + allPossibleSquares.get(i)[3] + allPossibleSquares.get(i)[6];
      int column2 = allPossibleSquares.get(i)[1]
          + allPossibleSquares.get(i)[4] + allPossibleSquares.get(i)[7];
      int column3 = allPossibleSquares.get(i)[2]
          + allPossibleSquares.get(i)[5] + allPossibleSquares.get(i)[8];
      int diagonal1 = allPossibleSquares.get(i)[0]
          + allPossibleSquares.get(i)[4] + allPossibleSquares.get(i)[8];
      int diagonal2 = allPossibleSquares.get(i)[2]
          + allPossibleSquares.get(i)[4] + allPossibleSquares.get(i)[6];

      if ((row1 == row2) && (row2 == row3) && (row3 == column1) && (column1 == column2)
          && (column2 == column3) && (column3 == diagonal1) && (diagonal1 == diagonal2)) {
        
        // if they all add up to the same number add the array to the list
        correctSquares.add(allPossibleSquares.get(i));

      }
    }
    return isMagicSquareReccur(allPossibleSquares, i + 1, correctSquares);
  }

  public static void squarePrinter(List<int[]> correctSquares) {
    // for each in the list of arrays
    for (int i = 0; i < correctSquares.size(); i++) {
      // for each in the array
      for (int j = 0; j < correctSquares.get(i).length; j++) {
        if ((j + 1) % 3 == 0) {
          System.out.print(correctSquares.get(i)[j]);
          System.out.println();
        } else {
          System.out.print(correctSquares.get(i)[j] + ", ");
        }
      }
      System.out.println("\n");
    }
  }

  public static void main(String[] args) {
    // array for all possible squares
    List<int[]> squares = new ArrayList<int[]>();

    // permute(java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 0, squares);
    permuteWithShinking(java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 0, squares);

    System.out.println("Number of still possible squares " + squares.size());

    List<int[]> finalList = new ArrayList<int[]>();
    List<int[]> finalSet = new ArrayList<int[]>();
    // finalSet = isMagicSquare(squares);
    finalSet = isMagicSquareReccur(squares, 0, finalList);

    System.out.println("Remaining squares after finding sums " + finalSet.size());

    squarePrinter(finalSet);

  }
}
