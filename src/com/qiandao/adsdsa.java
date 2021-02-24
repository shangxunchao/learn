package com.qiandao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qiandao.constant.MvpAutoPullLpStatusEnum;
import com.qiandao.model.Student;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2020/4/8 18:11
 */
public class adsdsa {

	@Test
	public void deno() {
		System.out.println("1111111111111111111".length());
		long re = 1111111111111111111L;
		Integer temp = (int) re;
		Integer te = Integer.valueOf("111111111");
		System.out.println(String.valueOf(temp).length());
		long num = 30 * 24 * 3600 * 1000;
		System.out.println(num);
		System.out.println(String.valueOf(num));
		int temp2 = (int) num;
		if (num == 30 * 24 * 3600 * 1000) {
			System.out.println("ok");
		}
		if (temp2 == 30 * 24 * 3600 * 1000) {
			System.out.println("ok2");
		}
		System.out.println("-----------------------");
		HashMap map = new HashMap();
		map.put("1", "s1");
		map.put("2", "s2");
		map.keySet().forEach(job -> {
			System.out.println(job);
		});
		System.out.println(String.format("http://%1$s:%2$s/vkschedule/node/register", "11", "22"));
	}

	@Test
	public void demo2() {
		String fileName = "C:\\Users\\shangxunchao\\Desktop\\a.txt";
		File file = new File(fileName);
		BufferedReader reader = null;
		StringBuffer sbf = new StringBuffer();
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempStr;
			while ((tempStr = reader.readLine()) != null) {
				sbf.append(tempStr + ",");
			}
			reader.close();
			System.out.println(sbf.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	String lUrl = "http://wiki.vipkid.com.cn/pages/viewpage.action?pageId=4200208";

	@Test
	public void demo3() throws UnsupportedEncodingException {
		String token = "12 14 15";
		String[] arr = token.split(" ");
		if (arr != null && arr.length == 3) {
			System.out.println(arr[1]);
		}
		System.out.println(JSON.toJSONString(arr));
		String eurl = URLEncoder.encode(lUrl, "utf-8");
		System.out.println(eurl);
		System.out.println(URLDecoder.decode(eurl, "utf-8"));
		HashMap<Long, String> putShortUrl = new HashMap<>(2);
		putValue(putShortUrl);
		System.out.println(JSON.toJSONString(putShortUrl));
	}

	public void putValue(HashMap<Long, String> putShortUrl) {
		String tr = "ss%";
		System.out.println();
		putShortUrl.put(12L, "12");
		putShortUrl.put(13L, "12");
	}

	@Test
	public void demo4() {
		Integer code = 0;
		if (code == null || code != 0) {
			System.out.println(code);
		}

		String te = "{\n" +
				"  \"code\": 0,\n" +
				"  \"data\": [\n" +
				"    {\n" +
				"      \"id\": 546,\n" +
				"      \"name\": \"测试6\"\n" +
				"    },\n" +
				"    {\n" +
				"      \"id\": 545,\n" +
				"      \"name\": \"测试5\"\n" +
				"    }\n" +
				"  ],\n" +
				"  \"message\": \"成功\"\n" +
				"}";
		JSONObject resultJson = JSON.parseObject(te);
		String re = resultJson.getString("data");
		List<Student> list = JSONArray.parseArray(re, Student.class);
		System.out.println(JSONObject.toJSONString(list));
		String learningProgressInfo = resultJson.getString("learningProgress");
		System.out.println(JSON.toJSONString(JSON.parseObject(learningProgressInfo, Student.class)));
		System.out.println(System.currentTimeMillis());
		System.out.println("te+" + "te".split(",")[0]);
		String[] contents;
		contents = "12".split(",");
	}

	@Test
	public void demo5() {
		String te = "1\n2";
		System.out.println(JSON.toJSONString(te.split("\n")));
		Student st = new Student();
		System.out.println(JSON.toJSONString(st));
		adsd(st);
		System.out.println(JSON.toJSONString(st));
		System.out.println("活动详情：http://vos-media.vipkid-qa.com.cn/homework/qc/%E8%AF%A6%E6%83%85%E9%A1%B51589456924678.png（复制地址到浏览器查看）".length());
		String title = "活动详情：%s（复制地址到浏览器查看）";
		System.out.println(String.format(title, "www.baidu.com"));
		System.out.println("报名了MVP测试课01".length());
	}

	private void adsd(Student st) {
		st.setName("q23");
		st.setId(1L);
		st.setScore(123);
	}

	@Test
	public void demo6() {
		String content = "[{\n" +
				"\t\"courseId\": 12,\n" +
				"\t\"packId\": 123\n" +
				"}, {\n" +
				"\t\"courseId\": 13,\n" +
				"\t\"packId\": 124\n" +
				"}]";
		List<JSONObject> list = JSON.parseArray(content, JSONObject.class);
		for (JSONObject object : list) {
			System.out.println(object.get("courseId") + ":" + object.get("packId"));
		}
		String content2 = "{\"163194536\": {\"1\": \"6079\",\"2\": \"6080\",\"3\": \"6081\",\"4\": \"6082\",\"5\": \"6083\"},\"163194545\": {\"1\": \"6084\",\"2\": \"6085\",\"3\": \"6086\",\"4\": \"6087\",\"5\": \"6088\"}}";
		Map<String, Map<String, String>> itemMap = JSON.parseObject(content2, Map.class);
		System.out.println(JSON.toJSONString(itemMap));
		Long key = 597843L;
		Map<String, String> te = itemMap.get(String.valueOf(163194536));
		System.out.println(JSON.toJSONString(te));
		Map<String, String> te2 = itemMap.get(String.valueOf(163194545));
		System.out.println(JSON.toJSONString(te2));
		System.out.println(te.get("1"));
		System.out.println(te2.get("1"));
	}

	@Test
	public void demo7() {
		boolean re = Pattern.matches("/project_demo/competition_arena", "/project_demo/competition_arena");
		System.out.println(re);
		boolean re2 = Pattern.matches("/project_demo/clock_in/.*", "/project_demo/clock_in/a67899");
		System.out.println(re2);
		Random random = new Random();

		System.out.println(random.nextInt(2));
		System.out.println(random.nextInt(2));
		System.out.println(random.nextInt(2));
		System.out.println(random.nextInt(2));
		System.out.println(new Date("Thu Jun 11 10:38:17 CST 2020"));
	}

	private Date getYesterday(int interval) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		calendar.set(Calendar.HOUR_OF_DAY, interval);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	private Date getEndOfTheDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		return calendar.getTime();
	}

	private Date getStartDateByOffset(int dayOffset) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, dayOffset);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	@Test
	public void demo8() {
		List<Integer> successCode = new ArrayList<Integer>() {{
			//成功码
			add(0);
			//3001代表LearningProgress已经存在，默认创建成功
			add(3001);
		}};
		Date startTime = getYesterday(0);
		Date endTime = getEndOfTheDay(startTime);
		System.out.println(startTime + ":" + endTime);
		startTime = getStartDateByOffset(-30);
		endTime = getStartDateByOffset(-0);
		System.out.println(startTime + ":" + endTime);

		Date start = getStartDateByOffset(-6);
		Date end = new Date();
		System.out.println(start + ":" + end);
		String[] re = "MVP03-L1-U1-LC1-08".split("-");
		System.out.println(Integer.parseInt(re[4]));
	}

	@Test
	public void demo9() {
		String retContent = "{\n" +
				"    \"esDate\": \"20190603\",\n" +
				"    \"code\": \"0\",\n" +
				"    \"data\": {\n" +
				"        \"counts\": [\n" +
				"            694,\n" +
				"            6926,\n" +
				"            -1,\n" +
				"            -1\n" +
				"        ],\n" +
				"        \"vosLinks\": [\n" +
				"            \"https://vipkid-vos-test-dl.oss-cn-beijing.aliyuncs.com/toc/mos-usertag/1000-45a364758-155.personas\",\n" +
				"            \"https://vipkid-vos-test-dl.oss-cn-beijing.aliyuncs.com/toc/mos-usertag/1000-45a364758-128.personas\",\n" +
				"            \"\",\n" +
				"            \"\"\n" +
				"        ]\n" +
				"    },\n" +
				"    \"bizId\": \"1000\",\n" +
				"    \"batchId\": \"45a364758\",\n" +
				"    \"message\": \"成功\",\n" +
				"    \"rpid\": \"U0605175557oFuJE\"\n" +
				"}";
		JSONObject resultJson = JSON.parseObject(retContent);
		Integer code = resultJson.getInteger("code");
		System.out.println(code);
		String data = resultJson.getString("data");
		System.out.println(data);
		resultJson = JSON.parseObject(data);
		String[] urls = resultJson.getJSONArray("vosLinks").toArray(new String[0]);
		System.out.println(JSON.toJSONString(urls));
	}

	@Test
	public void demo10() throws UnsupportedEncodingException {
		Student student = new Student();
		student.setScore(123);
		student.setId(1L);
		student.setName("测试");
		student.setIp(123456L);
		student.setHost("8080");
		JSONObject object = JSONObject.parseObject(JSON.toJSONString(student));
		System.out.println(object.getLongValue("id") + ":" + object.getString("name") + ":" + object.getLong("ip") + ":" + object.getString("host"));
		try {
			ad();
		} catch (ArithmeticException ex) {
			System.out.println(1 + "ex");
		} catch (NumberFormatException ex) {
			System.out.println(2 + "ex");
		} catch (Exception ex) {
			System.out.println(3 + "ex");
		}
		Map<Long, Student> map = Collections.emptyMap();
		if (map == null || map.isEmpty()) {
			System.out.println(1);
		}
		map = new HashMap<>();
		if (map == null || map.isEmpty()) {
			System.out.println(2);
		}
		String te = "Dino收到了新装扮[%s]，快去Dino衣柜看看吧~";
		System.out.println(String.format(te, "re123"));
		System.out.println(String.join(":", "12", "56", null));
		;
		System.out.println(new Date());
		Calendar calendar1 = Calendar.getInstance();
		//在当前时间的基础上获取前三天的日期
		calendar1.add(Calendar.DATE, -3);
		Date daysAgo = calendar1.getTime();
		System.out.println(daysAgo);
		System.out.println(Arrays.asList("1"));
	}

	private void ad() throws ArithmeticException {
		int tr = Integer.valueOf("sdsf");
		System.out.println(tr);
		ad2();
	}

	private void ad2() {
		int b = 1 / 0;
	}

	@Test
	public void demo11() {
		String re = "{\n" +
				"    \"errcode\": 0,\n" +
				"    \"errmsg\": \"ok\",\n" +
				"    \"chat_info\":\n" +
				"        {\n" +
				"            \"name\": \"GroupName\",\n" +
				"            \"owner\": \"zhangsan\",\n" +
				"            \"chatid\": \"chatxxxxxxxxxxxxxxxxxxxxxxxx\",\n" +
				"            \"conversationTag\": 2,\n" +
				"            \"useridlist\": [\"zxxxx\",\"lxxx\"]\n" +
				"        }\n" +
				"}";
		Map result = new HashMap(2);
		JSONObject object = JSONObject.parseObject(re);
		Long errCode = object.getLong("errcode");
		result.put("errcode", errCode);
		if (errCode.equals(0L)) {
			String groupId = "chatid";
			String chatId = object.getString(groupId);
			result.put(groupId, chatId);
			String chatInfo = "chat_info";
			String groupInfo = object.getString(chatInfo);
			result.put(chatInfo, groupInfo);
		}
		System.out.println(JSON.toJSONString(result));
	}

	@Test
	public void demo12() {
		Integer autoPullLpStatus = 1;
		MvpAutoPullLpStatusEnum autoPullLpStatusEnum = MvpAutoPullLpStatusEnum.getLpStatusByCode(autoPullLpStatus);
		if (autoPullLpStatusEnum == null) {
			System.out.println(1);
		}
		int totalPage = (int) Math.ceil((5.0) / 2);
		System.out.println(totalPage);
		System.out.println(Integer.MIN_VALUE);
		List<Long> te = new ArrayList<Long>() {{
			add(1L);
			add(2L);
			add(3L);
		}};
		List<Integer> tr = new ArrayList<Integer>() {{
			add(2);
			add(3);
			add(4);
		}};
		System.out.println("start==");
		for (Long tem : te) {
			if (tr.contains(tem)) {
				System.out.println(tem);
			}
		}
		System.out.println("WAIT_FOR_RECEIVING".length());
		Map map = new HashMap(1);
		if (map.isEmpty()) {
			System.out.println("map is null.");
		}
		List<Integer> tem = new ArrayList<Integer>() {{
			add(1);
			add(2);
		}};
		System.out.println("=================");
		System.out.println(JSONObject.toJSONString(tem.subList(2, 2)));
		System.out.println((byte) 7);
	}

	@Test
	public void demo13() {
		Map<String, Map<String, List<Integer>>> statisticsNumber = new HashMap<>(2);
		for (int i = 0; i < 3; i++) {
			String key = "sendSMS" + i;
			Map<String, List<Integer>> tempMap = new HashMap<>();
			List<Integer> list = new ArrayList<>();
			list.add(i);
			tempMap.put(key, list);
			statisticsNumber.put(key, tempMap);
		}
		Map<String, List<Integer>> tempMap = statisticsNumber.get("sendSMS");
		if (tempMap == null) {
			System.out.println("===============null");
		}
		System.out.println(JSONObject.toJSONString(statisticsNumber));
		System.out.println(JSONObject.toJSONString(statisticsNumber.get("sendSMS2")));
	}

	private Date addHour(Date date, int hour) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, hour);
		return c.getTime();
	}

	@Test
	public void demo14() throws ParseException {

		Integer ce = 200;
		int te = 200;
		if (ce.equals(te)) {
			System.out.println("------------------");
		}
		List<Long> tem = null;
		List<Student> students = new ArrayList<Student>() {{
			Student student = new Student();
			student.setId(1L);
			add(student);
		}};
		tem = students.stream().map(Student::getId).distinct().collect(Collectors.toList());
		System.out.println(JSON.toJSONString(tem));
		/*int oneDay = 1;
		Date now = new Date();
		Date endTime = new Date(now.getTime() + oneDay);
		System.out.println(now);
		System.out.println(endTime);
		String te = "eyJhbGciOiJSUzUxMiJ9.eyJzdWIiOiJ0cCIsImlhdCI6MTU5NjYyNzc3OSwiaXNzIjoiVEFTIiwidWlkIjozOTU3NTY1LCJyb2xlIjoiVEVSIiwiZXhwIjoxNTk2NzEyMzc5fQ.L8uGdQED0mrh-kmJ3iMZnS3q_woDJ-QGwASJpMZkisNPDIw8l31pnfC8RYEEixB77JUszoT7vVDxfnmmSYEHg-zRPmlRgTCOmIaKfCbj7I9tEOwUz6zP_aUI8NdyorcY5vto8hGcjeuVJ7-8ETF6md2-QTkiogxdiU80LsF--Vk";
		String[] temp = te.split("\\.");
		for (String t : temp) {
			System.out.println(t);
		}
		Date end2 = addHour(now, 1);
		System.out.println(end2);
		Boolean te2 = true;
		getDemo(te2);
		System.out.println("********************");
		System.out.println(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date2 = "2020-08-20 00:00:00";
		Date date = sdf.parse(date2);
		Date date3 = sdf.parse(date2);
		if (date.equals(date3)) {
			System.out.println("===============");
		}
		System.out.println(date);*/
		getDemo(true);
	}


	private void getDemo(boolean te) {
		Map<Integer, Integer> resultMap = new HashMap<>();
		resultMap.put(1, 2);
		resultMap.put(2, 3);
		List<Integer> eshopGoodsIdList = new ArrayList<Integer>() {{
			add(1);
			add(2);
		}};
		for (Integer goodsId : eshopGoodsIdList) {
			System.out.println("goodsId=" + goodsId);
			if (null == resultMap.get(goodsId)) {
				System.out.println("==========");
			} else {
				System.out.println("************");
			}
		}
		String te2 = null;
		te2 = String.format(TEACHER_CONTRACT_NEGATIVE_STATISTIC, 23, 25, new Date());
		System.out.println(te2);
		double num = 1 * 1.0 / 3;
		System.out.println(num);
		System.out.println(Math.round(num * 100) * 0.01d);
		System.out.println(Math.round(0.126) / 100);
	}

	public static final String TEACHER_CONTRACT_NEGATIVE_STATISTIC = "teacher-evaluation-center:teacher:negative"
			+ ":statistics:%s:%s:%s";

	public static void main(String[] args) {
		Date now = new Date();
		Date fi = getFirstDayOfGivenMonth(now, 0);
		System.out.println(fi);
		Date fi2 = getFirstDayOfGivenMonth(now, 1);
		System.out.println(fi2);
		Date end = getDateFormat();
		Date fi3 = getFirstDayOfGivenMonth(end, 2);
		System.out.println(fi3);
	}

	/**
	 * 获取指定日期当月的第一天
	 *
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date getFirstDayOfGivenMonth(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.MONTH, month);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}


	public static Date getFirstDayOfNextMonth2(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		Date lastDayOfMonth = calendar.getTime();
		System.out.println(lastDayOfMonth);
		return null;
	}

	public static Date getDateFormat() {
		Calendar c = Calendar.getInstance();//获得一个日历的实例
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse("2020-12-01 00:00:00");//初始日期
			return date;
		} catch (Exception e) {

		}
		return null;

	}


	@Test
	public void demo15() {
		Integer a = 20;
		Integer b = 21;
		Double d1 = a * 1.0 / b;
		System.out.println(d1);
		double d2 = 2.2554;
		double d3 = 2.2565;
		double d4 = 2.2576;
		BigDecimal bd1 = new BigDecimal(d1);
		BigDecimal bd2 = new BigDecimal(d2);
		BigDecimal bd3 = new BigDecimal(d3);
		BigDecimal bd4 = new BigDecimal(d4);

		System.out.println(bd1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(bd2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(bd3.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(bd4.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(String.format("evaluation:teacher:recent:statistics:%s"
				+ ":%s:%s", 12, 2, 3));
		System.out.println(1076181 % 16);
		DecimalFormat df = new DecimalFormat("#.000");
		System.out.println(df.format(d2));
		System.out.println(df.format(d3));
		System.out.println(df.format(d4));
		System.out.println(String.format("%.3f", d2));
		System.out.println(String.format("%.3f", d3));
		System.out.println(String.format("%.3f", d4));
	}

	@Test
	public void demo16() {
		/*Map<String, String> map = new HashMap<>();
		map.put("", "12");
		System.out.println(map.get(""));
		int h;
		StringBuilder strBuilder = new StringBuilder(256);
		String te = "2020-09-15/15:02:49.590|172.24.23.39|[http-nio-1234-exec-2] INFO  c.vipkid.teacher.leave.controller.LeaveController 153 - getValidLeaves,teacherId=5460572";
		strBuilder.append(te + "\n" + te);
		System.out.println(strBuilder.toString());
		String s = "2020-09-15/16:31:45.961|172.24.23.39|[http-nio-1234-exec-2] INFO  c.vipkid.teacher.leave.controller.LeaveController 153 - BookingsCountConsumer#receivedMessage=Message{properties={MIN_OFFSET=9358184, MAX_OFFSET=9432895, KEYS=vkmq_teacher_class_center_2daysago_booked_class_cnt_da, CONSUME_START_TIME=1600150831311, UNIQ_KEY=0A1D01EC68AD49C2FAAE4B2C1B41FB75, WAIT=true, ttl=604800000, TAGS=vkmq_teacher_class_center_2daysago_booked_class_cnt_da}, topic='vkmq-bi-teacher_ALI', tag='vkmq_teacher_class_center_2daysago_booked_class_cnt_da', key='vkmq_teacher_class_center_2daysago_booked_class_cnt_da', body=[{\"teacherId\": 45556105, \"bookedClassCount\": 16, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 45752744, \"bookedClassCount\": 5, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 45835841, \"bookedClassCount\": 8, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 45993514, \"bookedClassCount\": 3, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46265995, \"bookedClassCount\": 5, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46512037, \"bookedClassCount\": 0, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46570300, \"bookedClassCount\": 4, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46618434, \"bookedClassCount\": 7, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46650789, \"bookedClassCount\": 5, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46681433, \"bookedClassCount\": 4, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46686348, \"bookedClassCount\": 1, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46690600, \"bookedClassCount\": 1, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46909476, \"bookedClassCount\": 0, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46917071, \"bookedClassCount\": 4, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 46947251, \"bookedClassCount\": 2, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 47068174, \"bookedClassCount\": 6, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 47164528, \"bookedClassCount\": 0, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 47187627, \"bookedClassCount\": 7, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 47258050, \"bookedClassCount\": 1, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 47263234, \"bookedClassCount\": 6, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 47281146, \"bookedClassCount\": 3, \"dayTime\": \"2020-09-14\"}, {\"teacherId\": 47299165, \"booked\n";
		System.out.println(getId());
		int a = h = 1;
		System.out.println("==============--------------");
		System.out.println(a + ":" + h);
		System.out.println(500119444 % 32);
		Integer tes = 1;*/
		Integer tes = 1;
		System.out.println(500067807 % 32);
		List<Integer> tem = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			tem.add(i + 1);
		}
		tem.subList(0, 1);
		System.out.println(tem);
		System.out.println(tes.equals(null));
		System.out.println("#f85415");
		Student st = new Student();
		Student st2 = new Student();
		System.out.println(st.equals(st2));
	}

	private Long getId() {
		Map<String, String> greyClass = new HashMap<>();
		greyClass.put("12", "12");
		greyClass.put("13", "13");
		List<String> te = new ArrayList<String>() {{
			add("12");
			add("13");
		}};
		System.out.println(JSON.toJSONString(greyClass));
		for (int i = 0; i < 5; i++) {
			greyClass = greyClass.entrySet().stream()
					.filter(entry -> !(te.contains(entry.getKey())))
					.collect(Collectors.toMap(
							(e) -> (String) e.getKey(),
							(e) -> e.getValue()
					));
		}
		System.out.println(JSON.toJSONString(greyClass));
		LocalDate now = LocalDate.now();
		LocalDate current = now.with(ChronoField.DAY_OF_WEEK, DayOfWeek.MONDAY.getValue());
		System.out.println(now);
		System.out.println(current);
		return 99L;
	}

	private void setInter(Student st) {
		st.setId(3L);
		st = null;
	}

	class fa {
		public void f1() {
			System.out.println("f1");
		}
	}

	class ch extends fa {
		@Override
		public void f1() {
			System.out.println("ch1");
		}

		public void f2() {
			System.out.println("ch2");
		}
	}

	@Test
	public void demo17() {
		adsdsa.fa fa = null;
		if (fa instanceof adsdsa.ch) {
			System.out.println("fa is ch true");
		}
		if (fa instanceof adsdsa.fa) {
			System.out.println("fa is fa true");
		} else {
			System.out.println("fa is fa false");
		}
		adsdsa.ch ch = new ch();
		if (ch instanceof adsdsa.ch) {
			System.out.println("ch is ch true");
		}
		if (ch instanceof adsdsa.fa) {
			System.out.println("ch is fa true");
		} else {
			System.out.println("ch is fa false");
		}
		fa.f1();
	}

}
