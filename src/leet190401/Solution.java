package leet190401;

import com.sun.org.apache.bcel.internal.generic.GOTO;

import java.util.LinkedList;
import java.util.Queue;

/**
 *报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 *
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */
public class Solution {

    public static String countAndSay(int n) {
        String[] array = new String[n];
        array[0] =  1 + "";
        for (int i = 1; i < n; i++) {
            array[i] = "";
            for (int j = 0; j < array[i-1].length(); j++) {
                char c = array[i-1].charAt(j);
                int count = 1;
                while (j+1 < array[i-1].length() && c == array[i-1].charAt(j+1)) {
                    count++;
                    j++;
                }
                array[i] += count + "" + c;
            }
        }
        return array[n-1];
    }

    // my
    public static String countAndSay2(int time) {
        Queue<String> queue = new LinkedList<>();
        if (time == 1) {
            return "1";
        }

        if (time == 2) {
            return "11";
        }

        String target = "11";

        while (time > 2) {
            int count = 1;
            char[] chars = target.toCharArray();
            char temp = chars[0];

            for (int i = 1; i < chars.length; i++) {
                if (temp == chars[i]) {
                    count++;
                    if (i+1!=chars.length)
                        continue;
                }
                queue.offer(String.valueOf(count));
                queue.offer(String.valueOf(temp));
                count = 1;
                temp = chars[i];

                if (i+1 == chars.length && chars[i-1] != temp) {
                    queue.offer(String.valueOf(count));
                    queue.offer(String.valueOf(temp));
                    break;
                }

                System.out.println("正在读...");
            }

            StringBuilder builder = new StringBuilder();
            while (queue.size() > 0) {
                builder.append(queue.poll());
            }

            target = builder.toString();
            time--;
            System.out.println("倒数:" + time);
        }

        return target;
    }

    public static void main(String... args)
    {
        System.out.println(countAndSay2(60));
    }
}
