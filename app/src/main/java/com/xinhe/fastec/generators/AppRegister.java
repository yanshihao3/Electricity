package com.xinhe.fastec.generators;


import com.example.core.wechat.AppRegisterTemplate;
import com.example.fastec_annotations.AppRegisterGenerator;

/**
 * Created by 傅令杰 on 2017/4/22
 */
@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.xinhe.fastec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
