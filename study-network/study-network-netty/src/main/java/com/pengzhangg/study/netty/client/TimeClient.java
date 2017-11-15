package com.pengzhangg.study.netty.client;

import com.pengzhangg.study.netty.handler.client.TimeClientHandler;
import com.pengzhangg.study.netty.pojo.UnixTime;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Author:zp
 * Date:2017/8/23 0023
 * Description:Time protocol Client
 */
public class TimeClient {
    public static void main(String[] args) throws Exception {
        // String host = args[0];
        // int port = Integer.parseInt(args[1]);
        String host = "10.239.11.19";
        int port = 8080;
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ByteToMessageDecoder() {
                        @Override
                        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
                            if (in.readableBytes() < 4) {
                                return;
                            }
                            out.add(new UnixTime(in.readUnsignedInt()));
                        }
                    }, new TimeClientHandler());
                }
            });

            // Start the client.
            ChannelFuture f = b.connect(host, port).sync(); // (5)

            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
