/*
 * Copyright (C) 2020 VIPKID, Inc. All Rights Reserved.
 */
package com.qiandao;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <p>TODO
 * </p>
 *
 * @author shangxunchao
 * @date 2020/12/22 10:59
 **/
public class DemoMain {

    private static final Pattern PATTERN = Pattern.compile("_selector_\\.([a-z]+)\\.([a-z]+)\\.(\\S+)");
    private static final Pattern CONFIG_PATTERN = Pattern.compile("(?<=ha=)(\\([^=()]+=[^=()]+\\))+");
    private static final Pattern KV_PATTEN = Pattern.compile("\\((?<key>[^=()]+)=(?<value>[^=()]+)\\)");

    public static void maizn(String[] args) throws UnsupportedEncodingException {
        System.out.println(DemoMain.class.getCanonicalName());
        StringBuilder sb = new StringBuilder("UnsupportedEncodingException");
        System.out.println(sb.reverse());
        try {
            //new URL("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("12", 12);
        }};
        new String("");
        Integer te = map.putIfAbsent("123", 56);
        System.out.println(te);
        System.out.println(map.putIfAbsent("123", 567));
        System.out.println(map.get("123"));
        System.out.println(map.put("1245", 564));
        System.out.println(JSON.toJSONString("a||b||c".split("\\|\\|")));
        System.out.println(JSON.toJSONString(getConfigParams("(url=http://internal.vkredis-api.vipkid.com.cn)(idc=ALIYUN),(url=http://vkredis-api.ten-internal.vipkid.com.cn)(idc=TEN),ha=(failover=true)(failfast=false)(retryCount=3)(retryInterval=1000)(healthCheckInterval=10000)")));
    }

    private static void print() {
        Matcher matcher = PATTERN.matcher("_selector_.pre.default.vkschedule.server.cluster.nodes");
        System.out.println(matcher.group(3));
    }

    public static Map<String, String> getConfigParams(final String url) {
        final Matcher configMatcher = CONFIG_PATTERN.matcher(url);

        if (!configMatcher.find()) {
            return new HashMap<>();
        }

        final String config = configMatcher.group(0);
        final Matcher kvMatcher = KV_PATTEN.matcher(config);

        final Map<String, String> params = new HashMap<>();
        while (kvMatcher.find()) {
            params.put(kvMatcher.group("key"), kvMatcher.group("value"));
        }
        return params;
    }

    @Test
    public void demo() {

        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
        }};
        Map<String, ?> map = new HashMap<String, String>() {{
            put("12", "34");
            put("56", "78");
        }};
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
        C c = new C();
        c.setBTest((B) (f, q) -> {
            return f + q;
        });
        String re = "(1)";
        System.out.println(isValid("()[]{}"));
    }

    interface A {

    }

    interface B extends A {
        Integer addTest(Integer a, Integer b);
    }

    class C {
        private B b;

        public void setBTest(B b) {
            this.b = b;
        }
    }

    public boolean isValid2(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (Objects.equals(s.charAt(i), '[') || Objects.equals(s.charAt(i), '{') || Objects.equals(s.charAt(i), '(')) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (Objects.equals(s.charAt(i), '[')) {
                        if (Objects.equals(s.charAt(j), ']')) {
                            break;
                        }
                        if (Objects.equals(s.charAt(j), '(')) {
                            return isValid(s.substring(j));
                        }
                        if (Objects.equals(s.charAt(j), '{')) {
                            return isValid(s.substring(j));
                        }
                        if (Objects.equals(s.charAt(j), '}') || Objects.equals(s.charAt(j), ')')) {
                            return false;
                        }
                    }
                    if (Objects.equals(s.charAt(i), '{')) {
                        if (Objects.equals(s.charAt(j), '}')) {
                            break;
                        }
                        if (Objects.equals(s.charAt(j), '(')) {
                            return isValid(s.substring(j));
                        }
                        if (Objects.equals(s.charAt(j), '[')) {
                            return isValid(s.substring(j));
                        }
                        if (Objects.equals(s.charAt(j), ']') || Objects.equals(s.charAt(j), ')')) {
                            return false;
                        }
                    }
                    if (Objects.equals(s.charAt(i), '(')) {
                        if (Objects.equals(s.charAt(j), ')')) {
                            break;
                        }
                        if (Objects.equals(s.charAt(j), '[')) {
                            return isValid(s.substring(j));
                        }
                        if (Objects.equals(s.charAt(j), '{')) {
                            return isValid(s.substring(j));
                        }
                        if (Objects.equals(s.charAt(j), ']') || Objects.equals(s.charAt(j), '}')) {
                            return false;
                        }
                    }
                    if (j == s.length() - 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        StringBuilder sb;
        StringBuilder sb2;
        String result = "";
        for (int max = 2; max < s.length(); max++) {
            for (int i = 0; i < s.length() && i + max - 1 < s.length(); i++) {
                int end = i + max - 1;
                int j = i;
                int num = 1;
                sb = new StringBuilder();
                sb2 = new StringBuilder();
                while (j < (max) / 2) {
                    if (Objects.equals(s.charAt(j), s.charAt(end - num))) {
                        sb.append(s.charAt(j));
                        sb2.append(s.charAt(end - num));
                        num++;
                        j++;
                    } else {
                        break;
                    }
                }
                if (j == ((max) / 2) && (max) % 2 > 0) {
                    sb.append(s.charAt(j));
                }
                if (j == ((max) / 2)) {
                    if (result.length() < sb.toString().length() + sb2.toString().length())
                        result = sb.append(sb2).toString();
                }
            }
        }
        return result;
    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        boolean[][] memory = new boolean[sLen + 1][pLen + 1];
        memory[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    memory[i][j] = memory[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) ||
                            p.charAt(j - 2) == '.') && memory[i - 1][j]);
                } else {
                    memory[i][j] = i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            && memory[i - 1][j - 1];
                }
            }
        }
        return memory[sLen][pLen];
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Integer i = 0;
        HashSet<String> stringHashSet = new HashSet<>();
        for (; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((nums[i] + nums[j] + nums[k] == 0)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        String sorts = temp.stream().map(e -> e.toString()).sorted(String::compareTo).collect(Collectors.joining(","));
                        if (!stringHashSet.contains(sorts)) {
                            result.add(temp);
                            stringHashSet.add(sorts);
                        }
                    }
                }
            }
        }
        return result;
    }


}