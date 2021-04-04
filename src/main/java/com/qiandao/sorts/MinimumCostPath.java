package com.qiandao.sorts;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class MinimumCostPath {
    /*
     * 一个工具方法，返回3个整数中的最小值
     */
    private static int min(int x, int y, int z) {
        if (x < y) {
            return (x < z) ? x : z;
        } else {
            return (y < z) ? y : z;
        }
    }

    /*
     * 最小成本
     * 输入参数为二维数组，m行，n列
     * */
    private static int minCost(int cost[][]) {
        int m = cost.length, n=cost[0].length;
        int i, j;
        /*
         * 开辟一个dp数组，数组有m+1行；n+1列
         * dp[m][n]表示
         */

        int dp[][] = new int[m][n];

        dp[0][0] = cost[0][0];

        /* Initialize first column of total cost(dp) array */
        for (i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }
        /* Initialize first row of dp array */
        for (j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }
        /* Construct rest of the dp array */

        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + cost[i][j];
            }
        }
        return dp[m-1][n-1];
    }


    public static void main(String args[]) {
        int cost[][] = {
                { 1, 2, 3 },
                { 4, 8, 2 },
                { 1, 5, 3 }
        };
        System.out.println("达到矩阵右下角" + " (2, 2) 的最小成本 = " + minCost(cost));
        for (int k =0;k<cost.length;k++) {
            for (int z = 0; z < cost[k].length; z++) {
                System.out.print(cost[k][z] + " ");
            }
            System.out.println();
        }
        System.out.println();
        minCost2(cost, 2, 2);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length,n=grid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = grid[0][0];
        for (int i=1; i<m; i++) {
            path[i][0] = path[i-1][0] + grid[i][0];   //初始化左边界
        }
        for (int j=1; j<n; j++) {
            path[0][j] = path[0][j-1] + grid[0][j];   //初始化右边界
        }
        for (int i=1; i<m; i++) {
            for (int j=1;j<m;j++) {
                path[i][j] = Math.min(path[i][j-1]+grid[i][j], path[i-1][j]+grid[i][j]);
            }
        }
        return path[m-1][n-1];
    }

    private static void minCost2(int cost[][], int m, int n) {
        int i, j;
        /*
         * 开辟一个dp数组，数组有m+1行；n+1列
         * dp[m][n]表示
         */

        int dp[][] = new int[m + 1][n + 1];

        dp[0][0] = cost[0][0];

        /* Initialize first column of total cost(dp) array */
        for (i = 1; i <= m; i++)
            dp[i][0] = dp[i - 1][0] + cost[i][0];

        /* Initialize first row of dp array */
        for (j = 1; j <= n; j++)
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        for (int k =0;k<dp.length;k++) {
            for (int z = 0; z < dp[k].length; z++) {
                System.out.print(dp[k][z] + " ");
            }
            System.out.println();
        }
    }
}