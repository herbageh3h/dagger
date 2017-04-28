package com.icbc.dagger.hunter.checker;

/**
 * jaxen: An XPath engine to work against a variety of XML based object models
 * such as DOM, dom4j and JDOM together with Java Beans.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class JaxenChecker extends NamePatternChecker {
    public JaxenChecker() {
        super("jaxen");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jaxen.*\\.jar$");
    }

}
