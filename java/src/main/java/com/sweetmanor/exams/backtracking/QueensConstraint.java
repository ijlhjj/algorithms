package com.sweetmanor.exams.backtracking;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例9-1：四皇后问题
 *
 * <p>
 * 有一个4×4的棋盘，要在上面摆放4颗皇后棋子。
 * 要求任意一颗皇后棋子所在位置的水平方向、竖直方向，以及45度斜线方向上都不能出现其他皇后棋子。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-16
 */
public class QueensConstraint {

    public void queueByBackTracking(int size) {
        int[][] q = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                q[i][j] = 0;
        }
        queue(0, size, q);
    }

    private void queue(int col, int size, int[][] q) {
        //找到一个解，打印结果
        if (col == size) {
            print(size, q);
            return;
        }

        //测试是否符合题目约束，符合则推进到下一列，否则回退
        for (int i = 0; i < size; i++) {
            if (isCorrectPosition(i, col, size, q)) {
                q[i][col] = 1; //摆放1个皇后
                queue(col + 1, size, q); //继续测试后续
                q[i][col] = 0; //回退
            }
        }
    }

    private void print(int size, int[][] q) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(q[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private boolean isCorrectPosition(final int i, final int j, final int size, int[][] q) {
        //判断行
        for (int k = 0; k < size; k++) {
            if (q[i][k] == 1 && k != j)
                return false;
        }

        //判断列
        for (int k = 0; k < size; k++) {
            if (q[k][j] == 1 && k != i)
                return false;
        }

        //判断左上方
        for (int row = i - 1, col = j - 1; row >= 0 && col >= 0; row--, col--) {
            if (q[row][col] == 1)
                return false;
        }

        //判断右下方
        for (int row = i + 1, col = j + 1; row < size && col < size; row++, col++) {
            if (q[row][col] == 1)
                return false;
        }

        //判断右上方
        for (int row = i - 1, col = j + 1; row >= 0 && col < size; row--, col++) {
            if (q[row][col] == 1)
                return false;
        }

        //判断左下方
        for (int row = i + 1, col = j - 1; row < size && col >= 0; row++, col--) {
            if (q[row][col] == 1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        QueensConstraint exam = new QueensConstraint();
        exam.queueByBackTracking(4);
    }

}
