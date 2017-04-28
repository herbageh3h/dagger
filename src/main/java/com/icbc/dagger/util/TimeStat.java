package com.icbc.dagger.util;

public class TimeStat {
    long start;
    long end;

    public void start() {
        start = System.nanoTime();
    }

    public void end() {
        end = System.nanoTime();
    }

    public long delta() {
        return end - start;
    }
}
