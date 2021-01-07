package com.qiandao.model;

/**
 * @Author: shangxunchao
 * @Description:
 * @Date: Created in 2019/8/22 15:55
 */
public class SysConfigPackageIdAndProductId {

    private Long id;
    // 1代表product 2代表package
    private Integer type;

    private String outUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOutUrl() {
        return outUrl;
    }

    public void setOutUrl(String outUrl) {
        this.outUrl = outUrl;
    }
}
