package org.leetcode.leet1000.ch1000;

/**
 * <p>999. 可以被一步捕获的棋子数
 *
 * <p>在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），分别用字符 '.'，'B' 和 'p'
 * 表示。不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。
 *
 * <p>车按国际象棋中的规则移动。东，西，南，北四个基本方向任选其一，然后一直向选定的方向移动，直到满足下列四个条件之一：
 *
 * <p>    棋手选择主动停下来。
 * <p>    棋子因到达棋盘的边缘而停下。
 * <p>    棋子移动到某一方格来捕获位于该方格上敌方（黑色）的卒，停在该方格内。
 * <p>    车不能进入/越过已经放有其他友方棋子（白色的象）的方格，停在友方棋子前。
 *
 * <p>你现在可以控制车移动一次，请你统计有多少敌方的卒处于你的捕获范围内（即，可以被一步捕获的棋子数）。
 *
 *
 *
 * <p>示例 1：
 *
 * <p>输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * <p>输出：3
 * <p>解释：
 * <p>在本例中，车能够捕获所有的卒。
 *
 * <p>示例 2：
 *
 * <p>输入：[[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * <p>输出：0
 * <p>解释：
 * <p>象阻止了车捕获任何卒。
 *
 * <p>示例 3：
 *
 * <p>输入：[[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * <p>输出：3
 * <p>解释：
 * <p>车可以捕获位置 b5，d6 和 f5 的卒。
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 * <p>@author: wangrui
 * <p>@date: 2021/4/3
 */
public class Ch999AvailableCapturesForRook {

  public static void main(String[] args) {
    System.out.println(numRookCaptures_self(
        new char[][]
            {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'p', 'p', '.', 'R', '.', 'p', 'B', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'B', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}
            }
    ));
  }

  //车（Rook），用字符 'R' 表示。棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），分别用字符 '.'，'B' 和 'p'
  public static int numRookCaptures_self(char[][] board) {
    int cnt = 0, st = 0, ed = 0;
    //顺时针方向
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};

    //第一步找到车的位置
    for (int i = 0; i < 8; ++i) {
      for (int j = 0; j < 8; ++j) {
        if (board[i][j] == 'R') {
          st = i;
          ed = j;
          break;
        }
      }
    }
    //然后每个方向一步步的走
    for (int i = 0; i < 4; ++i) {
      for (int step = 0; ; ++step) {
        int tx = st + step * dx[i];
        int ty = ed + step * dy[i];
        if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
          break;
        }
        if (board[tx][ty] == 'p') {
          cnt++;
          break;
        }
      }
    }
    return cnt;
  }

  /**
   * <p 复杂度分析
   * <p>
   * <p    时间复杂度：O(n^2)，其中 n 是棋盘的边长。找白色车在棋盘中的位置需要 O(n^2) 的时间复杂度，模拟车在四个方向上捕获颜色相反的卒需要 O(n) 的时间复杂度，所以一共需要 O(n^2+n) =O(n^2)
   * 的时间复杂度。
   * <p>
   * <p   空间复杂度：O(1)，只需要常数空间存放若干变量。
   *
   * @param board
   * @return
   */
  public int numRookCaptures(char[][] board) {
    int cnt = 0, st = 0, ed = 0;
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    for (int i = 0; i < 8; ++i) {
      for (int j = 0; j < 8; ++j) {
        if (board[i][j] == 'R') {
          st = i;
          ed = j;
          break;
        }
      }
    }
    for (int i = 0; i < 4; ++i) {
      for (int step = 0; ; ++step) {
        int tx = st + step * dx[i];
        int ty = ed + step * dy[i];
        if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
          break;
        }
        if (board[tx][ty] == 'p') {
          cnt++;
          break;
        }
      }
    }
    return cnt;
  }
}