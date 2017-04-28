package com.icbc.dagger.hunter.checker;

import java.io.File;

public interface Checker {
    boolean pass(File f);

    boolean pass(String path);

    String getName();
}
