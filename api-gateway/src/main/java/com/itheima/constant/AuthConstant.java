package com.itheima.constant;

import java.util.HashMap;

public class AuthConstant {
    public static HashMap<String,String> auth = new HashMap<>();
    static {
        auth.put("1","admin");
        auth.put("2","user");
    }
}
