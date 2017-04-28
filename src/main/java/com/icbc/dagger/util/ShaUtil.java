package com.icbc.dagger.util;

import java.security.MessageDigest;

public class ShaUtil {
    public static String hashString(String src) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(src.getBytes());

            byte[] data = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : data) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return src;
        }
    }

    public static void main(String[] args) {
        System.out.println(ShaUtil.hashString("ctp,ctp-engine,5.5.00.0"));
    }
}
