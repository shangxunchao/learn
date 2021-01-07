package com.qiandao.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/12/25 16:31
 */
public class Tree {
	@Test
	public void demo26(){
		Integer [][] tree=new Integer[7][3];
		tree[0][0]=22;
		tree[0][1]=1;
		tree[0][2]=2;

		tree[1][0]=222;
		tree[1][1]=3;
		tree[1][2]=null;

		tree[2][0]=2222;
		tree[2][1]=4;
		tree[2][2]=5;

		tree[3][0]=22222;
		tree[3][1]=null;
		tree[3][2]=6;

		tree[4][0]=222222;
		tree[4][1]=null;
		tree[4][2]=null;

		tree[5][0]=2222222;
		tree[5][1]=null;
		tree[5][2]=null;

		tree[6][0]=22222222;
		tree[6][1]=null;
		tree[6][2]=null;
      /*  printTreee1(tree,0);
        System.out.println("===================================");
		qinaxuFeiDigui(tree,0);*/
        /*printTreee2(tree,0);
        System.out.println("=======================================");
		zhongxuFeiDigui(tree,0);*/
		printTreee3(tree,0);
		System.out.println("===================================");
		houxuFeiDigui(tree,0);

	}

	private void printTreee1(Integer[][]tree,Integer i){
		if(i==null){
			return;
		}
		System.out.println(tree[i][0]);
		printTreee1(tree,tree[i][1]);
		printTreee1(tree,tree[i][2]);
	}

	// 用非递归的方法进行先序遍历
	private void qinaxuFeiDigui(Integer[][]tree,Integer i) {
		Stack<Integer> stack = new Stack<Integer>();
		while (i != null || !stack.isEmpty()) {
			while (i != null) {
				System.out.println(tree[i][0]);
				stack.push(i);
				i = tree[i][1];
			}
			if(!stack.isEmpty()){
				i = stack.pop();
				i = tree[i][2];
			}
		}
	}

	private void printTreee2(Integer[][]tree,Integer i){
		if(i==null){
			return;
		}
		printTreee2(tree,tree[i][1]);
		System.out.println(tree[i][0]);
		printTreee2(tree,tree[i][2]);
	}

	// 用非递归的方法进行中序遍历
	private void zhongxuFeiDigui(Integer[][]tree,Integer i) {
		Stack<Integer> stack = new Stack<Integer>();
		while (i != null || !stack.isEmpty()) {
			while (i != null) {
				stack.push(i);
				i = tree[i][1];
			}
			if (!stack.isEmpty()) {
				i = stack.pop();
				System.out.println(tree[i][0]);;
				i = tree[i][2];
			}
		}
	}

	private void printTreee3(Integer[][]tree,Integer i){
		if(i==null){
			return;
		}
		printTreee3(tree,tree[i][1]);
		printTreee3(tree,tree[i][2]);
		System.out.println(tree[i][0]);
	}

	// 用非递归的方法进行后序遍历
	private void houxuFeiDigui(Integer[][]tree,Integer i) {
		Stack<Integer> stack = new Stack<Integer>();
		while (i != null || !stack.isEmpty()) {
			while (i != null) {
				stack.push(i);
				i = tree[i][1];
			}
			boolean tag = true;
			// 后继节点
			Integer afterNode = null;
			while (!stack.isEmpty() && tag == true) {
				i = stack.peek();
				// 之前访问的为空节点或是栈顶节点的右子节点
				if (tree[i][2]==null||tree[i][2].equals(afterNode)) {
					i = stack.pop();
					System.out.println(tree[i][0]);
					if (stack.isEmpty()) {
						return;
					} else {
						afterNode = i;
					}
				} else {
					i = tree[i][2];
					tag = false;
				}
			}
		}
	}

	//层次遍历
	private void levelOrder(Integer[][]tree,Integer i){
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(i);
		while(!queue.isEmpty()){
			Integer myTree = queue.poll();
			System.out.println(tree[myTree][0]);
			if(tree[myTree][1] != null){
				queue.offer(tree[myTree][1]);
			}
			if(tree[myTree][2] != null){
				queue.offer(tree[myTree][2]);
			}
		}
	}
}
