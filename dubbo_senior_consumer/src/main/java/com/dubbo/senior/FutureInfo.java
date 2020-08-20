package com.dubbo.senior;

import java.util.concurrent.Future;

public class FutureInfo {
    private final Future<String> future;

    public FutureInfo(Future<String> future) {
        this.future = future;
    }


}
