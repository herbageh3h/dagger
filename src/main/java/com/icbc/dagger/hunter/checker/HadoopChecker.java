package com.icbc.dagger.hunter.checker;

/**
 * hadoop: Big data platform.
 * 
 * @author huanghao
 * @since 20170430
 *
 */
public class HadoopChecker extends NamePatternChecker {
    public HadoopChecker() {
        super("hadoop");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*(hadoop|hive|hbase).*\\.jar$");
    }

}
