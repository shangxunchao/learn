package com.qiandao.sorts;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class TopKHeight {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1);
        System.out.println(JSONObject.toJSONString(topKFrequent(new int []{5,2,2,5,5,3}, 2)));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //PriorityQueue<Integer> pq = new PriorityQueue(Comparator.comparingInt(map::get));
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                return map.get(a) - map.get(b);
            }
        });
        for (int key : map.keySet())
        {
            if (pq.size() < k) {
                pq.add(key);
            }
            else if (map.get(key) > map.get(pq.peek()))
            {
                pq.remove();
                pq.add(key);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty())
        {
            res.add(pq.remove());
        }
        return res;
    }
}
