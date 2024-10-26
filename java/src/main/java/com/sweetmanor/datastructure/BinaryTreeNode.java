package com.sweetmanor.datastructure;

public class BinaryTreeNode<E> {

    private E ele;
    private BinaryTreeNode<E> leftNode;
    private BinaryTreeNode<E> rightNode;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(E ele) {
        this.ele = ele;
    }

    public BinaryTreeNode(E ele, BinaryTreeNode<E> leftNode, BinaryTreeNode<E> rightNode) {
        this.ele = ele;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public E getEle() {
        return ele;
    }

    public void setEle(E ele) {
        this.ele = ele;
    }

    public BinaryTreeNode<E> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode<E> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "ele=" + ele +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }

}
