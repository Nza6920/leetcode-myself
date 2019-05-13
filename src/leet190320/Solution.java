package leet190320;

import java.util.ArrayList;
/**
 * 判断一个整数是否是回文数。move数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {

    public static boolean isPalindrome(int x) {

        if (x<0)
            return false;

        ArrayList<Integer> list = new ArrayList<>();

        while (x!=0) {
            list.add(x%10);
            x/=10;
        }

        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (list.get(i).equals(list.get(j)))
                return false;
        }

        return true;
    }


    public static boolean isPalindrome2(int x) {
        if (x == reverse2(x) && x > 0) {
            return true;
        }

        return false;
    }


    // 弹出, 推入
    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


    public static void main(String... args)
    {
        System.out.println(isPalindrome2(1221));
    }
}
