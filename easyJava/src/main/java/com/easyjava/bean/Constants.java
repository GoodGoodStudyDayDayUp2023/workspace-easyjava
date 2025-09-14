package com.easyjava.bean;

import com.easyjava.utils.PropertiesUtils;

public class Constants {
    public static Boolean IGNORE_TABLE_PERFIX;

    public static String SUFFIX_BEAN_PARAM;

    static {
        IGNORE_TABLE_PERFIX = Boolean.valueOf(PropertiesUtils.getString("ignore.table.perfix"));
        SUFFIX_BEAN_PARAM = PropertiesUtils.getString("suffix.bean.param");
    }
}
