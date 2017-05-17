package com.csh.demo.rpc.server;

/**
 * @author: shenghong.chen
 * Date: 2016/11/16
 * time: 下午5:38
 */
public class EchoServiceImpl implements EchoService {

    public String echo(String ping) {
        return null != ping ? ping + " --> I am ok" : " I am ok ";
    }
}
