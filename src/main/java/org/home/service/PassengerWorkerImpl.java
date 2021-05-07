package org.home.service;

import org.home.entity.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Реализует {@link PassengerWorker}
 */
public class PassengerWorkerImpl implements PassengerWorker {

    private final List<Passenger> passengers;

    public PassengerWorkerImpl(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public Map<Integer, Integer> getNameCountMap() {
        Map<Integer, Integer> map = new HashMap<>();
        passengers
                .forEach(p -> {
                    map
                            .compute(p.getName().length(), (k, v) -> v == null ? 1 : v + 1);
                });
        return map;
    }

    @Override
    public int getAvgAgeBy(Predicate<Passenger> predicate) {
        return (int) passengers
                .stream()
                .filter(predicate)
                .mapToDouble(Passenger::getAge)
                .average()
                .getAsDouble();
    }
}
