package leet190407;

import java.util.Arrays;
/**
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * */

public class Solution {

    public static int[] plusOne(int[] digits) {
        int carry = 1;    // 进位

        for (int i = digits.length-1; i >= 0 && carry == 1; i--) {
                digits[i]+=carry;
                if (digits[i] == 10) {
                    digits[i] = 0;
                    continue;
                }else {
                    carry = 0;
                    break;
                }
        }

        if (digits[0] == 0 && carry == 1) {
            int[] digitsPlus = new int[digits.length+1];
            int index = 1;

            for (int member : digits) {
                digitsPlus[index] = member;
                index++;
            }

            digitsPlus[0] = carry;

            return digitsPlus;
        }

        return digits;
    }

    public static void main(String... args)
    {

        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));
    }
}
