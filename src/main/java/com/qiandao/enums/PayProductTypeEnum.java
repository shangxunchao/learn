package com.qiandao.enums;

public enum PayProductTypeEnum {
    NORMAL(0, "正常产品"),
    ADDITIONAL(1, "附加产品"),
    GROUP(2, "团购产品"),
    EXCHANGE(3, "兑换码产品"),
    VIP(4, "会员卡产品");

    private int code;
    private String desc;

    PayProductTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }
}
