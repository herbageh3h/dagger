package com.icbc.dagger.hunter.checker;

public class JedisChecker extends NamePatternChecker {
    public JedisChecker() {
        super("jedis");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jedis.*\\.jar$");
    }

}
