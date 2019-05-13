package leet190325;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution {

    // my
    public static String longestCommonPrefix(String[] strs) {
        if (!(strs.length > 0))
            return "";

        int min = strs[0].length();     // 最小的字符串字符数
        int index;

        for (int i = 0; i < strs.length; i++) {
            min = min < strs[i].length() ? min : strs[i].length();
        }

        // 外循环控制字符数, 内循环控制 strs 数组
        for (index = 0; index < min; index++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(index) != strs[j-1].charAt(index)) {
                    return index == 0 ? "" : strs[j].substring(0, index);
                }
            }
        }

        return strs[0].substring(0, index);
    }

    // 答案1
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];


        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static void main(String... args)
    {
        System.out.println(longestCommonPrefix2(new String[]{"flower","flow","flight"}));
    }
}
