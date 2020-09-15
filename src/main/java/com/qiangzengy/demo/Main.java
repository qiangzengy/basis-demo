package com.qiangzengy.demo;

import com.qiangzengy.demo.emus.ProcessCodeEnum;
import com.qiangzengy.demo.emus.ProcessEnum;
import com.qiangzengy.demo.impl.AliChannelRule;
import com.qiangzengy.demo.impl.ToutiaoChannelRule;
import com.qiangzengy.demo.rule.GeneralChannelRule;

public class Main {

    public static void main(String[] args) {
        String name = "DIDI";
       /* if (name.equals(ProcessEnum.TOUTIAO.getName())){
            ToutiaoChannelRule rule=new ToutiaoChannelRule();
            rule.process();
        }else {
            AliChannelRule rule=new AliChannelRule();
            rule.process();
        }*/

        ProcessCodeEnum match = ProcessCodeEnum.match(name);
        GeneralChannelRule rule = match.getRule();
        rule.process();
    }

}
