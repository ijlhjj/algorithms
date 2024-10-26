package com.sweetmanor.exams.dynamic;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例8-1：机器人的不同路径
 *
 * <p>
 * 一个机器人位于一个m×n网格的左上角。已知机器人每次只能向下或者向右移动一步，机器人试图达到网格的右下角，请问一共有多少条不同的路径？
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-16
 */
public class RobotMovePaths {

    /**
     * 因为机器人每次只能向下或者向右移动一步，所以从点(starti，startj)出发，下一步可能走到(starti+1，startj)（向下移动一步），也可能走到(starti，startj+1)（向右移动一步）。
     * 可以将从起点到终点的路径数表示为两部分之和，即从(starti+1，startj)到(endi，endj)的路径数与从(starti，startj+1)到(endi，endj)的路径数之和。
     */
    public int getPathsNumber1(int starti, int startj, int endi, int endj) {
        //达到终点
        if (starti == endi && startj == endj)
            return 1;

        //超出边界
        if (starti > endi || startj > endj)
            return 0;

        //递归计算 向下 和 向右 的和
        return getPathsNumber1(starti + 1, startj, endi, endj) + getPathsNumber1(starti, startj + 1, endi, endj);
    }

    /**
     * 使用矩阵替代上述递归。
     * 最后一行 和 最后一列 上的每个元素都赋值为 1
     * matrix[i][j] = matrix[i+1][j] + matrix[i][j+1]
     */
    public int getPathsNumber2(int endi, int endj) {
        int[][] matrix = new int[endi + 1][endj + 1];

        //初始化 matrix 最后一行 和 最后一列 为 1
        for (int j = 0; j <= endj; j++) {
            matrix[endi][j] = 1;
        }

        for (int i = 0; i <= endi; i++) {
            matrix[i][endj] = 1;
        }

        //逐行倒推矩阵值
        for (int i = endi - 1; i >= 0; i--) {
            for (int j = endj - 1; j >= 0; j--)
                matrix[i][j] = matrix[i + 1][j] + matrix[i][j + 1];
        }

        return matrix[0][0]; //返回矩阵左上角值
    }

}
