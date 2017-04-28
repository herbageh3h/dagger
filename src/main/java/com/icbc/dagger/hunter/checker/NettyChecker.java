package com.icbc.dagger.hunter.checker;

/**
 * netty: A non-blocking IO(nio) client-server framework for the development of
 * Java network applications such as protocol servers and clients.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class NettyChecker extends NamePatternChecker {
    public NettyChecker() {
        super("netty");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*netty.*\\.jar$");
    }

}
