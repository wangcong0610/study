package com.pengzhangg.study.netty.handler.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;


/**
 * Author: Zhang Peng
 * Date: 2016/12/26 0026
 * Description:
 */
public class TcpServerHandler extends SimpleChannelInboundHandler<Object> {

    private static final Logger logger = Logger.getLogger(TcpServerHandler.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        logger.info("SERVER接收到消息:"+msg);
        ctx.channel().writeAndFlush("yes, server is accepted you ,nice !"+msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) throws Exception {
        logger.warn("Unexpected exception from downstream.", cause);
        ctx.close();
    }

}
