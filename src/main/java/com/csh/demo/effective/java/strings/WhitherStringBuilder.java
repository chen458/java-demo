package com.csh.demo.effective.java.strings;

/**
 * @author: shenghong.chen
 * Date: 2016/11/24
 * time: 下午3:08
 */
public class WhitherStringBuilder {
    public static String implicit (String [] fields) {
        String result = "";
        for (int i = 0; i < fields.length; i ++ ) {
            result += fields[i];
        }
        return result;
    }

    public static String explicit (String [] fields) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < fields.length; i ++ ) {
            sb.append(fields[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] test = {"q1", "w2", "e3", "r4", "t5", "y6", "u7", "i8"};
//        System.out.println(WhitherStringBuilder.implicit(test));
//        System.out.println(WhitherStringBuilder.explicit(test));
    }
}
