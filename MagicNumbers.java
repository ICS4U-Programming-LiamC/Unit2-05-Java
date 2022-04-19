import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * MagicNumbers.java brute force algorithm,
 * generates all possible 3x3's populated with numbers 1-9
 * then deletes the ones that are not magic squares
 *
 * @author Liam Csiffary
 * @version 1.0
 * @since 2022-04-11
 */

public class MagicNumbers {

  // the function which calculates the factorial
  public static int factorialCalcer(int number) {
    // base cases, if either 0 or 1 return 1
    if (number == 0 || number == 1) {
      return 1;
    } else {
      // otherwise sends the number -1 to the function and returns
      // that * number
      return (factorialCalcer(number - 1) * number);
    }
  }

  // https://stackoverflow.com/questions/2920315/permutation-of-array#:~:text=You%20take%20first%20element%20of,starting%20with%20i%2Dth%20element.
  static List<List<Integer>> permute(List<Integer> arr, int k) {

    List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();

    for (int i = k; i < arr.size(); i++) {
      java.util.Collections.swap(arr, i, k);
      permute(arr, k + 1);
      java.util.Collections.swap(arr, k, i);
    }
    if (k == arr.size() - 1) {
      listOfLists.add(arr);
      // System.out.println(java.util.Arrays.toString(arr.toArray()));
    }
    return listOfLists;
  }

  public static void main(String[] args) {
    // generate all possible squares
    List<List<Integer>> squares = new ArrayList<List<Integer>>();

    int n = 3;

    int[] nums = new int[n * n];

    for (int i = 1; i <= n * n; i++) {
      nums[i - 1] = i;
    }

    squares = permute(java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), 0);

    System.out.println(length(squares));

  }
}
