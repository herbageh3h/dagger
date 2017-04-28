package com.icbc.dagger.hunter.checker;

/**
 * apache xmlschema: A lightweight java object model that can be used to
 * manipulate and generate XML schema representations. It can be used to read
 * XML schema(xsd) files into memory and analyze or modify them, or to create
 * entirely new schemas from scratch.
 * 
 * @author kfzx-huanghao
 * 
 */
public class XmlschemaChecker extends NamePatternChecker {
    public XmlschemaChecker() {
        super("apache xml");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*xmlschema.*\\.jar$");
    }

}
