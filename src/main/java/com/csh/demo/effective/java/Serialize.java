package com.csh.demo.effective.java;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author: shenghong.chen
 * Date: 2017/3/19
 * time: 下午5:24
 */
public class Serialize implements Serializable {

    private int num = 1390;

    public static void main(String[] args) {
        try {
            FileOutputStream stream = new FileOutputStream("/Users/csh/Desktop/Serialize.bat");
            ObjectOutputStream oos = new ObjectOutputStream(stream);
            oos.writeObject(new Serialize());
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
