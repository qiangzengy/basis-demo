package com.qiangzengy.demo.emus;

import com.qiangzengy.demo.impl.AliChannelRule;
import com.qiangzengy.demo.impl.DidiChannelRule;
import com.qiangzengy.demo.impl.ToutiaoChannelRule;
import com.qiangzengy.demo.rule.GeneralChannelRule;

public enum  ProcessCodeEnum {

    TOUTIAO("TOUTIAO",new ToutiaoChannelRule()),
    ALI("ALI", new AliChannelRule()),
    DIDI("DIDI", new DidiChannelRule()),
    ;


    private String name;
    private GeneralChannelRule rule;

    ProcessCodeEnum(String name, GeneralChannelRule rule) {
        this.name = name;
        this.rule = rule;
    }

    //匹配
    public static ProcessCodeEnum match(String name){
        ProcessCodeEnum[] values = ProcessCodeEnum.values();
        for (ProcessCodeEnum value : values) {
            if(value.name.equals(name)){
                return value;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public GeneralChannelRule getRule() {
        return rule;
    }
}
