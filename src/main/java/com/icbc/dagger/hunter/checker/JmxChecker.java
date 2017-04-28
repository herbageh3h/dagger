package com.icbc.dagger.hunter.checker;

/**
 * jmx: Java Management Extensions(JMX). Supplies tools for managing and
 * monitoring applications, system objects, devices and service-oriented
 * networks.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 */
public class JmxChecker extends NamePatternChecker {
    public JmxChecker() {
        super("jmx");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jmx.*\\.jar$");
    }

}
