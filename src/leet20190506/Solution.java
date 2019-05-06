package leet20190506;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class Solution {
    /**
     * 生成所有行, 再取指定行
     * @param rowIndex 指定行索引
     * @return List<Integer>
     */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> previous = triangle.get(i - 1);
                    row.add(previous.get(j) + previous.get(j-1));
                }
            }
            if (i == rowIndex) return row;

            triangle.add(row);
        }
        return triangle.get(rowIndex);
    }

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     *
     * @param rowIndex 指定行索引
     * @return List<Integer>
     */
    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

    public static void main(String[] args) {

        List<Integer> row = getRow2(3);

        for (Integer item : row) {
            System.out.println(item + " ");
        }
    }
}
