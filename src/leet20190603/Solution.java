package leet20190603;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class Solution {
    /**
     * 队列 + 栈
     * @param s 字符串
     * @return boolean
     */
    public static boolean isPalindrome(String s) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char ch : chars) {
            int ascll = (int) ch;
            if ((ascll >= 48 && ascll <= 57) ||
                (ascll >= 65 && ascll <= 90) ||
                (ascll >= 97 && ascll <= 122)) {
                queue.offer(ch);
                stack.push(ch);
            }
        }

        if (stack.size() != queue.size()) {
            return false;
        }
        while (! queue.isEmpty()) {
            String s1 = String.valueOf(queue.poll());
            if (! s1.equalsIgnoreCase(String.valueOf(stack.pop()))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 双指针
     * @param s 字符串
     * @return boolean
     */
    public static boolean isPalindrome2(String s) {
        char[] sarr = s.toLowerCase().toCharArray();
        int i = 0, j = sarr.length - 1;
        while(i < j){
            if(sarr[i] == sarr[j] && ((sarr[i] >= 'a' && sarr[i] <= 'z' )||(sarr[i] >= '0' && sarr[i] <= '9' ))){
                i++; j--;
            }else if((sarr[i] < 'a' || sarr[i] > 'z' ) && (sarr[i] < '0' || sarr[i] > '9' )){
                i++;
            }else if((sarr[j] < 'a' || sarr[j] > 'z' ) && (sarr[j] < '0' || sarr[j] > '9' )){
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "11";
        boolean ispalindrome = isPalindrome2(str);
        System.out.println("finish :)");
    }
}
