package org.leetcode.shunxu.ch1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import sun.awt.datatransfer.DataTransferer.IndexedComparator;

/**
 * <p>1356. 根据数字二进制下 1 的数目排序
 *
 * <p>给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * <p>如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * <p>请你返回排序后的数组。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：arr = [0,1,2,3,4,5,6,7,8]
 * <p>输出：[0,1,2,4,8,3,5,6,7]
 * <p>解释：[0] 是唯一一个有 0 个 1 的数。
 * <p>[1,2,4,8] 都有 1 个 1 。
 * <p>[3,5,6] 有 2 个 1 。
 * <p>[7] 有 3 个 1 。
 * <p>按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 *
 * <p>示例 2：
 *
 * <p>输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * <p>输出：[1,2,4,8,16,32,64,128,256,512,1024]
 * <p>解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
 *
 * <p>示例 3：
 *
 * <p>输入：arr = [10000,10000]
 * <p>输出：[10000,10000]
 *
 * <p>示例 4：
 *
 * <p>输入：arr = [2,3,5,7,11,13,17,19]
 * <p>输出：[2,3,5,17,7,11,13,19]
 *
 * <p>示例 5：
 *
 * <p>输入：arr = [10,100,1000,10000]
 * <p>输出：[10,100,10000,1000]
 *
 *
 *
 * <p>提示：
 *
 * <p>    1 <= arr.length <= 500
 * <p>    0 <= arr[i] <= 10^4
 *
 * <p>通过次数42,743
 * <p>提交次数58,366
 * <p>请问您在哪类招聘中遇到此题？
 * <p>@author: wangrui
 * <p>@date: 2021/4/18
 */
public class Ch1356sortIntegersByTheNumberOf1Bits {

  public int[] sortByBits_self(int[] arr) {
    int n = arr.length;
    int[][] list = new int[n][2];
    for (int i = 0; i < arr.length; i++) {
      list[i][0] = arr[i];
      list[i][1] = get(arr[i]);
    }
    Arrays.sort(list, (data1, data2) -> data1[1] != data2[1] ? data1[1] - data2[1] : data1[0] - data2[0]);
    int[] ans = new int[n];
    for (int i = 0; i < n; i++) {
      ans[i] = list[i][0];
    }
    return ans;
  }


  //3 5 6 7
  public int get(int x) {
    int res = 0;
    while (x != 0) {
      res += x % 2;
      x /= 2;
    }
    return res;
  }

  /**
   * <p>方法一： 暴力
   * <p>复杂度分析
   *
   * <p>  时间复杂度：O(nlogn)，其中 n为整数数组 arr 的长度。
   *
   * <p> 空间复杂度：O(n)，其中 n 为整数数组 arr 的长度。
   *
   * @param arr
   * @return
   */
  public int[] sortByBits_2(int[] arr) {
    int[] bit = new int[10001];
    List<Integer> list = new ArrayList<Integer>();
    for (int x : arr) {
      list.add(x);
      bit[x] = get(x);
    }
    Collections.sort(list, (x, y) -> {
      if (bit[x] != bit[y]) {
        return bit[x] - bit[y];
      } else {
        return x - y;
      }
    });
    for (int i = 0; i < arr.length; ++i) {
      arr[i] = list.get(i);
    }
    return arr;
  }

  /**
   * <p> 方法二：递推预处理
   *
   * <p> 我们定义 bit[i] 为数字 i 二进制表示下数字 1 的个数，则可以列出递推式：
   *
   * <p> bit[i]=bit[i>>1]+(i&1)
   *
   * <p> 所以我们线性预处理 bit 数组然后去排序即可。
   * <p> https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/solution/gen-ju-shu-zi-er-jin-zhi-xia-1-de-shu-mu-pai-xu-by/
   * <p> 复杂度分析
   *
   * <p> 时间复杂度：O(nlogn)，其中 n 为整数数组 arr 的长度。
   *
   * <p> 空间复杂度O(n)，其中 n 为整数数组arr 的长度。
   */
  public int[] sortByBits(int[] arr) {
    List<Integer> list = new ArrayList<Integer>();
    for (int x : arr) {
      list.add(x);
    }
    int[] bit = new int[10001];
    for (int i = 1; i <= 10000; ++i) {
      bit[i] = bit[i >> 1] + (i & 1);
    }
    Collections.sort(list, (x, y) -> {
      if (bit[x] != bit[y]) {
        return bit[x] - bit[y];
      } else {
        return x - y;
      }
    });
    for (int i = 0; i < arr.length; ++i) {
      arr[i] = list.get(i);
    }
    return arr;
  }
}
