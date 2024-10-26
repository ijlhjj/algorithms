package com.sweetmanor.exams.tree;

import com.sweetmanor.datastructure.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BinaryTreeCompleteTest {

    @Test
    void isCompleteBinaryTree1() {
        List<Integer> nodes = List.of(1, 2, 3, 4, 5, 6);
        BinaryTree<Integer> binaryTree = BinaryTree.createBinaryTree(nodes);
        BinaryTreeComplete exam = new BinaryTreeComplete();
        assertTrue(exam.isCompleteBinaryTree(binaryTree.getRoot()));
    }

    @Test
    void isCompleteBinaryTree2() {
        List<Integer> nodes = new ArrayList<>(List.of(1, 2, 3, 4, 5, -1, 6));
        nodes.set(5, null); //设置空节点

        BinaryTree<Integer> binaryTree = BinaryTree.createBinaryTree(nodes);
        BinaryTreeComplete exam = new BinaryTreeComplete();
        assertFalse(exam.isCompleteBinaryTree(binaryTree.getRoot()));
    }

}
