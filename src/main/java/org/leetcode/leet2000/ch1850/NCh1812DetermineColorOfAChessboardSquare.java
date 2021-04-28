package org.leetcode.leet2000.ch1850;

/**
 * <p>1812. 判断国际象棋棋盘中一个格子的颜色
 *
 * <p>给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 *
 * <p>如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 *
 * <p>给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：coordinates = "a1"
 * <p>输出：false
 * <p>解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 *
 * <p>示例 2：
 *
 * <p>输入：coordinates = "h3"
 * <p>输出：true
 * <p>解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 *
 * <p>示例 3：
 *
 * <p>输入：coordinates = "c7"
 * <p>输出：false
 *
 *
 *
 * <p>提示：
 *
 * <p>    coordinates.length == 2
 * <p>    'a' <= coordinates[0] <= 'h'
 * <p>    '1' <= coordinates[1] <= '8'
 *
 * <p>通过次数5,086
 * <p>提交次数6,358
 * <p>请问您在哪类招聘中遇到此题？
 * <p>https://leetcode-cn.com/problems/determine-color-of-a-chessboard-square/
 * <p>@Author: shenpei
 * <p>@Date: 2021/4/25 10:17 下午
 */
public class NCh1812DetermineColorOfAChessboardSquare {

  public boolean squareIsWhite(String coordinates) {
    return true;
  }
}
