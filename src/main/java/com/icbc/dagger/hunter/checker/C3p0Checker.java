package com.icbc.dagger.hunter.checker;

/**
 * c3p0: An easy-to-use library for augmenting traditional JDBC drivers with
 * JNDI-bindable Datasources, including Datasources that implement Connection
 * and Statement Pooling.
 *
 * @author huanghao
 * @since 20170430
 *
 */
public class C3p0Checker extends NamePatternChecker {
    public C3p0Checker() {
        super("c3p0");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*c3p0.*\\.jar$");
    }

}
