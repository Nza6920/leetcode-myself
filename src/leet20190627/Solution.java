package leet20190627;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 */
public class Solution {
    public int firstUniqChar(String s) {

        int[] freq = new int[26];  // 存储每一个字母出现的频率

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";

        int freq = new Solution().firstUniqChar(s);
        System.out.println(freq);


        System.out.println("finish :)");
    }
}