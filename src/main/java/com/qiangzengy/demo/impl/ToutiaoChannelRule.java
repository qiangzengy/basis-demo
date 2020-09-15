package com.qiangzengy.demo.impl;

import com.qiangzengy.demo.rule.GeneralChannelRule;

public class ToutiaoChannelRule extends GeneralChannelRule {

    @Override
    public void process() {
        System.out.println("处理头条业务");
    }
}
