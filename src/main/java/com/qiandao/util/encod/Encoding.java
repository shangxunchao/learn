package com.qiandao.util.encod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/8/29 15:16
 */
public class Encoding {

    /**
     * 将流中的内容转换为字符串，主要用于提取request请求的中requestBody
     *
     * @param in
     * @param encoding
     * @return 3种会导致乱码产生的情景
     * [1] 数据库表里面字符集设置错误
     * [2] 由于未加编码过滤器导致SpringMVC接收参数时造成的乱码
     * [3] 代码中涉及byte数组转换String时出现了问题
     * 在将字节流内容转换成字符串时，特别要注意这种读取到半个中文的问题。
     */

    public static String streamToString(InputStream in, String encoding) {

        // 将流转换为字符串
        ByteArrayOutputStream bos = null;
        try {
            // 1.创建内存输出流,将读到的数据写到内存输出流中
            bos = new ByteArrayOutputStream();
            // 2.创建字节数组
            byte[] arr = new byte[1024];
            int len;
            while (-1 != (len = in.read(arr))) {
                bos.write(arr, 0, len);
            }
            // 3.将内存输出流的数据全部转换为字符串
            return bos.toString(encoding);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("提取 requestBody 异常", e);
        } finally {
            if (null != bos) {
                try {
                    // 其实这个内存输出流可关可不关，因为它的close方法里面没做任何操作。
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
