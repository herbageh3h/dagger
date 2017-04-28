package com.icbc.dagger.hunter.checker;

/**
 * jsch: A pure Java implementation of SSH2. It allows you to connect to an sshd
 * server and use prot forwarding, X11 forwarding, file transfer, etc.
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class JschChecker extends NamePatternChecker {
    public JschChecker() {
        super("jsch");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*jsch.*\\.jar$");
    }

}
