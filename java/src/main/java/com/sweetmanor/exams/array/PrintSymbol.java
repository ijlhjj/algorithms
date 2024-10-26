package com.sweetmanor.exams.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例1-7：打印符号三角形
 *
 * <p>
 * 该符号三角形的特点是：仅由“+”和“-”这两种符号构成；同号下面是“+”，异号下面是“-”。
 * 编写一个程序，输入任意符号三角形的第1行，打印出符合规则的符号三角形。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-17
 */
public class PrintSymbol {

    public static void printCharacterTriangle(String firstLine) {
        //定义存储当前处理行字符列表
        List<Character> currLine = new ArrayList<>();
        for (char c : firstLine.toCharArray())
            currLine.add(c);

        //定义 i 控制打印时前置空格
        for (int i = 0; !currLine.isEmpty(); i++) {
            printLine(currLine, i); //打印当前行

            //循环当前行计算下行的元素值
            List<Character> nextLine = new ArrayList<>();
            for (int j = 0; j < currLine.size() - 1; j++) {
                if (Objects.equals(currLine.get(j), currLine.get(j + 1))) {
                    nextLine.add('+'); //相同
                } else {
                    nextLine.add('-'); //不同
                }
            }

            currLine = nextLine; //更新处理行
        }
    }

    /**
     * 单行打印方法
     */
    public static void printLine(List<Character> line, int space) {
        System.out.print("  ".repeat(space)); //前置空格
        for (Character c : line)
            System.out.print(c + "   "); //每个字符间隔4空格
        System.out.println(); //最后加一个换行
    }

    public static void main(String[] args) {
        printCharacterTriangle("++-+-++");
    }

}
