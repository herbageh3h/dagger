package com.icbc.dagger.hunter.checker;

/**
 * xstream: A java library to serialize objects to XML/JSON and back again.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class XStreamChecker extends NamePatternChecker {
    public XStreamChecker() {
        super("xstream");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*xstream.*\\.jar$");
    }

}
