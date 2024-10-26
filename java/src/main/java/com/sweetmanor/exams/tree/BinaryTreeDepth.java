package com.sweetmanor.exams.tree;

import com.sweetmanor.datastructure.BinaryTreeNode;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例2-1：计算二叉树的深度
 *
 * <p>
 * 编写一个程序，计算二叉树的深度。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-18
 */
public class BinaryTreeDepth {

    /**
     * 先序递归遍历
     */
    private int preVisit(BinaryTreeNode<Integer> node) {
        if (node == null)
            return 0;

        int leftDepth = 1 + preVisit(node.getLeftNode());
        int rightDepth = 1 + preVisit(node.getRightNode());

        return Math.max(leftDepth, rightDepth);
    }

    public int getBinaryTreeDepth(BinaryTreeNode<Integer> root) {
        return preVisit(root);
    }

}
