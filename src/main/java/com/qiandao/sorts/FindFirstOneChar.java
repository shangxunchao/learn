package com.qiandao.sorts;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 返回第一次出现的字符
 */
public class FindFirstOneChar {

    int [] charCount = new int [128];
    Queue<Character> queue = new LinkedList();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (charCount[ch] ++ == 0) {
            queue.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        Character temp;
        char c;
        while ((temp = queue.peek()) != null) {
            c = temp.charValue();
            if (charCount[c] == 1) {
                return c;
            } else {
                queue.remove();
            }
        }
        return '#';
    }
}
