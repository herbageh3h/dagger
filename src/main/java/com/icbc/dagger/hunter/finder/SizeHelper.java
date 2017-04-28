package com.icbc.dagger.hunter.finder;

import java.util.List;

import com.icbc.dagger.hunter.data.SoftSizeCenter;
import com.icbc.dagger.hunter.data.ThirdPartySoft;
import com.icbc.dagger.util.FileUtil;

public class SizeHelper {
    private static SoftSizeCenter sizeCenter;

    static {
        sizeCenter = new SoftSizeCenter();
        sizeCenter.loadCsv();
    }

    public String findVersion(ThirdPartySoft soft) {
        String softName = soft.getName();

        if (!sizeCenter.contains(softName)) {
            return "";
        }

        String version = "";
        long softSize = FileUtil.getSize(soft.getPath());
        List<ThirdPartySoft> softHist = sizeCenter.getSoftHist(softName);

        long minDiff = softSize;
        for (ThirdPartySoft refSoft : softHist) {
            long delta = Math.abs(refSoft.getSize() - softSize);
            if (delta < minDiff) {
                minDiff = delta;
                version = refSoft.getVersion();
            }
        }

        if (minDiff != softSize && minDiff < 10240) { // 差距小于10K认为可以接受
            return version;
        }

        return "";
    }
}
