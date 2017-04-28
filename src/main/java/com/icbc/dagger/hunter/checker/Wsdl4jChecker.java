package com.icbc.dagger.hunter.checker;

/**
 * wsdl: Web Services Description Language. An XML-based interface definition
 * language that is used for describing the functionality offered by a web
 * service. This jar is developed by IBM.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class Wsdl4jChecker extends NamePatternChecker {
    public Wsdl4jChecker() {
        super("wsdl4j");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*wsdl4j.*\\.jar$");
    }

}
