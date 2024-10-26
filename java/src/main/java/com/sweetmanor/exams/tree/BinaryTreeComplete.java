package com.sweetmanor.exams.tree;

import com.sweetmanor.datastructure.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 算法大爆炸：面试通关步步为营
 * 12.1 完全二叉树的判定
 *
 * <p>
 * 给定一棵二叉树，写一个函数判断它是不是完全二叉树。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-10-10
 */
public class BinaryTreeComplete {

    public boolean isCompleteBinaryTree(BinaryTreeNode<?> node) {
        //如果node为null则表示当前的二叉树为空树，空树也是一种完全二叉树，所以返回true
        if (node == null)
            return true;

        //设置旗标，找到最后一个双亲节点后，后续节点不能再有子节点
        boolean lastParent = false;

        //待访问节点队列，队列不空继续遍历
        Queue<BinaryTreeNode<?>> visit = new LinkedList<>();
        visit.add(node);
        while (!visit.isEmpty()) {
            BinaryTreeNode<?> treeNode = visit.poll();

            //找到空节点，设置旗标
            if (treeNode.getLeftNode() == null) {
                lastParent = true;
            } else {
                //非空子节点，旗标为真时返回false
                if (lastParent)
                    return false;

                visit.add(treeNode.getLeftNode()); //添加当前子节点到队列
            }

            //找到空节点，设置旗标
            if (treeNode.getRightNode() == null) {
                lastParent = true;
            } else {
                //非空子节点，旗标为真时返回false
                if (lastParent)
                    return false;

                visit.add(treeNode.getRightNode()); //添加当前子节点到队列
            }
        }

        //全部遍历完都符合要求，返回true
        return true;
    }

}
