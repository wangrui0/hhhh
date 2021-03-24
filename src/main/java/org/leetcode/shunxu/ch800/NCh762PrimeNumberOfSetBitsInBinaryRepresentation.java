package org.leetcode.shunxu.ch800;

/**
 * <p>762. 二进制表示中质数个计算置位
 *
 * <p>给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
 *
 * <p>（注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
 *
 * <p>示例 1:
 *
 * <p>输入: L = 6, R = 10
 * <p>输出: 4
 * <p>解释:
 * <p>6 -> 110 (2 个计算置位，2 是质数)
 * <p>7 -> 111 (3 个计算置位，3 是质数)
 * <p>9 -> 1001 (2 个计算置位，2 是质数)
 * <p>10-> 1010 (2 个计算置位，2 是质数)
 *
 * <p>示例 2:
 *
 * <p>输入: L = 10, R = 15
 * <p>输出: 5
 * <p>解释:
 * <p>10 -> 1010 (2 个计算置位, 2 是质数)
 * <p>11 -> 1011 (3 个计算置位, 3 是质数)
 * <p>12 -> 1100 (2 个计算置位, 2 是质数)
 * <p>13 -> 1101 (3 个计算置位, 3 是质数)
 * <p>14 -> 1110 (3 个计算置位, 3 是质数)
 * <p>15 -> 1111 (4 个计算置位, 4 不是质数)
 *
 * <p>注意:
 *
 * <p>    L, R 是 L <= R 且在 [1, 10^6] 中的整数。
 * <p>    R - L 的最大值为 10000。
 * <p> https://leetcode-cn.com/problems/prime-number-of-set-bits-in-binary-representation/
 * <p>通过次数15,140
 * <p>提交次数21,825
 * <p>在真实的面试中遇到过这道题？
 * <p>@author: wangrui
 * <p>@date: 2021/3/24
 */
public class NCh762PrimeNumberOfSetBitsInBinaryRepresentation {

  public int countPrimeSetBits(int L, int R) {
    return -1;
  }
}
