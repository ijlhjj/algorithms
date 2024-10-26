package com.sweetmanor.exams.tree;

import com.sweetmanor.datastructure.BinaryTreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 算法大爆炸：面试通关步步为营
 * 12.2 二叉树节点的最大距离
 *
 * <p>
 * 编写一个程序，计算一棵二叉树中距离最远的两个节点之间的距离。
 * 二叉树节点的距离指两节点之间的边数。
 * </p>
 *
 * @author ijlhjj
 * @version 1.0 2024-10-11
 */
public class BinaryTreeMaxDistance {

    //后续遍历二叉树
    private void postorder(Map<BinaryTreeNode<Integer>, int[]> nodesMap, BinaryTreeNode<Integer> node) {
        //基准条件
        if (node == null)
            return;

        BinaryTreeNode<Integer> leftNode = node.getLeftNode();
        BinaryTreeNode<Integer> rightNode = node.getRightNode();

        postorder(nodesMap, leftNode); //遍历左子树
        postorder(nodesMap, rightNode); //遍历右子树

        //当前节点值
        int deep = 0;
        int distance = 0;

        if (leftNode != null && rightNode != null) {//有左右子树
            int[] valLeft = nodesMap.get(leftNode);
            int[] valRight = nodesMap.get(rightNode);

            //当前节点深度为左右子树中 较大者+1
            deep = Math.max(valLeft[0], valRight[0]) + 1;

            //距离为 左子树距离、右子树距离 和 当前节点左右子树距离中较大者
            distance = Math.max(valLeft[1], valRight[1]);
            int sumDistance = valLeft[0] + valRight[0] + 2;
            distance = Math.max(distance, sumDistance);
        } else if (leftNode != null) { //只有左子树
            int[] vals = nodesMap.get(leftNode);
            deep = vals[0] + 1;
            distance = Math.max(deep, vals[1]);
        } else if (rightNode != null) { //只有右子树
            int[] vals = nodesMap.get(rightNode);
            deep = vals[0] + 1;
            distance = Math.max(deep, vals[1]);
        }

        nodesMap.put(node, new int[]{deep, distance}); //当前节点属性放入映射
    }

    public int getMaxDistance(BinaryTreeNode<Integer> node) {
        if (node == null)
            return 0;

        //后序遍历处理节点距离
        Map<BinaryTreeNode<Integer>, int[]> nodesMap = new HashMap<>();
        postorder(nodesMap, node);

        //查找节点最大距离
        int maxDistance = 0;
        for (int[] vals : nodesMap.values()) {
            if (vals[1] > maxDistance)
                maxDistance = vals[1];
        }
        return maxDistance;
    }

}
