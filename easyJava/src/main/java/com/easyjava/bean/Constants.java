package com.easyjava.bean;

import com.easyjava.utils.PropertiesUtils;

public class Constants {

    public static String AUTHOR_COMMENT;

    public static Boolean IGNORE_TABLE_PREFIX;

    public static String SUFFIX_BEAN_QUERY;

    public static String SUFFIX_BEAN_QUERY_FUZZY;
    public static String SUFFIX_BEAN_QUERY_START;
    public static String SUFFIX_BEAN_QUERY_END;
    public static String SUFFIX_MAPPERS;

    //需要忽略的属性
    public static String IGNORE_BEAN_TOJSON_FIELD;
    public static String IGNORE_BEAN_TOJSON_EXPRESSION;
    public static String IGNORE_BEAN_TOJSON_CLASS;

    //日期序列化
    public static String BEAN_DATE_SERIALIZE_EXPRESSION;
    public static String BEAN_DATE_SERIALIZE_CLASS;
    public static String BEAN_DATE_UNSERIALIZE_EXPRESSION;
    public static String BEAN_DATE_UNSERIALIZE_CLASS;

    public static String PATH_JAVA = "java";

    public static String PATH_RESOURCES = "resources";

    public static String PACKAGE_BASE;

    public static String PACKAGE_PO;

    public static String PACKAGE_QUERY;

    public static String PACKAGE_VO;

    public static String PACKAGE_MAPPERS;

    public static String PACKAGE_UTILS;

    public static String PACKAGE_EXCEPTION;

    public static String PACKAGE_ENUMS;

    public static String PACKAGE_SERVICE;

    public static String PACKAGE_SERVICE_IMPL;

    public static String PACKAGE_CONTROLLER;

    public static String PATH_BASE;

    public static String PATH_PO;

    public static String PATH_QUERY;

    public static String PATH_VO;

    public static String PATH_UTILS;

    public static String PATH_ENUMS;

    public static String PATH_EXCEPTION;

    public static String PATH_MAPPERS;

    public static String PATH_MAPPERS_XMLS;

    public static String PATH_SERVICE;

    public static String PATH_SERVICE_IMPL;

    public static String PATH_CONTROLLER;

    static {
        AUTHOR_COMMENT = PropertiesUtils.getString("author.comment");

        IGNORE_BEAN_TOJSON_FIELD = PropertiesUtils.getString("ignore.bean.tojson.field");
        IGNORE_BEAN_TOJSON_EXPRESSION = PropertiesUtils.getString("ignore.bean.tojson.expression");
        IGNORE_BEAN_TOJSON_CLASS = PropertiesUtils.getString("ignore.bean.tojson.class");

        //�������л��������л�
        BEAN_DATE_SERIALIZE_EXPRESSION = PropertiesUtils.getString("bean.date.serialize.expression");
        BEAN_DATE_SERIALIZE_CLASS = PropertiesUtils.getString("bean.date.serialize.class");

        BEAN_DATE_UNSERIALIZE_EXPRESSION = PropertiesUtils.getString("bean.date.unserialize.expression");
        BEAN_DATE_UNSERIALIZE_CLASS = PropertiesUtils.getString("bean.date.unserialize.class");

        IGNORE_TABLE_PREFIX = Boolean.valueOf(PropertiesUtils.getString("ignore.table.prefix"));
        SUFFIX_BEAN_QUERY = PropertiesUtils.getString("suffix.bean.query");
        SUFFIX_BEAN_QUERY_FUZZY = PropertiesUtils.getString("suffix.bean.query.fuzzy");
        SUFFIX_BEAN_QUERY_START = PropertiesUtils.getString("suffix.bean.query.start");
        SUFFIX_BEAN_QUERY_END = PropertiesUtils.getString("suffix.bean.query.end");
        SUFFIX_MAPPERS = PropertiesUtils.getString("suffix.mappers");

        PACKAGE_BASE = PropertiesUtils.getString("package.base");
        //PO
        PACKAGE_PO = PACKAGE_BASE + "." + PropertiesUtils.getString("package.po");
        PACKAGE_QUERY = PACKAGE_BASE + "." + PropertiesUtils.getString("package.query");
        PACKAGE_VO = PACKAGE_BASE + "." + PropertiesUtils.getString("package.vo");
        PACKAGE_UTILS = PACKAGE_BASE + "." + PropertiesUtils.getString("package.utils");
        PACKAGE_ENUMS = PACKAGE_BASE + "." + PropertiesUtils.getString("package.enums");
        PACKAGE_EXCEPTION = PACKAGE_BASE + "." + PropertiesUtils.getString("package.exception");
        PACKAGE_MAPPERS = PACKAGE_BASE + "." + PropertiesUtils.getString("package.mappers");
        PACKAGE_SERVICE = PACKAGE_BASE + "." + PropertiesUtils.getString("package.service");
        PACKAGE_SERVICE_IMPL = PACKAGE_BASE + "." + PropertiesUtils.getString("package.service.impl");
        PACKAGE_CONTROLLER = PACKAGE_BASE + "." + PropertiesUtils.getString("package.controller");

        PATH_BASE = PropertiesUtils.getString("path.base");
        PATH_BASE = PATH_BASE + PATH_JAVA;

        PATH_PO = PATH_BASE + "/" + PACKAGE_PO.replace(".", "/");
        PATH_QUERY = PATH_BASE + "/" + PACKAGE_QUERY.replace(".", "/");
        PATH_VO = PATH_BASE + "/" + PACKAGE_VO.replace(".", "/");
        PATH_UTILS = PATH_BASE + "/" + PACKAGE_UTILS.replace(".", "/");
        PATH_ENUMS = PATH_BASE + "/" + PACKAGE_ENUMS.replace(".", "/");
        PATH_EXCEPTION = PATH_BASE + "/" + PACKAGE_EXCEPTION.replace(".", "/");
        PATH_MAPPERS = PATH_BASE + "/" + PACKAGE_MAPPERS.replace(".", "/");
        PATH_MAPPERS_XMLS = PropertiesUtils.getString("path.base") + "/" + PATH_RESOURCES + "/" + PACKAGE_MAPPERS.replace(".", "/");
        PATH_SERVICE = PATH_BASE + "/" + PACKAGE_SERVICE.replace(".", "/");
        PATH_SERVICE_IMPL = PATH_BASE + "/" + PACKAGE_SERVICE_IMPL.replace(".", "/");
        PATH_CONTROLLER = PATH_BASE + "/" + PACKAGE_CONTROLLER.replace(".", "/");

    }

    public static void main(String[] args) {
        System.out.println(PATH_MAPPERS_XMLS);
//        System.out.println(PATH_PO);
    }

    public final static String[] SQL_DATE_TIME_TYPE = new String[]{"datetime", "tiemstamp"};

    public final static String[] SQL_DATE_TYPE = new String[]{"date"};

    public static final String[] SQL_DECIMAL_TYPE = new String[]{"decimal", "double", "float"};

    public static final String[] SQL_STRING_TYPE = new String[]{"char", "varchar", "text", "mediumtext", "longtext"};

    //Integer
    public static final String[] SQL_INTEGER_TYPE = new String[]{"int", "tinyint"};

    //Long
    public static final String[] SQL_LONG_TYPE = new String[]{"bigint"};
}
