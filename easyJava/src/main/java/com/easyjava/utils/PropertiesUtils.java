package com.easyjava.utils;

import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PropertiesUtils {
    private static Properties props = new Properties();
    private static Map<String, String> PROPER_MAP = new ConcurrentHashMap<>();

    static {
        InputStream is = null;
        try {
            is = PropertiesUtils.class.getClassLoader().getResourceAsStream("application.properties");
            props.load(is);

            Iterator<Object> itrator = props.keySet().iterator();
            while (itrator.hasNext()) {
                String key = (String) itrator.next();
                PROPER_MAP.put(key, props.getProperty(key));
            }
        } catch (Exception e){

        }finally {
            if(is!=null){
                try{
                    is.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getString(String key) {
        return PROPER_MAP.get(key);
    }

    public static void main(String[] args) {
        System.out.println(getString("db.driver.name"));
    }

}
