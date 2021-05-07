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
       /* passengers
                .stream()
                .filter(predicate)*/
        int survived = 1;
        if (predicate.equals("male"))
            survived = 0;
        int sumAge = 0;
        int count = 0;
        for (Passenger p : passengers) {
            if (p.getSex().equals("male") && p.getSurvived() == survived) {
                sumAge += p.getAge();
                count++;
            }
        }
        return sumAge / count;
    }
}
