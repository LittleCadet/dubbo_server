package com.dubbo.senior;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

/**
 * dubbo异步调用的future收集器，用于采集远程任务状态
 * Created by Finn on 2017/2/20 0020.
 */
public class FutureCollector {

    private List<FutureInfo> futureList = Lists.newArrayList();

    public void collect(Future<String> future) {
        synchronized (futureList) {
            futureList.add(new FutureInfo(future));
        }
    }

    public List<FutureInfo> get() {
        synchronized (futureList) {
            return new ArrayList<>(futureList);
        }
    }

    public void remove(FutureInfo future) {
        synchronized (futureList) {
            futureList.remove(future);
        }
    }
}
