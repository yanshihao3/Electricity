package com.xinhe.fastec.generators;


import com.example.core.wechat.WXPayEntryTemplate;
import com.example.fastec_annotations.PayEntryGenerator;

/**
 * Created by 傅令杰 on 2017/4/22
 */
@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.xinhe.fastec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
