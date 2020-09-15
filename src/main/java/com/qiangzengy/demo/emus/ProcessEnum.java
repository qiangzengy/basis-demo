package com.qiangzengy.demo.emus;

public enum ProcessEnum {

    TOUTIAO(1,"TOUTIAO"),
    ALI(2,"ALI");

    private Integer code;
    private String name;

    ProcessEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
