package com.sweetmanor.exams.tree;

import com.sweetmanor.datastructure.BinaryTreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeMaxDistanceTest {

    @Test
    void getMaxDistance() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> node8 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> node9 = new BinaryTreeNode<>(9);

        root.setLeftNode(node2);
        node2.setLeftNode(node3);
        node3.setLeftNode(node4);
        node4.setLeftNode(node5);
        node7.setLeftNode(node8);

        root.setRightNode(node9);
        node2.setRightNode(node6);
        node6.setRightNode(node7);

        BinaryTreeMaxDistance exam = new BinaryTreeMaxDistance();
        assertEquals(6, exam.getMaxDistance(root));
    }

}
