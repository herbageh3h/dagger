package com.icbc.dagger.hunter.checker;

/**
 * stax: Streaming API for XML. API to read and write XML documents.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class StaxChecker extends NamePatternChecker {
    public StaxChecker() {
        super("stax");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*stax.*\\.jar$");
    }

}
