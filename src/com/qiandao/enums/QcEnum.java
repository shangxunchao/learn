package com.qiandao.enums;

public class QcEnum {

    // 课程类型
    public enum LessonType {

        LESSON_PAY(0, "付费课"),
        LESSON_FREE(1, "试听课");

        private Integer code;
        private String message;

        LessonType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    // 产品类型
    public enum ProductType {

        PRODUCT_NORMAL(0, "正常产品"),
        PRODUCT_ADDITIONAL(1, "试用产品"),
        PRODUCT_GROUP(2, "拼团产品"),
        PRODUCT_EXCHANGE(3, "兑换码产品"),
        PRODUCT_ASSIST(4, "会员卡产品");

        private Integer code;
        private String message;

        ProductType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    // 活动类型
    public enum ActivityType {

        ACTIVITY_LIMIT_TIME(1, "时间段"),
        ACTIVITY_UNLIMIT_TIME(2, "不限时间");

        private Integer code;
        private String message;

        ActivityType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    // 任务类型
    public enum EventType {

        EVENT_TYPE_LEARNED("learned"),
        EVENT_TYPE_SHARED("shared");

        private String message;

        EventType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    // 任务是否必要
    public enum IsRequired {

        FLOW_NOTREQUIRED(0, "不必要"),
        FLOW_REQUIRED(1, "必要");

        private Integer code;
        private String message;

        IsRequired(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    // 奖品类型
    public enum PrizeType {

        PRIZE_TYPE_REAL(0, "虚拟"),
        PRIZE_TYPE_VIRTUAL(1, "实物");

        private Integer code;
        private String message;

        PrizeType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    //是否领取奖品
    public enum AwardType {

        AWARD_RECEIVE(0, "未领取"),
        AWARD_NOT_RECEIVE(1, "已领取");

        private Integer code;
        private String message;

        AwardType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    // 活动状态
    public enum ActivityStatus {

        ACTIVITY_DISABLE(0, "不可用"),
        ACTIVITY_USABLE(1, "可用");

        private Integer code;
        private String message;

        ActivityStatus(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    // 产品状态
    public enum ProductStatus {

        PRODUCT_DISABLE(0, "不可用"),
        PRODUCT_USABLE(1, "可用");

        private Integer code;
        private String message;

        ProductStatus(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    // 支付状态
    public enum PayStatus {
        PAY_MAKE(0, "已生成"),
        PAY_PAYED(1, "已支付"),
        PAY_REFUND(2, "已退款"),
        PAY_FAILED(3, "失败"),
        PAY_WAIT(4, "待确认");

        private Integer code;
        private String message;

        PayStatus(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }

    //微信消息类型
    public enum WechatMsgType {
        TEXT(0, "文本消息"),
        IMAGE(1, "图片消息"),
        VOICE(2, "语音消息"),
        VIDEO(3, "视频消息"),
        SHORT_VIDEO(4, "小视频消息"),
        LOCATION(5, "地理位置消息"),
        LINK(6, "链接消息");

        private Integer code;
        private String message;

        WechatMsgType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    //配置类型
    public enum ConfigType {
        QC("qc"),
        LC("lc"),
        AVATAR("avatar"),
        IMG_BG("img-bg"),
        SYS("sys");

        private String message;

        ConfigType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    // Banner类型
    public enum BannerType {

        MINI_PROGRAM(0, "小程序"),
        h5(1, "h5");

        private Integer code;
        private String message;

        BannerType(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    // 产品状态
    public enum BannerStatus {

        Banner_DISABLE(0, "不可用"),
        Banner_USABLE(1, "可用");

        private Integer code;
        private String message;

        BannerStatus(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }
}
