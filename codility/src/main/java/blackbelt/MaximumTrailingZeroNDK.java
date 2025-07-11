package blackbelt;

public class MaximumTrailingZeroNDK {

  public int solution(int[][] A) {
    int row = A.length;
    int col = A[0].length;

    // Define DP Array for counting 2 and 5 number
    int[][] number2s = new int[row][col];
    int[][] number5s = new int[row][col];

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        number2s[i][j] = count(A[i][j], 2);
        number5s[i][j] = count(A[i][j], 5);
      }
    }

    int max = 0;
    // Check max for row
    for (int i = 0; i < row; i++) {
      int maxRow = 0;
      for (int j = 0; j < col; j++) {
        maxRow += Math.min(number2s[i][j], number5s[i][j]);
//                System.out.println("maxRow " + maxRow);

      }
      max = Math.max(max, maxRow);
    }

    // Check max for col
    for (int j = 0; j < col; j++) {
      int maxCol = 0;
      for (int i = 0; i < row; i++) {
        maxCol += Math.min(number2s[i][j], number5s[i][j]);
//                System.out.println("maxCol " + maxCol);
      }
      max = Math.max(max, maxCol);
    }

    // Check max for diagonal
    int[] directCol = new int[]{1, 0, -1, 0}; // Right - Down - Left - Up
    int[] directRow = new int[]{0, 1, 0, -1};

    // DP for saving max L
    int[] maxDirection = new int[4];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
//        System.out.println("-------------------------------");
//        System.out.println("i " + i + " j: " + j + " value :" + A[i][j]);
        for (int k = 0; k < 4; k++) {
          int count2 = 0;
          int count5 = 0;
          int r = i;
          int c = j;
          while (r >= 0 && r < row && c >= 0 && c < col) {
            count2 += number2s[r][c];
            count5 += number5s[r][c];
            r += directRow[k];
            c += directCol[k];
          }
          maxDirection[k] = Math.min(count2, count5);
          System.out.println("maxDirection " + k + "="+ maxDirection[k]);

          // Check max
          if (k >= 1) {
            max = Math.max(max, maxDirection[k - 1] + maxDirection[k] - Math.min(number2s[i][j], number5s[i][j]));
          }
        }
        max = Math.max(max, maxDirection[0] + maxDirection[3] - Math.min(number2s[i][j], number5s[i][j]));


        System.out.println("max: " + max);

      }
    }
    return max;
  }

  private int count(int value, int divider) {
    int count = 0;
    while (value % divider == 0) {
      count++;
      value /= 2;
    }
    return count;
  }


}