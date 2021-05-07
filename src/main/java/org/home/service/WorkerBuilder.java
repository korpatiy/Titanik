package org.home.service;

import java.util.List;

public interface WorkerBuilder<T> {

    /**
     * @return лист для работы
     */
    List<T> workingList();

    /**
     * @return экземпляр {@link MyCSVWorker}
     */
    default MyCSVWorker build() {
        return new MyCSVWorkerImpl<>(workingList());
    }
}
