package com.icbc.dagger.hunter.checker;

/**
 * jsqlparser: A SQL statement parser. It translates SQLs in a traversable
 * hierachy of Java classes.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class JSqlParserChecker extends NamePatternChecker {
    public JSqlParserChecker() {
        super("jsqlparser");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jsqlparser.*\\.jar$");
    }

}
