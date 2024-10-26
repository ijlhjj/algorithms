package com.sweetmanor.exams.tree;

import com.sweetmanor.datastructure.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeDepthTest {

    @Test
    void getBinaryTreeDepth() {
        List<Integer> nodes = List.of(2, 3, 6, 5, 0, 7);
        BinaryTree<Integer> binaryTree = BinaryTree.createBinaryTree(nodes);
        BinaryTreeDepth exam = new BinaryTreeDepth();
        assertEquals(3, exam.getBinaryTreeDepth(binaryTree.getRoot()));
    }

}
