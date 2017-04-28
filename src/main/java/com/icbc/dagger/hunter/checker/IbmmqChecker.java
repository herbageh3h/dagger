package com.icbc.dagger.hunter.checker;

/**
 * ibm mq: WebSphere MQ classes for Java.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class IbmmqChecker extends NamePatternChecker {
    public IbmmqChecker() {
        super("ibm mq");
    }

    @Override
    protected void setupPattern() {
        this.setRegex("com\\.ibm\\.mq.*\\.jar$");
    }

}
