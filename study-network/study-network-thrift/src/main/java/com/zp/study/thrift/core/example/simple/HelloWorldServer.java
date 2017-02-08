package com.zp.study.thrift.core.example.simple;

import com.zp.study.thrift.core.service.HelloWorldService;
import com.zp.study.thrift.core.service.impl.HelloWorldServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;

/**
 * Author: Zhang Peng
 * Date: 2017/1/23 0023
 * Description:
 */
public class HelloWorldServer {


    public static final int SERVER_PORT = 8090;

    public void startServer() {
        try {
            System.out.println("HelloWorld TSimpleServer start ....");

            TProcessor tprocessor = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());
            // HelloWorldService.Processor<HelloWorldService.Iface> tprocessor1 = new HelloWorldService.Processor<HelloWorldService.Iface>(new HelloWorldServiceImpl());

            // 简单的单线程服务模型，一般用于测试
            TServerSocket tServerSocket = new TServerSocket(SERVER_PORT);
            TServer.Args tArgs = new TServer.Args(tServerSocket);
            tArgs.processor(tprocessor);
            /*
            TBinaryProtocol : 二进制格式.
            TCompactProtocol : 压缩格式
            TJSONProtocol : JSON格式
            TSimpleJSONProtocol : 提供JSON只写协议, 生成的文件很容易通过脚本语言解析
             */
            tArgs.protocolFactory(new TBinaryProtocol.Factory());// 二进制
            TServer server = new TSimpleServer(tArgs);
            server.serve();

        } catch (Exception e) {
            System.out.println("Server start error!!!");
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        HelloWorldServer server = new HelloWorldServer();
        server.startServer();
    }

}
