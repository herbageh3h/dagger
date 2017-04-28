package com.icbc.dagger.hunter.checker;

/**
 * ibm ssl: Secure Sockets Layer, provide communications security over a
 * computer network.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class SslChecker extends NamePatternChecker {
    public SslChecker() {
        super("ibm ssl");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*ssl.*\\.jar$");
    }

}
