package com.icbc.dagger.hunter.checker;

/**
 * mysql: Open source relation database.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class MysqlChecker extends NamePatternChecker {
    public MysqlChecker() {
        super("mysql");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*mysql.*\\.jar$");
    }

}
