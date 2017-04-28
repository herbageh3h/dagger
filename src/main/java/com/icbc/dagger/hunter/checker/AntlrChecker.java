package com.icbc.dagger.hunter.checker;

/**
 * antlr: A framework for constructing recognizers, compilers, and translators
 * from grammatical descriptions containing Java, C#, C++ or Python actions.
 * 
 * @author kfzx-huanghao
 * @since 20170428
 * 
 */
public class AntlrChecker extends NamePatternChecker {
    public AntlrChecker() {
        super("antlr");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*antlr.*\\.jar$");
    }

}
