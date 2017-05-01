package com.icbc.dagger.hunter.checker;

/**
 * jsoup: A library designed to extract and manipulate data stored in HTML
 * documents.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class JsoupChecker extends NamePatternChecker {
    public JsoupChecker() {
        super("jsoup");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jsoup.*\\.jar$");
    }

}
