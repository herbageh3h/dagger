package com.icbc.dagger.hunter.checker;

/**
 * slf4j: Simple Logging Facade for Java.
 * 
 * <ul>
 * <li>groupId: org.slf4j</li>
 * <li>artifactId: slf4j-api, slf4j-log4j12</li>
 * </ul>
 * 
 * @author huanghao
 * @since 20170501
 *
 */
public class Slf4jChecker extends NamePatternChecker {
    public Slf4jChecker() {
        super("slf4j");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*slf4j.*\\.jar$");
    }

}
