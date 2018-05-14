package com.xinhe.fastec.generators;


import com.example.core.wechat.WXEntryTemplate;
import com.example.fastec_annotations.EntryGenerator;

/**
 * Created by 傅令杰 on 2017/4/22
 */

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.xinhe.fastec",
        entryTemple = WXEntryTemplate.class
)
public interface WeChatEntry {
}
