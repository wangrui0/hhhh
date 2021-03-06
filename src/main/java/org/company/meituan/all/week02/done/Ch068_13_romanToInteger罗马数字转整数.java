package org.company.meituan.all.week02.done;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>13. 罗马数字转整数
 * <p>罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * <p>字符          数值
 * <p>I             1
 * <p>V             5
 * <p>X             10
 * <p>L             50
 * <p>C             100
 * <p>D             500
 * <p>M             1000
 * <p>例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * <p>通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为
 * IX。这个特殊的规则只适用于以下六种情况：
 *
 * <p>I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * <p>X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * <p>C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * <p>给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *
 *
 * <p>示例 1:
 *
 * <p>输入: "III"
 * <p>输出: 3
 * <p>示例 2:
 *
 * <p>输入: "IV"
 * <p>输出: 4
 * <p>示例 3:
 *
 * <p>输入: "IX"
 * <p>输出: 9
 * <p>示例 4:
 *
 * <p>输入: "LVIII"
 * <p>输出: 58
 * <p>解释: L = 50, V= 5, III = 3.
 * <p>示例 5:
 *
 * <p>输入: "MCMXCIV"
 * <p>输出: 1994
 * <p>解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * <p>提示：
 *
 * <p>1 <= s.length <= 15
 * <p>s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
 * <p>题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
 * <p>题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * <p>IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * <p>关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 * <p>通过次数394,497提交次数623,669
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/roman-to-integer/
 * <p>@Author: shenpei
 * <p>@Date: 2021/5/17 6:32 下午
 */
public class Ch068_13_romanToInteger罗马数字转整数 {

  public static void main(String[] args) {
    System.out.println(romanToInt_self("III"));
    System.out.println(romanToInt_self("IX"));
    System.out.println(romanToInt_self("LVIII"));
    System.out.println(romanToInt_self("MCMXCIV"));
  }

  public static int romanToInt_self(String s) {
    if (s.length() == 0) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<Character, Integer>() {{
      put('I', 1);
      put('V', 5);
      put('X', 10);
      put('L', 50);
      put('C', 100);
      put('D', 500);
      put('M', 1000);
    }};
    int pre = map.get(s.charAt(0));
    int ans = 0;
    for (int i = 1; i < s.length(); i++) {
      Integer num = map.get(s.charAt(i));
      if (num <= pre) {
        ans += pre;
      } else {
        ans -= pre;
      }
      pre = num;
    }
    ans += pre;
    return ans;
  }

  Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
    put('I', 1);
    put('V', 5);
    put('X', 10);
    put('L', 50);
    put('C', 100);
    put('D', 500);
    put('M', 1000);
  }};

  public int romanToInt(String s) {
    int ans = 0;
    int n = s.length();
    for (int i = 0; i < n; ++i) {
      int value = symbolValues.get(s.charAt(i));
      if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
        ans -= value;
      } else {
        ans += value;
      }
    }
    return ans;
  }


}
