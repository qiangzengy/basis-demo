package com.qiangzengy.demo.impl;

import com.qiangzengy.demo.rule.GeneralChannelRule;

public class AliChannelRule extends GeneralChannelRule {

    @Override
    public void process() {
        System.out.println("阿里业务处理");
    }
}
