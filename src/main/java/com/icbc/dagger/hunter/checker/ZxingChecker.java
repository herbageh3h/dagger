package com.icbc.dagger.hunter.checker;

/**
 * google zxing: Zebra Crossing. An open-source, multi-format 1D/2D barcode
 * image processing library.
 * 
 * <p>
 * <strong>github</strong>: zxing/zxing<br>
 * <strong>groupId</strong>: com.google.zxing<br>
 * <strong>artifactId</strong>: core<br>
 * <strong>category</strong>: barcode library<br>
 * </p>
 * 
 * @author kfzx-huanghao
 * @since 20170426
 * 
 */
public class ZxingChecker extends NamePatternChecker {
    public ZxingChecker() {
        super("zxing");
    }

    @Override
    protected void setupPattern() {
        this.setRegex(".*zxing.*\\.jar$");
    }

}
