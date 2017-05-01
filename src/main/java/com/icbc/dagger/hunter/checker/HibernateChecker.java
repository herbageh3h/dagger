package com.icbc.dagger.hunter.checker;

/**
 * hibernate: Object relation mapping tool. 
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class HibernateChecker extends NamePatternChecker {
    public HibernateChecker() {
        super("hibernate");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*hibernate.*\\.jar$");
    }

}
