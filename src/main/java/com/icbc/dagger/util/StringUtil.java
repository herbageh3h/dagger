package com.icbc.dagger.util;

import java.io.File;

import org.apache.commons.lang3.StringUtils;

/**
 * string utilities for dagger
 * 
 * @author huanghao
 * @since 20170501
 *
 */
public class StringUtil {
    private static final char SYSTEM_SEPARATOR = File.separatorChar;
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    private StringUtil() {
    }

    public static boolean isEmpty(final String s) {
        return StringUtils.isEmpty(s);
    }

    public static boolean isBlank(final String s) {
        return StringUtils.isBlank(s);
    }

    /**
     * Make a string that keep or not keep end separator
     * 
     * @param path
     * @param keepSeparator
     *            true: keep, false: not to keep
     * @return
     */
    public static String dealEndSeparator(final String path, boolean keepSeparator) {
        if (isEmpty(path)) {
            return "";
        }

        char c = path.charAt(path.length() - 1);
        boolean endSeparator = (c == UNIX_SEPARATOR || c == WINDOWS_SEPARATOR) ? true : false;

        if (keepSeparator) {
            return endSeparator ? path : path + SYSTEM_SEPARATOR;
        } else {
            return endSeparator ? path.substring(0, path.length()) : path;
        }
    }
}
