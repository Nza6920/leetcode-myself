package leet190319;

import java.util.ArrayList;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Solution {

    public static int reverse(int x) {

        ArrayList<Integer> positions = new ArrayList<>();  // 存储每一位的数字
        boolean flag = true;        // 检测是否是第一次
        int temp;
        long result = 0;

        while (x != 0) {
            temp = x%10;   // 位数
            // 取出第一位为0的
            if (temp == 0 && flag) {
                flag = false;
            } else {
                positions.add(temp);
                flag = false;
            }

            x = x/10;
        }

        for (int i = 0, j=positions.size(); i<positions.size(); i++) {
            result += positions.get(i) * Math.pow(10, --j);
        }

        return ((result > Integer.MAX_VALUE) || result < Integer.MIN_VALUE) ? 0 : ((int) result);
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

    public static void main(String[] args)
    {

        System.out.println(reverse(1221));
    }
}
