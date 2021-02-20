/*
 * Copyright (C) 2021 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao.sorts2;

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
				if (cur.right != null)
					stack.push(cur.right);
				if (cur.left != null)
					stack.push(cur.left);
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
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
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

	public static void main(String[] args) {
		TreeSort treeSort = new TreeSort();
		treeSort.inOrderTraverse(root);
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
}