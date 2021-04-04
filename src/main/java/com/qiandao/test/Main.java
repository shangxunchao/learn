package com.qiandao.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qiandao.constant.VipkidOrg;
import com.qiandao.enums.IconUrl;
import com.qiandao.model.Student;
import com.qiandao.model.SysConfigPackageIdAndProductId;
import com.qiandao.single.instance.Toy;
import com.qiandao.util.id.IdWorker;
import com.sun.deploy.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        List<String> mum = new ArrayList<String>();
        for (int i = 1; i < 11; i++)
            mum.add(i + "");
        for (int i = 0; i < mum.size(); i++) {
            if (Integer.parseInt(mum.get(i)) % 2 == 0) {
                mum.remove(i);
                i--;
            } else {
                System.out.print(mum.get(i) + " ");
            }
        }
        System.out.println("===========");
        for (int i = 0;
             i < mum.size(); i++) {
            System.out.println(mum.get(i) + " ");
        }
    }

    @Test
    public void demo() {
        List<String> mum = new ArrayList<String>();
        for (int i = 1; i < 11; i++) {
            mum.add(i + "");
        }
        Iterator<String> iterator = mum.iterator();
        while (iterator.hasNext()) {
            String te = iterator.next();
            if (Integer.parseInt(te) % 2 == 0) {
                iterator.remove();
            } else {
                System.out.print(te + " ");
            }
        }

        System.out.println("===");
        for (int i = 0; i < mum.size(); i++) {
            System.out.print(mum.get(i) + " ");
        }
    }

    @Test
    public void demo2() {
        int n1 = 0;
        int n2 = 1;
        int n = 0;
        int num = 0;
        while (n2 + n1 < 1000) {

            n = n2 + n1;
            if (num % 10 == 0 && num > 0) {
                System.out.println();
                System.out.print(n + " ");
            } else {
                System.out.print(n + " ");
            }
            n1 = n2;
            n2 = n;
            num++;

        }
        System.out.println("====num:" + num);
    }


    public static void asd() {

        log.error("不存在该产品信息，支付成功通知失败。groupPurchase={}");
    }

    @Test
    public void asdd() {

        int[] array2 = new int[]{1, 2, 3};
        List<int[]> list2 = Arrays.asList(array2);
        System.out.println("len:" + list2.size());
        Iterator<int[]> ite = list2.iterator();
        while (ite.hasNext()) {
            System.out.println(ite.next());
        }
        System.out.println(list2);
    }

    @Test
    public void demo5() {
        try {
            System.out.println(1);
            throw new Error();
        } catch (Exception e) {
            System.out.println(2);
        } finally {
            System.out.println(3);
        }
        return;
    }

    @Test
    public void demo6() {
        String temp = "123*456";
        List<SysConfigPackageIdAndProductId> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            SysConfigPackageIdAndProductId ap = new SysConfigPackageIdAndProductId();
            ap.setId(Long.valueOf(i));
            list.add(ap);
        }
        String[] t = temp.split("\\*");
        for (SysConfigPackageIdAndProductId te : list) {
            System.out.println(te.getId());
        }
    }

    List<String> wordList;

    @Before
    public void init() {
        wordList = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
                add("d");
                add("e");
                add("f");
                add("g");
            }
        };
    }

    /**
     * 延迟执行特性，在聚合操作之前都可以添加相应元素
     */
    @Test
    public void test() {
        Stream<String> words = wordList.stream();
        wordList.add("END");
        long n = words.distinct().count();
        System.out.println(n);
    }

    /**
     * 延迟执行特性，会产生干扰
     * nullPointException
     */
    @Test
    public void test2() {
        Stream<String> words1 = wordList.stream();
        words1.forEach(s -> {
            System.out.println("s->" + s);
            if (s.length() < 4) {
                System.out.println("select->" + s);
                wordList.remove(s);
                System.out.println(wordList);
            }
        });
    }

    /**
     * 产生规律的数据
     */
    @Test
    public void testUnlimitStream1() {
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::print);
        System.out.println();
        Stream.iterate(0, x -> x).limit(10).forEach(System.out::print);
        System.out.println();
        //Stream.iterate(0,x->x).limit(10).forEach(System.out::println);与如下代码意思是一样的
        Stream.iterate(0, UnaryOperator.identity()).limit(10).forEach(System.out::print);
    }

    @Test
    public void testFlapMap1() {
        String[] arr1 = {"a", "b", "c", "d"};
        String[] arr2 = {"e", "f", "c", "d"};
        String[] arr3 = {"h", "j", "c", "d"};
        // Stream.of(arr1, arr2, arr3).flatMap(x -> Arrays.stream(x)).forEach(System.out::println);
        Stream.of(arr1, arr2, arr3).flatMap(Arrays::stream).forEach(System.out::print);
    }

    @Test
    public void testOptional() {
        List<String> list = new ArrayList<String>() {
            {
                add("user1");
                add("user2");
            }
        };
        Optional<String> opt = Optional.of("");
        opt.ifPresent(list::add);
        list.forEach(System.out::println);
    }

    @Test
    public void testOptional2() {
        Integer[] arr = new Integer[]{4, 5, 6, 7, 8, 9};
        Integer result = Stream.of(arr).filter(x -> x > 9).max(Comparator.naturalOrder()).orElse(-1);
        System.out.println(result);
        Integer result1 = Stream.of(arr).filter(x -> x > 9).max(Comparator.naturalOrder()).orElseGet(() -> -1);
        System.out.println(result1);
        Integer result2 = Stream.of(arr).filter(x -> x > 9).max(Comparator.naturalOrder()).orElseThrow(RuntimeException::new);
        System.out.println(result2);
    }

    @Test
    public void testNumber() {
        System.out.println("取模" + Math.floorMod(4, 2));
        System.out.println("求余" + 4 % 2);
    }

    @Test
    public void stringDemo() {
        String te = String.format("qc-group:memberGroupCreatedId:%s", 2);
        System.out.println(te);
    }

    @Test
    public void idDemo() {
        IdWorker idWorker = new IdWorker();
        System.out.println(idWorker.nextId());
    }

    @Test
    public void enumDemo() {
        Toy toy = Toy.SOLDIER;
        System.out.println(Toy.SOLDIER);
        if (toy.equals(Toy.SOLDIER)) {
            Toy.SOLDIER.execute();
        } else if ("DOLL".equals(Toy.DOLL)) {
            Toy.DOLL.execute();
        } else {
            System.out.println("else");
        }
    }

    @Test
    public void adf() {

        List<String> aASDs = new ArrayList<String>() {{
            add("1");
            add("2");
        }};
        System.out.println("as==:" + String.format("type not in (%s)", StringUtils.join(aASDs, ",")));

    }

    @Test
    public void demo9() {

        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        System.out.println(time.plusDays(7));
    }

    @Test
    public void demo10() {

        List<Student> sds = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student sd = new Student();
            sd.setName(i + "");
            sd.setScore(i + 1);
            sd.setId(Long.valueOf(i + 1));
            sds.add(sd);
        }
        List<Long> list = new ArrayList<Long>() {{
            add(1L);
            add(2L);
            add(3L);
        }};
        sds = sds.stream().filter(sp -> {
            if (list.contains(sp.getId())) {
                return false;
            }
            return true;
        }).collect(Collectors.toList());

        System.out.println(JSON.toJSON(sds));
    }

    @Test
    public void demo11() {
        try {
            System.out.println("try");
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("end");
        }
    }

    @Test
    public void demo12() {

        Student sd = new Student();
        for (int i = 0; i < 3; i++) {
            sd.setName(i + "");
            sd.setScore(i + 1);
            sd.setId(Long.valueOf(i + 1));
            System.out.println(JSON.toJSON(sd));
        }
    }

    @Test
    public void demo13() {

        List<Student> sds = new ArrayList<Student>();
        for (int i = 0; i < 10; i++) {
            Student sd = new Student();
            sd.setName(i + "");
            sd.setScore(i + 1);
            sd.setId(Long.valueOf(i + 1));
            sds.add(sd);
        }
        Iterator<Student> iterator = sds.iterator();
        while (iterator.hasNext()) {
            Student st = iterator.next();
            if (st.getId() % 2 == 0) {
                System.out.println(st.getId());
                iterator.remove();
            } else {
                st.setId(st.getId() + 10);
            }
        }

        System.out.println(JSON.toJSON(sds));
        System.out.println("result==" + sds.size());
    }

    @Test
    public void demo14() {
        LocalDateTime date = LocalDateTime.parse("2017-03-03T12:30:30");
        System.out.println(date);
        LocalDateTime date1 = LocalDateTime.parse("2017-03-03T12:30:30");
        System.out.println(date1);
        System.out.println(date1.compareTo(date));
    }

    @Test
    public void demo15() {
        //Long datas=18446744073709551615;
        System.out.println(Main.valueOf(true));
    }

    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }

    private static final ThreadLocal<Student> ENTRY_STACK = new ThreadLocal<Student>();

    @Test
    public void demo16() {
        if (ENTRY_STACK != null) {
            System.out.println(1);
            ENTRY_STACK.remove();
        }
        ENTRY_STACK.set(null);
        if (ENTRY_STACK == null) {
            ENTRY_STACK.remove();
            System.out.println(2);
        }
    }

    @Test
    public void demo17() {
        List<Student> list = new ArrayList<>();
        Student st = new Student();
        st.setName("12");
        list.add(st);
        st.setName("34");
        list.add(st);
        for (Student s : list) {
            System.out.println(s.getName());
        }
        System.out.println("time:" + LocalTime.of(0, 0, 0));
        System.out.println(JSON.toJSONString(list) + "\nsize:" + list.size());
    }

    @Test
    public void demo18() {
        System.out.println(new BigDecimal(1000).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_DOWN));
        Integer i = 2;
        System.out.println(i instanceof Integer);
    }

    @Test
    public void demo19() {
        List<Student> list = new ArrayList<>();
        Student st = new Student();
        st.setName("12");
        list.add(st);
        st = new Student();
        st.setName("34");
        list.add(st);
        Integer i = 2;
        list.remove(i);
        System.out.println(JSON.toJSONString(list) + "\nsize:" + list.size());
        list.remove(i - 1);
        System.out.println(JSON.toJSONString(list) + "\nsize:" + list.size());
    }

    @Test
    public void demo20() {
        JSONObject eventJson = new JSONObject();
        Student st = new Student();
        st.setName("12");
        eventJson.put("st1", st);
        st = new Student();
        st.setName("34");
        eventJson.put("st2", st);
        System.out.println(JSON.toJSONString(eventJson));
    }

    @Test
    public void demo21() {
        String temp = "tets";
        System.out.println(temp.concat(":"));
    }

    @Test
    public void demo22() {
        long l = TimeUnit.NANOSECONDS.convert(30 * 60 * 1000, TimeUnit.MILLISECONDS) + System.nanoTime();
        long ll = TimeUnit.NANOSECONDS.convert(30 * 60 * 1000, TimeUnit.MILLISECONDS);
        System.out.println(l);
        System.out.println(ll);
    }

    @Test
    public void demo23() {
        int size = 3;
        for (int i = 0; i < size; i++) {
            System.out.println(new Random().nextInt(size));
        }
    }

    @Test
    public void demo24() {
        List<Integer> list = new ArrayList<>(5);
        System.out.println("size:" + list.size());
        System.out.println(findMax(a, 5));
    }

    int a[] = {0, 1, 2, 5, 6};

    int findMax(int a[], int n) {

        int m;
        if (n <= 1)
            return a[0];
        else {
            m = findMax(a, n - 1);
            return a[n - 1] >= m ? a[n - 1] : m;//找到最大值
        }
    }

    @Test
    public void demo25() {
        int[][] temp = new int[10][10];
        create(temp);
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print(temp[i][j] + " ");
            }
        }
        System.out.println();
        System.out.print("=====================");
        int[][] temp2 = changeTemp(temp);
        for (int i = 0; i < 10; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print(temp2[i][j] + " ");
            }
        }
    }

    private int[][] create(int[][] temp) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int tempNumber = new Random().nextInt(2);
                temp[i][j] = tempNumber;
            }
        }
        return temp;
    }

    private int[][] changeTemp(int[][] temp) {
        int[][] temp2 = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                temp2[i][j] = temp[j][i];
            }
        }
        return temp2;
    }

    @Test
    public void demo26() {
        Integer[][] tree = new Integer[7][3];
        tree[0][0] = 22;
        tree[0][1] = 1;
        tree[0][2] = 2;

        tree[1][0] = 222;
        tree[1][1] = 3;
        tree[1][2] = null;

        tree[2][0] = 2222;
        tree[2][1] = 4;
        tree[2][2] = 5;

        tree[3][0] = 22222;
        tree[3][1] = null;
        tree[3][2] = 6;

        tree[4][0] = 222222;
        tree[4][1] = null;
        tree[4][2] = null;

        tree[5][0] = 2222222;
        tree[5][1] = null;
        tree[5][2] = null;

        tree[6][0] = 22222222;
        tree[6][1] = null;
        tree[6][2] = null;
      /*  printTreee1(tree,0);
        System.out.println("===================================");
		qinaxuFeiDigui(tree,0);*/
        /*printTreee2(tree,0);
        System.out.println("=======================================");
		zhongxuFeiDigui(tree,0);*/
        printTreee3(tree, 0);
        System.out.println("===================================");
        houxuFeiDigui(tree, 0);
        System.out.println("*********************************");
        levelOrder(tree, 0);
    }

    private void printTreee1(Integer[][] tree, Integer i) {
        if (i == null) {
            return;
        }
        System.out.println(tree[i][0]);
        printTreee1(tree, tree[i][1]);
        printTreee1(tree, tree[i][2]);
    }

    // 用非递归的方法进行先序遍历
    private void qinaxuFeiDigui(Integer[][] tree, Integer i) {
        Stack<Integer> stack = new Stack<Integer>();
        while (i != null || !stack.isEmpty()) {
            while (i != null) {
                System.out.println(tree[i][0]);
                stack.push(i);
                i = tree[i][1];
            }
            if (!stack.isEmpty()) {
                i = stack.pop();
                i = tree[i][2];
            }
        }
    }

    private void printTreee2(Integer[][] tree, Integer i) {
        if (i == null) {
            return;
        }
        printTreee2(tree, tree[i][1]);
        System.out.println(tree[i][0]);
        printTreee2(tree, tree[i][2]);
    }

    // 用非递归的方法进行中序遍历
    private void zhongxuFeiDigui(Integer[][] tree, Integer i) {
        Stack<Integer> stack = new Stack<Integer>();
        while (i != null || !stack.isEmpty()) {
            while (i != null) {
                stack.push(i);
                i = tree[i][1];
            }
            if (!stack.isEmpty()) {
                i = stack.pop();
                System.out.println(tree[i][0]);
                ;
                i = tree[i][2];
            }
        }
    }

    private void printTreee3(Integer[][] tree, Integer i) {
        if (i == null) {
            return;
        }
        printTreee3(tree, tree[i][1]);
        printTreee3(tree, tree[i][2]);
        System.out.println(tree[i][0]);
    }

    // 用非递归的方法进行后序遍历
    private void houxuFeiDigui(Integer[][] tree, Integer i) {
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
                if (tree[i][2] == null || tree[i][2].equals(afterNode)) {
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
    private void levelOrder(Integer[][] tree, Integer i) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(i);
        while (!queue.isEmpty()) {
            Integer myTree = queue.poll();
            System.out.println(tree[myTree][0]);
            if (tree[myTree][1] != null) {
                queue.offer(tree[myTree][1]);
            }
            if (tree[myTree][2] != null) {
                queue.offer(tree[myTree][2]);
            }
        }
    }

    @Test
    public void demo27() {
        String temp = "test{{0}}";
        System.out.println(temp.replace("{{0}}", "123"));
    }

    @Test
    public void demo28() {
        String textMsgTemp = "{\"touser\":\"%s\",\"msgtype\":\"text\",\"text\":{\"content\":\"%s\"}}";
        String sendMsg = String.format(textMsgTemp, 1, "test22");
        System.out.println(sendMsg);
    }

    @Test
    public void demo30() {
        String te = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=ACCESS_TOKEN";
        System.out.println(te.replace("ACCESS_TOKEN", "abs"));
        //System.out.println(scale);
        BigDecimal t = new BigDecimal(123.9861);
        System.out.println(trimToStr(t));
    }

    private String trimToStr(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof BigDecimal) {
            System.out.println("test");
            return ((BigDecimal) obj).toPlainString();
        }
        return obj.toString().trim();
    }

    @Test
    public void demo29() {
        System.out.println(decapitalize("AFvGrd"));
    }

    private String decapitalize(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        System.out.println(name.charAt(0) + ":" + name.charAt(1));
        if (name.length() > 1 && Character.isUpperCase(name.charAt(1)) &&
                Character.isUpperCase(name.charAt(0))) {
            return name;
        }
        char chars[] = name.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }

    private String substring10(String source) {
        return substring(trim(source), 10);
    }

    private String substring(String source, int limit) {
        String retStr = null;
        try {
            if (null == source || source.length() < limit) {
                retStr = source;
            } else {
                retStr = source.substring(0, limit);
            }
        } catch (Exception e) {
            System.out.println("substring:" + e);
        }
        return retStr;
    }

    private String trim(final String str) {
        return str == null ? null : str.trim();
    }

    @Test
    public void demo31() throws MalformedURLException {
        URL url = new URL("https://img.vipkidresource.com/cum/koala/image/tp_app_4.png");
        String host = url.getHost();
        System.out.println("host:" + host);
        String protocol = url.getProtocol();
        System.out.println("protocol:" + protocol);
        String path = url.getPath();
        System.out.println("path:" + path);
        List<String> list = Arrays.asList(host.split("\\."));
        if (list != null && list.size() >= 2) {
            StringBuilder newHost = new StringBuilder(protocol).append("://").append("imgx");
            for (int i = 1; i < list.size(); i++) {
                newHost.append(".").append(list.get(i));
            }
            newHost.append("/").append(list.get(0));
            System.out.println("newHost:" + newHost.toString());
        }
    }

    @Test
    public void demo32() {
        Long now = (new Date()).getTime();
        List<Student> partitionResources = new ArrayList<>();
        List<Student> finalPartitionResources = partitionResources;
        for (Integer i = 0; i < 2; i++) {
            Student st = new Student();
            st.setId(Long.parseLong(String.valueOf(i)));
            st.setName("name:" + i);
            st.setScore(i + 1 * 60);
            finalPartitionResources.add(st);
        }
        for (int i = 0; i < 2; i++) {
            System.out.println(partitionResources.get(i).getName());
        }
    }

    private String deptTaskMappingStr = "{2:1000,3:82,4:1000,6:1000,7:1000,9:1000,10:1000,11:1000}";

    private Map<Integer, Integer> deptTaskMapping;

    private Map<String, Integer> deptNameIdMapping;

    private void initDeptNameAndIdMapping() {
        List<VipkidOrg.Org> orgs = VipkidOrg.orgs;
        if (Objects.isNull(orgs) || orgs.isEmpty()) {
            log.warn("orgs is null or empty");
            return;
        }
        for (VipkidOrg.Org org : orgs) {
            initDeptNameAndIdMapping(org, "");
        }
    }

    private void initDeptNameAndIdMapping(VipkidOrg.Org org, String parentName) {
        List<VipkidOrg.Org> children = org.getChildren();
        String name = parentName + org.getName();
        if (Objects.isNull(children) || children.isEmpty()) {
            int id = org.getId();
            deptNameIdMapping.put(name, id);
        } else {
            name += ",";
            for (VipkidOrg.Org childOrg : children) {
                initDeptNameAndIdMapping(childOrg, name);
            }
        }
    }

    @Test
    public void demo33() {

        deptTaskMapping = JSONObject.parseObject(deptTaskMappingStr, new TypeReference<Map<Integer, Integer>>() {
        });
        if (Objects.isNull(deptTaskMapping)) {
            deptTaskMapping = new HashMap<>();
        }
        deptTaskMapping.put(-1, 1000);
        log.info("success to load deptName and taskId mapping, mapping result is " + JSONObject.toJSON(deptTaskMapping));
        deptNameIdMapping = new HashMap<>();
        initDeptNameAndIdMapping();
        for (Map.Entry<Integer, Integer> m : deptTaskMapping.entrySet()) {
            System.out.println("key:" + m.getKey() + " value:" + m.getValue());
        }
        System.out.println("=========================");
        for (Map.Entry<String, Integer> m : deptNameIdMapping.entrySet()) {
            System.out.println("key:" + m.getKey() + " value:" + m.getValue());
        }
    }

    private Date getAfterMinutes(Date date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, offset);
        return calendar.getTime();
    }

    private Date getBeginningOfNextMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    @Test
    public void demo34() {
        Date now = new Date();
        System.out.println(getBeginningOfNextMonth());
        System.out.println(now);
        System.out.println(getAfterMinutes(now, 5));
        System.out.println("Level2".compareTo("Level3"));
    }

    @Test
    public void demo35() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(calendar.getTime());
    }

    @Test
    public void demo36() {
        String token = "Access Token";

        String[] arr = token.split(" ");
        if (arr != null && arr.length == 3) {
            System.out.println(arr[2]);
            ;
        }
        if (arr != null && arr.length == 1) {
            System.out.println(token);
            ;
        }
    }

    /**
     * 首字母转大写
     *
     * @param name
     * @return
     */
    public static String dealStr(String name) {
        if (name == null) {
            return null;
        }
        char[] cs = name.toCharArray();
        if (cs[0] >= 97 && cs[0] <= 122) {
            cs[0] -= 32;
            name = String.valueOf(cs);
        }
        String number = null;
        String prefix = null;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i] >= 48 && cs[i] <= 57) {
                number = name.substring(i);
                prefix = name.substring(0, i);
                break;
            }
        }
        return prefix + " " + number;
    }

    @Test
    public void demo37() {
        String lesson_id = "842643,842655,842667,842679,842691,842703,842715,842727,842739,842751,842763,842775,842787,842799,842811,842823,842835,842847,842859,842871,842883,842895,842907,842919,842668,842669,842678,842670,842671,842672,842676,842673,842674,842675,842677";
        List<Long> lessonIds = new ArrayList();
        Arrays.stream(lesson_id.split(",")).forEach(item -> lessonIds.add(Long.valueOf(item)));
        System.out.println(lessonIds.size());
    }

    @Test
    public void demo38() {
        String icons = "[{\n" +
                "\t\"activityType\": 14,\n" +
                "\t\"primarySort\": \"selfExpression\",\n" +
                "\t\"iconUrl\": \"learning/af1d1b64-cb8d-46aa-9437-74fbaf48a7d3.png\"\n" +
                "}, {\n" +
                "\t\"activityType\": 14,\n" +
                "\t\"primarySort\": \"viewsAndDiscussions\",\n" +
                "\t\"iconUrl\": \"learning/b29d83fa-fc7a-4ce8-baf2-6f002797b194.png\"\n" +
                "}, {\n" +
                "\t\"activityType\": 14,\n" +
                "\t\"primarySort\": \"independentCreation\",\n" +
                "\t\"iconUrl\": \"learning/34ca3ff6-d785-4183-af71-5e6801d9fb83.png\"\n" +
                "}, {\n" +
                "\t\"activityType\": 11,\n" +
                "\t\"primarySort\": \"checkIn\",\n" +
                "\t\"iconUrl\": \"learning/6e4d3d64-68ca-40ca-80f9-033c25263f67.png\"\n" +
                "}, {\n" +
                "\t\"activityType\": 11,\n" +
                "\t\"primarySort\": \"passwordPK\",\n" +
                "\t\"iconUrl\": \"learning/1fd1afd0-eb26-44f6-9d28-785bcc0e3405.png\"\n" +
                "}, {\n" +
                "\t\"activityType\": 11,\n" +
                "\t\"primarySort\": \"talkAboutPictureBooks\",\n" +
                "\t\"iconUrl\": \"learning/b29d83fa-fc7a-4ce8-baf2-6f002797b194.png\"\n" +
                "}, {\n" +
                "\t\"activityType\": 11,\n" +
                "\t\"primarySort\": \"cartoonVoiceover\",\n" +
                "\t\"iconUrl\": \"learning/1fd1afd0-eb26-44f6-9d28-785bcc0e3405.png\"\n" +
                "}]";
        List<IconUrl> iconMap = null;
        try {
            iconMap = JSON.parseArray(icons, IconUrl.class);
            for (IconUrl iconUrl : iconMap) {
                if (iconUrl.getPrimarySort().equals("cartoonVoiceover")) {
                    System.out.println(JSONObject.toJSONString(iconUrl));
                }
            }

        } catch (Exception e) {
            log.error("getFunActivities error", e);
        }
        System.out.println(JSONObject.toJSONString(iconMap));
        System.out.println(dealStr("unit4"));
    }

    @Test
    public void demo39() {
        String iconUrlList = "";
        List<IconUrl> iconList = JSON.parseArray(iconUrlList, IconUrl.class);
        if (iconList != null) {
            for (IconUrl iconUrl : iconList) {
                String url = iconUrl.getIconUrl();
                System.out.println(1);
            }
        }
        System.out.println(2);
    }


    @Test
    public void demo40() {
        String sts = "[{\n" +
                "\t\"id\": 393,\n" +
                "\t\"age\": 23,\n" +
                "\t\"name\": \" 1111\",\n" +
                "\t\"score\": 12\n" +
                "}, {\n" +
                "\t\"id\": 385,\n" +
                "\t\"name\": \"stage自动化勿动\",\n" +
                "\t\"score\": 60\n" +
                "}, {\n" +
                "\t\"id\": 379,\n" +
                "\t\"name\": \"清风徐来\",\n" +
                "\t\"score\": 59\n" +
                "}]";
        List<Student> list = JSON.parseArray(sts, Student.class);
        System.out.println(JSON.toJSONString(list));
    }

    @Test
    public void demo41() {
        Integer a = 1211111111;
        Integer b = 1211111111;
        if (!a.equals(b)) {
            System.out.println(1);
        }
        System.out.println(2);
    }

    public static void FixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(103);
        for (int i = 0; i <= 100; i++) {
            final int index = i;
            executorService.execute(new Runnable() {

                public void run() {
                    System.err.println(index);
                }
            });
        }
        executorService.shutdownNow();
    }

    private void ScheduledThreadPool() throws InterruptedException {
        // 表示延迟3秒执行
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);

        scheduledThreadPool.shutdownNow();
    }

    private void detest() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and execute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
        Thread.sleep(14000);
    }

    private void ScheduledThreadPool2() throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " : 延迟3秒");
            }
        });

        /**
         * 定长线程池，支持定时及周期性任务执行
         */
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        //延迟3s后运行
        scheduledThreadPool.schedule(thread, 3, TimeUnit.SECONDS);

        //首次执行延迟1s，每次间隔3秒
        //scheduledThreadPool.scheduleAtFixedRate(thread, 1, 3, TimeUnit.SECONDS);

        //每次执行结束，已固定时延开启下次执行
        //scheduledThreadPool.scheduleWithFixedDelay(thread, 1, 3, TimeUnit.SECONDS);

        System.out.println(Thread.currentThread().getName() + " : main thread");
        Thread.sleep(4000);
        scheduledThreadPool.shutdown();
    }

    @Test
    public void demo42() throws InterruptedException {
        detest();
    }

    @Test
    public void demo43() throws InterruptedException {
        String tr = (String) null;
        System.out.println(1);
        System.out.println("12".equals(null));
        Set<String> wordIDs = new HashSet<>(1);
        for (String oneWordID : wordIDs) {
            System.out.println(234);
        }
        Double nextWordAlikeD = null;
        if (nextWordAlikeD > 0) {
            System.out.println("po");
        }
    }

}
