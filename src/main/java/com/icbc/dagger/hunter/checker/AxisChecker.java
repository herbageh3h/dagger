package com.icbc.dagger.hunter.checker;

/**
 * Apache Axis: A open-source, XML based Web service framework.
 * 
 * @author kfzx-huanghao
 * 
 */
public class AxisChecker extends NamePatternChecker {
    public AxisChecker() {
        super("axis");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*axis.*\\.jar$");
    }
}
