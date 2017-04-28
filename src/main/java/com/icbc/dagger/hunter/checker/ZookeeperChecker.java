package com.icbc.dagger.hunter.checker;

/**
 * zookeeper: Distributed coordination.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class ZookeeperChecker extends NamePatternChecker {
    public ZookeeperChecker() {
        super("zookeeper");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*zookeeper.*\\.jar$");
    }

}
