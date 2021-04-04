package com.qiandao.sorts.add;

import java.util.ArrayList;

public class PrintMatrix {

    /**
     * 从外到里输出矩阵
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList();
        }
        int up = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        ArrayList<Integer> result = new ArrayList((right + 1) * (left + 1));
        while(true) {
            for (int col = left; col <= right ; col++) {
                result.add(matrix[up][col]);
            }
            up ++;
            if (up > down) {
                break;
            }
            for (int row = up; row <= down; row++) {
                result.add(matrix[row][right]);
            }
            right --;
            if (left > right) {
                break;
            }
            for (int col = right; col >= left; col--) {
                result.add(matrix[down][col]);
            }
            down--;
            if (up > down) {
                break;
            }
            for (int row = down; row >= up; row--) {
                result.add(matrix[row][left]);
            }
            left ++;
            if(left > right){
                break;
            }
        }
        return result;
    }
}
