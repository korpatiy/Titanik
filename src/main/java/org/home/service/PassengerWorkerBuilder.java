package org.home.service;

/**
 * Создает экземпляры {@link PassengerWorkerImpl}
 */
public interface PassengerWorkerBuilder extends WorkerBuilder {

    /**
     * @return экземпляр {@link PassengerWorkerImpl}
     */
    @Override
    default PassengerWorker build() {
        return new PassengerWorkerImpl(workingList());
    }
}
