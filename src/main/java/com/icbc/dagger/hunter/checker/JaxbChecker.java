package com.icbc.dagger.hunter.checker;

/**
 * jaxb: Java Architect for XML Binding(JAXB). A framework that allows Java
 * developers to map Java classes to XML representations.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class JaxbChecker extends NamePatternChecker {
    public JaxbChecker() {
        super("jaxb");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jaxb.*\\.jar$");
    }

}
