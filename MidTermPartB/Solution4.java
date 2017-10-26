package MidTermPartB;

public class Solution4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        System.out.println(s.countNumberOfPossibleWays(3,2, 4));
    }
    public int countNumberOfPossibleWays(int m, int n, int x) {
        int[][] table = new int[n + 1][x + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < x + 1; j++) {
                table[i][j] = 0;
            }
        }
        for (int j = 0; j <= m && j <= x; j++) {
            table[1][j] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= m && k < j; k++) {
                    table[i][j] += table[i - 1][j - k];
                }
            }
        }
        return table[n][x];
    }
}
