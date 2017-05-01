package com.icbc.dagger.hunter.finder;

import java.util.List;

import com.icbc.dagger.hunter.data.SoftSizeCenter;
import com.icbc.dagger.hunter.data.OpenSoft;
import com.icbc.dagger.util.FileUtil;

public class SizeHelper {
    private static SoftSizeCenter sizeCenter;

    static {
        sizeCenter = new SoftSizeCenter();
        sizeCenter.loadCsv();
    }

    public String findVersion(OpenSoft soft) {
        String softName = soft.getName();

        if (!sizeCenter.contains(softName)) {
            return "";
        }

        String version = "";
        long softSize = FileUtil.getSize(soft.getPath());
        List<OpenSoft> softHist = sizeCenter.getSoftHist(softName);

        long minDiff = softSize;
        for (OpenSoft refSoft : softHist) {
            long delta = Math.abs(refSoft.getSize() - softSize);
            if (delta < minDiff) {
                minDiff = delta;
                version = refSoft.getVersion();
            }
        }

        if (minDiff != softSize && minDiff < 10240) {
            return version;
        }

        return "";
    }
}
