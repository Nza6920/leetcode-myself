package leet190330;


/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 *
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class Solution {
    public static int strStr(String haystack, String needle)
    {
        return haystack.indexOf(needle);
    }

    public static int strStrs(String haystack, String needle) {
        if(needle.equals(""))
            return 0;
        int i;
        int len = needle.length();
        for(i=0;i<haystack.length()-len+1;i++){
            if(haystack.substring(i,i+len).equals(needle))
                return i;
        }
        return -1;
    }
    public static void main(String... args)
    {

        System.out.println(strStr("bbaa", "aab"));
    }


}
