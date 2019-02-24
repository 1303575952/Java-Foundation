package com.imooc.netty.ch3;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * @author FELIX
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelRegistered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded");
    }

    @Override
    public void channelRead(final ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = loadFromDB();
                ctx.channel().writeAndFlush(result);
                ctx.executor().schedule(new Runnable() {
                    @Override
                    public void run() {
                        // ...
                    }
                }, 1, TimeUnit.SECONDS);
            }
        }).start();
    }

    private String loadFromDB() {
        return "hello world";
    }
}
