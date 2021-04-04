package com.qiandao.java8.stream;

import com.alibaba.fastjson.JSON;
import com.qiandao.model.SysConfigPackageIdAndProductId;

import java.util.List;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/8/22 16:22
 */
public class FirstJson {

    public static void main(String[] args) {
        String temp = "[" +
                "{\"id\":42,\"type\":1,\"outUrl\":\"product42H5Url\"}" +
                "{\"id\":64,\"type\":1,\"outUrl\":\"product64H5Url\"}" +
                "{\"id\":0,\"type\":2,\"outUrl\":\"speakerUrl\"}" +
                "{\"id\":3861,\"type\":2,\"outUrl\":\"package3861H5Url\"}" +
                "{\"id\":3413,\"type\":2,\"outUrl\":\"package3413H5Url\"}" +
                "{\"id\":4058,\"type\":2,\"outUrl\":\"package4058H5Url\"}" +
                "]";
        String outUrl = null;
        List<SysConfigPackageIdAndProductId> beanIds = JSON.parseArray(temp, SysConfigPackageIdAndProductId.class);
        if (beanIds != null && beanIds.size() > 0) {

            outUrl = beanIds.stream().filter(s -> s.getType() != null && s.getType() == 1
                    && !s.getOutUrl().trim().isEmpty()
                    && s.getId() == 11
            ).map(SysConfigPackageIdAndProductId::getOutUrl)
                    .findFirst().orElse(null);

            if (outUrl == null || outUrl.length() == 0) {
                outUrl = beanIds.stream().filter(s -> s.getType() != null && s.getType() == 2
                        && !s.getOutUrl().trim().isEmpty()
                        && s.getId() == 3861
                ).map(SysConfigPackageIdAndProductId::getOutUrl)
                        .findFirst().orElse(null);
            }
            if (outUrl != null && outUrl.length() > 0) {
                System.out.println(outUrl);
                return;
            }

        }

        System.out.println("not find：" + beanIds.size());
    }
}
