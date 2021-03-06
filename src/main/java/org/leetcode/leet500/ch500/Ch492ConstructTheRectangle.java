package org.leetcode.leet500.ch500;

/**
 * <p>492. 构造矩形
 *
 * <p>作为一位web开发者， 懂得怎样去规划一个页面的尺寸是很重要的。 现给定一个具体的矩形页面面积，你的任务是设计一个长度为 L 和宽度为 W 且满足以下要求的矩形的页面。要求：
 *
 * <p>1. 你设计的矩形页面必须等于给定的目标面积。
 *
 * <p>2. 宽度 W 不应大于长度 L，换言之，要求 L >= W 。
 *
 * <p>3. 长度 L 和宽度 W 之间的差距应当尽可能小。
 *
 * <p> 你需要按顺序输出你设计的页面的长度 L 和宽度 W。
 *
 * <p>示例：
 *
 * <p>输入: 4
 * <p> 输出: [2, 2]
 * <p> 解释: 目标面积是 4， 所有可能的构造方案有 [1,4], [2,2], [4,1]。
 * <p>但是根据要求2，[1,4] 不符合要求; 根据要求3，[2,2] 比 [4,1] 更能符合要求. 所以输出长度 L 为 2， 宽度 W 为 2。
 *
 * <p> 说明:
 *
 * <p>    给定的面积不大于 10,000,000 且为正整数。
 * <p>    你设计的页面的长度和宽度必须都是正整数。
 *
 * <p> 通过次数15,344
 * <p>提交次数28,491
 * <p>在真实的面试中遇到过这道题？
 * <p>https://leetcode-cn.com/problems/construct-the-rectangle/
 *
 *
 * @author: wangrui
 * @date: 2021/3/11
 */
public class Ch492ConstructTheRectangle {

  public int[] constructRectangle(int area) {
    int width=(int) Math.sqrt(area);
    int[] result = new int [2];
    while(width>0){
      if(area % width == 0){
        result[0] = area/width;
        result[1] = width;
        return result;
      }
      width--;
    }
    return result;
  }

  public static int[] constructRectangle2(int area) {
    int[] result = new int[2];
    int minSub = 0;
    int length = 0;
    int width = 0;
    for (int i = 1; i * i <= area; i++) {
      if (area % i == 0) {
        int sub = area / i - i;
        if (sub <= minSub || i == 1) {
          length = area / i;
          width = i;
          minSub=sub;
        }
      }
    }
    result[0] = length;
    result[1] = width;
    return result;
  }
}
