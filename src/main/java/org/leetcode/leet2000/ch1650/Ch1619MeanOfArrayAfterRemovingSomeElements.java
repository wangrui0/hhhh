package org.leetcode.leet2000.ch1650;

import java.util.Arrays;

/**
 * <p>1619. 删除某些元素后的数组均值
 *
 * <p>给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 *
 * <p>与 标准答案 误差在 10-5 的结果都被视为正确结果。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * <p>输出：2.00000
 * <p>解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 * <p>输出：4.00000
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
 * <p>输出：4.77778
 *
 * <p>示例 4：
 *
 * <p>输入：arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
 * <p>输出：5.27778
 *
 * <p>示例 5：
 *
 * <p>输入：arr = [4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1]
 * <p>输出：5.29167
 *
 *
 *
 * <p>提示：
 *
 * <p>    20 <= arr.length <= 1000
 * <p>    arr.length 是 20 的 倍数
 * <p>    0 <= arr[i] <= 105
 *
 * <p>通过次数5,663
 * <p>提交次数8,288
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:26 下午
 */
public class Ch1619MeanOfArrayAfterRemovingSomeElements {

  public static double trimMean(int[] arr) {
    if (arr.length == 0) {
      return -1;
    }
    Arrays.sort(arr);
    int length = arr.length;
    int start = length / 20;
    int end = length - length / 20;
    double sum = 0;
    for (int i = start; i < end; i++) {
      sum += arr[i];
    }
    return sum / (end - start);
  }

  public double trimMean_2(int[] arr) {
//先排序
    Arrays.sort(arr);
    int sum = 0;
    for (int i = (int) (arr.length * 0.05); i < (int) (arr.length * 0.95); i++) {
      sum += arr[i];
    }
    return sum / (arr.length * 0.9);
  }
}
