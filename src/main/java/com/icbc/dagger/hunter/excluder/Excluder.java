package com.icbc.dagger.hunter.excluder;

import java.io.File;

public interface Excluder {
    boolean exclude(File f);
}
