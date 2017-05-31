package com.ivaneye;

import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by wangyifan on 2017/5/18.
 */
public class Test {
    private static final int intNum = 314;
    private static final float floatNum = 3.14f;
    private static final double doubleNum = 3.14;
    private static final long longNum = 314;
    private static final String str = "This is string";

    public String show(){
        return str;
    }

    public static void main(String[] args) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("public class Temp{\n");
        for (int i = 0; i < 65535; i++) {
            sb.append("\tprivate static final int _" + i + "=" + i + ";\n");
        }
        sb.append("}");
        Files.write(Paths.get("D:/Temp.java"), sb.toString().getBytes("UTF-8"));
    }
}
