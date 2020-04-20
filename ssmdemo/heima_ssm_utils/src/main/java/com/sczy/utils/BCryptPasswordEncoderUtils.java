package com.sczy.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    public static String jiami(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String jiami = BCryptPasswordEncoderUtils.jiami("123456");
        System.out.println(jiami);
    }
}
