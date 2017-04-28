package com.icbc.dagger.hunter.checker;

/**
 * apache xalan: A popular open source software library that implements the XSLT
 * 1.0 XML transformation language and the XPath 1.0 language.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class XalanChecker extends NamePatternChecker {
    public XalanChecker() {
        super("xalan");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*xalan.*\\.jar$");
    }

}
