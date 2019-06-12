package leet20190612;

/**
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 *
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 *
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 *
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 *
 * 说明:
 *
 *     matrix 是一个包含整数的二维数组。
 *     matrix 的行数和列数均在 [1, 20]范围内。
 *     matrix[i][j] 包含的整数在 [0, 99]范围内。
 */
public class Solution {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int leni = matrix.length, lenj = matrix[0].length;
        for(int i = 0; i < leni; i++){
            int basic = matrix[i][0], m = i+1, n = 1;
            while(m < leni && n < lenj){
                if(basic != matrix[m++][n++]){
                    return false;
                }
            }
        }
        for(int j = 1; j < lenj; j++){
            int basic = matrix[0][j], m = 1, n = j+1;
            while(m < leni && n < lenj){
                if(basic != matrix[m++][n++]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}, {5,1,2,3}, {9,5,1,2}};
        boolean isTopeLitzMatrix = isToeplitzMatrix(nums);

        System.out.println("finish :)");
    }
}
