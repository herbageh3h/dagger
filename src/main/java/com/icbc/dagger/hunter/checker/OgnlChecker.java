package com.icbc.dagger.hunter.checker;

/**
 * ognl: Object graph navigation library.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class OgnlChecker extends NamePatternChecker {
    public OgnlChecker() {
        super("ognl");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*ognl.*\\.jar$");
    }

}
