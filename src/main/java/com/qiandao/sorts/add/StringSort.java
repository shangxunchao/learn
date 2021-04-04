package com.qiandao.sorts.add;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class StringSort {

    /**
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        TreeSet<String> result = new TreeSet();
        perm(0, new StringBuilder(str), result);
        return new ArrayList<>(result);
    }

    public void perm(int pos, StringBuilder s, TreeSet<String> result) {
        if (pos + 1 == s.length()) {
            result.add(s.toString());
            return;
        }
        for (int i = pos; i < s.length(); ++i) {
            swap(s, pos, i);
            perm(pos + 1, s, result);
            swap(s, pos, i);
        }
    }
    public void swap (StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    /**
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n > str.length()) {
            return str;
        }
        return str.substring(n) + str.substring(0, n);
    }

    /**
     * 把句子单词的顺序翻转了.“student. a am I”->“I am a student.”
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        String [] strs = str.split(" ");
        if (strs == null || strs.length == 0) {
            return str;
        }
        StringBuffer result = new StringBuffer(strs[strs.length - 1]);
        for (int i = strs.length - 2; i >= 0; i--) {
            result.append(" ").append(strs[i]);
        }
        return result.toString();
    }
}
