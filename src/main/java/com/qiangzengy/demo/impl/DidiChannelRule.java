package com.qiangzengy.demo.impl;

import com.qiangzengy.demo.rule.GeneralChannelRule;

public class DidiChannelRule extends GeneralChannelRule {

    @Override
    public void process() {
        System.out.println("滴滴业务处理");
    }
}
