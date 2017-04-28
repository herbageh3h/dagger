package com.icbc.dagger.hunter.checker;

/**
 * edtFTPj: An open-source FTP client library.
 * @author kfzx-huanghao
 *
 */
public class EdtftpjChecker extends NamePatternChecker {
    public EdtftpjChecker() {
        super("edtftpj");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*edtftpj.*\\.jar$");
    }

}
