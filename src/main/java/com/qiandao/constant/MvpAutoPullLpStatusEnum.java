package com.qiandao.constant;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * <p>
 * </p>
 * DATE 2020/4/17.
 *
 * @author xingpeng.
 */
public enum MvpAutoPullLpStatusEnum {

    /**
     * DONOTPULLLP
     */
    DONOTPULLLP(0, "报名后不拉lp进群"),
    /**
     * AUTOPULLLP
     */
    AUTOPULLLP(1, "自动拉lp");

    private int code;
    private String desc;

    MvpAutoPullLpStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static List<String> getMvpApplyList() {
        List<String> list = new ArrayList<String>();
        for (MvpAutoPullLpStatusEnum c : MvpAutoPullLpStatusEnum.values()) {
            list.add(c.getDesc());
        }
        return list;
    }

    public static MvpAutoPullLpStatusEnum getLpStatusByCode(int code) {
        for (MvpAutoPullLpStatusEnum typeEnum : MvpAutoPullLpStatusEnum.values()) {
            if (typeEnum.getCode() == code) {
                return typeEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
