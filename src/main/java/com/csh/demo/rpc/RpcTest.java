package com.csh.demo.rpc;

import com.csh.demo.rpc.client.RpcImporter;
import com.csh.demo.rpc.server.EchoService;
import com.csh.demo.rpc.server.EchoServiceImpl;
import com.csh.demo.rpc.server.RpcExporter;

import java.net.InetSocketAddress;

/**
 * @author: shenghong.chen
 * Date: 2016/11/16
 * time: 下午7:02
 */
public class RpcTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    RpcExporter.exporter("localhost", 8099);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(
                EchoServiceImpl.class,
                new InetSocketAddress("localhost", 8099));
        System.out.println(echo.echo("成功了"));
    }
}
