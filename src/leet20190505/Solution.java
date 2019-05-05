package leet20190505;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i || i == 0) {
                    row.add(1);
                } else {
                    List<Integer> previous = triangle.get(i-1);
                    row.add(previous.get(j) + previous.get(j-1));
                }
            }
            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {

        List<List<Integer>> triangle = generate(5);

        for (List<Integer> list : triangle) {
            for (Integer item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

    }
}
