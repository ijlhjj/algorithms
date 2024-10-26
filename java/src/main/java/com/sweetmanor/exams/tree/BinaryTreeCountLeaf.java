package com.sweetmanor.exams.tree;

import com.sweetmanor.datastructure.BinaryTreeNode;

/**
 * 算法大爆炸：面试通关步步为营
 * 案例2-2：计算二叉树中叶子节点的数量
 *
 * <p>
 * 编写一个算法，计算二叉树中叶子节点的数量。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-08-18
 */
public class BinaryTreeCountLeaf {

    private int count;

    /**
     * 先序递归遍历
     */
    private void preVisit(BinaryTreeNode<Integer> node) {
        if (node == null)
            return;

        //没有左、右子节点的为叶子节点
        if (node.getLeftNode() == null && node.getRightNode() == null)
            count++;

        preVisit(node.getLeftNode());
        preVisit(node.getRightNode());
    }

    public int getBinaryTreeLeavesNumber(BinaryTreeNode<Integer> root) {
        count = 0;
        preVisit(root);
        return count;
    }

}
