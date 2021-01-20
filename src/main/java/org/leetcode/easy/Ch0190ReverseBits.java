package org.leetcode.easy;

/**
 * <p> 颠倒给定的 32 位无符号整数的二进制位。
 * <p>
 *  
 *
 * <p> 示例 1：
 * <p>
 * 输入: 00000010100101000001111010011100
 * <p>
 * 输出: 00111001011110000010100101000000
 * <p>
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 * <p>      因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
 * <p> 示例 2：
 *
 * <p> 输入：11111111111111111111111111111101
 * <p> 输出：10111111111111111111111111111111
 * <p> 解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
 * <p>      因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。
 *  
 *
 * <p> 提示：
 *
 * <p> 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * <p> 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *  
 *
 * <p> 进阶:
 * <p> 如果多次调用这个函数，你将如何优化你的算法？
 *
 * <p> 来源：力扣（LeetCode）
 * <p> 链接：https://leetcode-cn.com/problems/reverse-bits
 * <p> 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: wangrui
 * @date: 2020/12/23
 */
public class Ch0190ReverseBits {

  /**
   * https://leetcode-cn.com/problems/reverse-bits/solution/zhi-qi-ran-zhi-qi-suo-yi-ran-wei-yun-suan-jie-fa-x/
   *
   * @param n
   * @return
   */
  public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result = (result << 1) + (n & 1);
      n >>= 1;
    }
    return result;
  }

  public int reverseBits2(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
      result = (result << 1) + (n & 1);
      n >>= 1;
    }
    return result;
  }
}