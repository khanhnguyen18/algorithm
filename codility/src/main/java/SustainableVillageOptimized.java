public class SustainableVillageOptimized {
  public static void main(String[] args) {
//    int[] A = {-3, 2, 4, -5, 3}; // Return 3
    int[] A = {1, -3, 2}; // Return 2
//    int[] A = {-2, 1, -3, 1}; Return 4
    int treesPlanted = makeSustainable(A);

    System.out.println("\nTrees Planted: " + treesPlanted);
  }

  // Improved logic to modify the array optimally
  public static int makeSustainable(int[] A) {
    int n = A.length;
    int[] B = A.clone();

    int totalTree = 0;
    for (int i = 0; i < n; i++) {
      int sum = calculateNeighborhoodSum(i, B, n);

      // Plant tree on the right or current
      if (sum < 0) {
        int need = -sum;
        if (i < n - 1) {
          B[i + 1] += need;
        } else {
          B[i] += need;
        }
        totalTree += need;
      }
    }

    return totalTree;
  }

  private static int calculateNeighborhoodSum(int i, int[] B, int n) {
    int left = (i > 0) ? B[i - 1] : 0;
    int mid = B[i];
    int right = (i < n - 1) ? B[i + 1] : 0;
    return left + mid + right;
  }

  public static int totalPlantedTrees(int[] original, int[] modified) {
    int total = 0;
    for (int i = 0; i < original.length; i++) {
      if (modified[i] > original[i]) {
        total += (modified[i] - original[i]);
      }
    }
    return total;
  }

}
