/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.sorts.add;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <p>TODO
 * </p>
 * <href>https://www.cnblogs.com/zhi-leaf/p/10813048.html</href>
 *
 * @author shangxunchao
 * @date 2021/2/20 16:12
 **/
public class TreeSort {

    /**
     * 前序遍历
     * 访问顺序：先根节点，再左子树，最后右子树；
     * 递归实现
     *
     * @param root
     */
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + "->");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    /**
     * 前序遍历
     * 访问顺序：先根节点，再左子树，最后右子树；
     * 非递归实现
     *
     * @param root
     */
    public void preOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.print(node.val + "->");
                stack.push(node);
                //node.left.val = "1";
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                node = tem.right;
            }
        }
    }

    /***
     * 中序遍历
     * 访问顺序：先左子树，再根节点，最后右子树
     * 递归实现
     * @param root
     */
    public void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.val + "->");
            inOrderTraverse(root.right);
        }
    }

    /***
     * 中序遍历
     * 访问顺序：先左子树，再根节点，最后右子树
     * 非递归实现
     * @param root
     */
    public void inOrderTraverse2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode tem = stack.pop();
                System.out.print(tem.val + "->");
                node = tem.right;
            }
        }
    }

    /**
     * 后序遍历
     * 访问顺序：先左子树，再右子树，最后根节点
     * 递归实现
     *
     * @param root
     */
    public void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val + "->");
        }
    }

    /**
     * 后序遍历
     * 访问顺序：先左子树，再右子树，最后根节点
     * 非递归实现
     *
     * @param root
     */
    public void postOrderTraverse2(TreeNode root) {
        TreeNode cur, pre = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.print(cur.val + "->");
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    public void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "->");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 按照之字形打印二叉树，
     * 即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，
     * 其他行以此类推。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print (TreeNode2 pRoot) {
        ArrayList<ArrayList<Integer> > result = new ArrayList();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode2> queue = new LinkedList();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode2 node = queue.poll();
                if (node == null) {
                    continue;
                }
                if (!reverse) {
                    list.add(node.val);
                } else {
                    list.add(0, node.val);//每次加到0的位置，就自动逆序了
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() > 0) {
                result.add(list);
            }
            reverse = !reverse;
        }
        return result;
    }

    /**
     * 树的深度
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = TreeDepth(root.left);
        int rightHeight = TreeDepth(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    /**
     * 打印出二叉树中结点值的和为输入整数的所有路径。
     * @param root
     * @param target
     * @return
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode2 root, int target) {
        if (root == null) {
            return result;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return result;
    }

    /**
     * 二叉树镜像
     * @param pRoot
     * @return
     */
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return pRoot;
        }
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }

    /**
     * 是否后序遍历结果
     * @param sequence
     * @return
     */
    public boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return helpVerify(sequence, 0, sequence.length - 1);
    }

    public boolean helpVerify(int [] sequence, int start, int root) {
        if (start >= root) {
            return true;
        }
        int key = sequence[root];
        int i;
        for (i = 0; i < root; i++) {
            if (sequence[i] > key) {
                break;
            }
        }
        for (int j = i; j < root; j ++) {
            if (sequence[j] < key) {
                return false;
            }
        }
        return helpVerify(sequence, start, i - 1) && helpVerify(sequence, i, root -1);
    }

    /**
     * 将该二叉搜索树转换成一个排序的双向链表
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList();
        Convert(pRootOfTree, list);
        return Convert(list);
    }
    //中序遍历，在list中按遍历顺序保存
    public void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list) {
        if (pRootOfTree.left != null) {
            Convert(pRootOfTree.left, list);
        }
        list.add(pRootOfTree);
        if (pRootOfTree.right != null) {
            Convert(pRootOfTree.right, list);
        }
    }
    //遍历list，修改指针
    public synchronized TreeNode Convert(ArrayList<TreeNode> list) {
        for (int i = 0; i< list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);
    }

    /**
     * 判断该二叉树是否是平衡二叉树,
     * 只考虑平衡性，不考虑其是不是排序二叉树
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：
     * 它是一棵空树或
     * 它的左右两个子树的高度差的绝对值不超过1，
     * 并且左右两个子树都是一棵平衡二叉树。
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root) != -1;
    }

    public int depth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if (right == -1) {
            return -1;
        }
        if (right - left < -1 || right - left > 1) {
            return -1;
        } else {
            return right > left ? right + 1 : left + 1;
        }
    }

    public static void main(String[] args) {
        TreeSort treeSort = new TreeSort();
        treeSort.inOrderTraverse(root);
        System.out.println("======================");
        treeSort.postOrderTraverse2(root);
    }

    private static TreeNode root;

    static {
        root = new TreeNode("G");
        TreeNode D = new TreeNode("D");
        TreeNode M = new TreeNode("M");
        root.left = D;
        root.right = M;
        TreeNode A = new TreeNode("A");
        TreeNode F = new TreeNode("F");
        D.left = A;
        D.right = F;
        TreeNode H = new TreeNode("H");
        TreeNode Z = new TreeNode("Z");
        M.left = H;
        M.right = Z;
        TreeNode E = new TreeNode("E");
        F.left = E;
    }

    static class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }
    }

    static class TreeNode2 {
        Integer val;
        TreeNode2 left;
        TreeNode2 right;

        public TreeNode2(Integer val) {
            this.val = val;
        }
    }
}