package Assignment7;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> res = printPascalTriangle(6);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> printPascalTriangle(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return res;

        for (int j = 0; j < numRows; j++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i < j; i++) {//除去第一行和第二行才进这个循环
                List<Integer> prevRow = res.get(j - 1);//当前行的上一行
                int temp = prevRow.get(i - 1) + prevRow.get(i);
                row.add(temp);
            }
            if (j != 0)//除了第一行，末尾接个1
                row.add(1);
            res.add(row);
        }
        return res;
    }
}
