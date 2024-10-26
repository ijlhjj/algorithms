package com.sweetmanor.exams.tree;

import com.sweetmanor.datastructure.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeCountLeafTest {

    @Test
    void getBinaryTreeLeavesNumber() {
        List<Integer> nodes = List.of(2, 3, 6, 5, 0, 7);
        BinaryTree<Integer> binaryTree = BinaryTree.createBinaryTree(nodes);
        BinaryTreeCountLeaf exam = new BinaryTreeCountLeaf();
        assertEquals(3, exam.getBinaryTreeLeavesNumber(binaryTree.getRoot()));
    }

}
