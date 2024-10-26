package com.sweetmanor.datastructure;

public class BinaryTree<E> {

    private BinaryTreeNode<E> root;
    private int size;

    /**
     * 根据列表创建二叉树，空节点传 NULL 。 入参应符合按层遍历顺序排列。
     */
    public static <E> BinaryTree<E> createBinaryTree(java.util.List<E> nodes) {
        if (nodes == null || nodes.isEmpty())
            return null;

        if (nodes.get(0) == null)
            return null;

        BinaryTreeNode<E>[] nodeArr = new BinaryTreeNode[nodes.size()];
        nodeArr[0] = new BinaryTreeNode<>(nodes.get(0));
        int size = 1;

        for (int i = 1; i < nodes.size(); i++) {
            if (nodes.get(i) == null)
                continue;

            nodeArr[i] = new BinaryTreeNode<>(nodes.get(i));
            //奇数下标左子节点，偶数右子节点
            if (i % 2 == 1) {
                int index = i / 2;
                if (nodeArr[index] == null)
                    throw new IllegalArgumentException("下标 " + i + " 的父节点为NULL!");
                nodeArr[index].setLeftNode(nodeArr[i]);
            } else {
                int index = i / 2 - 1;
                if (nodeArr[index] == null)
                    throw new IllegalArgumentException("下标 " + i + " 的父节点为NULL!");
                nodeArr[index].setRightNode(nodeArr[i]);
            }
            size++;
        }

        BinaryTree<E> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(nodeArr[0]);
        binaryTree.setSize(size);

        return binaryTree;
    }

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

}
