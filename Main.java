import java.util.*;

class Main {

  // Given an array of unsorted numbers, find all unique triplets in it that add
  // up to zero.

  // Input: [-3, 0, 1, 2, -1, 1, -2]
  // Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
  // Explanation: There are four unique triplets whose sum is equal to zero.

  private static List<List<Integer>> threeSum(int[] num) {
    Arrays.sort(num);
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < num.length - 2; i++) { //

      if (i == 0 || (i > 0 && num[i] != num[i - 1])) { // ignore duplicates in i

        int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];

        while (lo < hi) { // 2 pointer runs until lo < hi
          if (num[lo] + num[hi] == sum) {

            res.add(Arrays.asList(num[i], num[lo], num[hi]));

            while (lo < hi && num[lo] == num[lo + 1]) // ignore lo duplicates
              lo++;
            while (lo < hi && num[hi] == num[hi - 1]) // ignore high duplicates
              hi--;

            // after match found increment lo and decrement hi to move on
            lo++;
            hi--;
          } else if (num[lo] + num[hi] < sum) // increase low if current < sum else decrese high
            lo++;
          else
            hi--;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(Main.threeSum(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
  }
}