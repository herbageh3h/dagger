package com.icbc.dagger.hunter.checker;

/**
 * mx4j: A project to create an open source implementation of Java management
 * Extensions(JMX). It is widely adopted in open source projects like Jetty
 * Server, Tomcat, Geronimo, Harmony, OjectWeb JOnAS and many others.
 * 
 * @author kfzx-huanghao
 * 
 */
public class Mx4jChecker extends NamePatternChecker {
    public Mx4jChecker() {
        super("mx4j");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*mx4j.*\\.jar$");
    }
}
