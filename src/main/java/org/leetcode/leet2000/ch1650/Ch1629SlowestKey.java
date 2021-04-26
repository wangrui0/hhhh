package org.leetcode.leet2000.ch1650;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>1629. 按键持续时间最长的键
 *
 * <p>LeetCode 设计了一款新式键盘，正在测试其可用性。测试人员将会点击一系列键（总计 n 个），每次一个。
 *
 * <p>给你一个长度为 n 的字符串 keysPressed ，其中 keysPressed[i] 表示测试序列中第 i 个被按下的键。releaseTimes 是一个升序排列的列表，其中 releaseTimes[i] 表示松开第
 * i 个键的时间。字符串和数组的 下标都从 0 开始 。第 0 个键在时间为 0 时被按下，接下来每个键都 恰好 在前一个键松开时被按下。
 *
 * <p>测试人员想要找出按键 持续时间最长 的键。第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1] ，第 0 次按键的持续时间为 releaseTimes[0] 。
 *
 * <p>注意，测试期间，同一个键可以在不同时刻被多次按下，而每次的持续时间都可能不同。
 *
 * <p>请返回按键 持续时间最长 的键，如果有多个这样的键，则返回 按字母顺序排列最大 的那个键。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：releaseTimes = [9,29,49,50], keysPressed = "cbcd"
 * <p>输出："c"
 * <p>解释：按键顺序和持续时间如下：
 * <p>按下 'c' ，持续时间 9（时间 0 按下，时间 9 松开）
 * <p>按下 'b' ，持续时间 29 - 9 = 20（松开上一个键的时间 9 按下，时间 29 松开）
 * <p>按下 'c' ，持续时间 49 - 29 = 20（松开上一个键的时间 29 按下，时间 49 松开）
 * <p>按下 'd' ，持续时间 50 - 49 = 1（松开上一个键的时间 49 按下，时间 50 松开）
 * <p>按键持续时间最长的键是 'b' 和 'c'（第二次按下时），持续时间都是 20
 * <p>'c' 按字母顺序排列比 'b' 大，所以答案是 'c'
 *
 * <p>示例 2：
 *
 * <p>输入：releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
 * <p>输出："a"
 * <p>解释：按键顺序和持续时间如下：
 * <p>按下 's' ，持续时间 12
 * <p>按下 'p' ，持续时间 23 - 12 = 11
 * <p>按下 'u' ，持续时间 36 - 23 = 13
 * <p>按下 'd' ，持续时间 46 - 36 = 10
 * <p>按下 'a' ，持续时间 62 - 46 = 16
 * <p>按键持续时间最长的键是 'a' ，持续时间 16
 *
 *
 *
 * <p>提示：
 *
 * <p>    releaseTimes.length == n
 * <p>    keysPressed.length == n
 * <p>    2 <= n <= 1000
 * <p>    1 <= releaseTimes[i] <= 109
 * <p>    releaseTimes[i] < releaseTimes[i+1]
 * <p>    keysPressed 仅由小写英文字母组成
 *
 * <p>通过次数6,756
 * <p>提交次数12,883
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/slowest-key/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 7:27 下午
 */
public class Ch1629SlowestKey {

  /**
   * 这个是有问题的答案
   *
   * @param releaseTimes
   * @param keysPressed
   * @return
   */
  public static char slowestKey(int[] releaseTimes, String keysPressed) {
    Map<Character, Long> map = new HashMap<>();
    for (int i = 0; i < keysPressed.length(); i++) {
      if (i == 0) {
        map.put(keysPressed.charAt(i), Long.valueOf(releaseTimes[0]));
      } else {
        Long time = Long.valueOf(releaseTimes[i]) - Long.valueOf(releaseTimes[i - 1]);
        map.put(keysPressed.charAt(i), map.getOrDefault(keysPressed.charAt(i), 0l) + time);
      }
    }
    long maxTime = 0l;
    char maxChar = 'a';
    for (char key : map.keySet()) {
      if (map.get(key) > maxTime || map.get(key) == maxTime && key > maxChar) {
        maxTime = map.get(key);
        maxChar = key;
      }
    }
    return maxChar;
  }


  public static char slowestKey_2(int[] releaseTimes, String keysPressed) {
    char maxChar = keysPressed.charAt(0);
    int maxValue = releaseTimes[0];
    for (int i = 0; i < releaseTimes.length - 1; i++) {
      int tempValue = releaseTimes[i + 1] - releaseTimes[i];
      if (tempValue == maxValue) {
        maxValue = tempValue;
        char tempChar = keysPressed.charAt(i + 1);
        if (tempChar > maxChar) {
          maxChar = tempChar;
        }
      } else if (tempValue > maxValue) {
        maxValue = tempValue;
        maxChar = keysPressed.charAt(i + 1);
      }
    }
    return maxChar;
  }


  public static char slowestKey_3(int[] releaseTimes, String keysPressed) {
    char maxChar = keysPressed.charAt(0);
    int maxValue = releaseTimes[0];
    for (int i = 0; i < releaseTimes.length - 1; i++) {
      int tempTime = releaseTimes[i + 1] - releaseTimes[i];
      if (tempTime == maxValue) {
        if (keysPressed.charAt(i + 1) > maxChar) {
          maxValue = tempTime;
          maxChar = keysPressed.charAt(i + 1);
        }
      } else if (tempTime > maxValue) {
        maxValue = tempTime;
        maxChar = keysPressed.charAt(i + 1);
      }
    }
    return maxChar;
  }
}
