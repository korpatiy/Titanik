package org.home.service;

import java.util.List;

public class MyCSVWorkerImpl<T> implements MyCSVWorker {

    private final List<T> passengers;

    public MyCSVWorkerImpl(List<T> passengers) {
        this.passengers = passengers;
    }
}
