package com.icbc.dagger.util;

import java.util.Properties;

/**
 * Properties loader
 *
 * @author kfzx-huanghao
 * @since 20170426
 */
public class PropUtil {
    private static Properties props;

    private PropUtil() {
    }

    public static void load() {
        props = new Properties();
        try {
            props.load(PropUtil.class.getResourceAsStream("/dagger.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static {
        load();
    }

    public static String getProperty(String name) {
        return props.getProperty(name);
    }
}
