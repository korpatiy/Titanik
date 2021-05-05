package org.home;

import org.home.entity.Passenger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCSVWorkerImpl implements MyCSVWorker {

    @Override
    public Map<Integer, Integer> getNameCountMap(List<Passenger> passengers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Passenger p : passengers) {
            map.compute(p.getName().length(), (k, v) -> v == null ? 1 : v + 1);
        }
        return map;
    }

    @Override
    public int getAvgAgeBy(List<Passenger> passengers, String sex) {
        int survived = 1;
        if (sex.equals("male"))
            survived = 0;
        int sumAge = 0;
        int count = 0;
        for (Passenger p : passengers) {
            if (p.getSex().equals(sex) && p.getSurvived() == survived) {
                sumAge += p.getAge();
                count++;
            }
        }
        return sumAge / count;
    }
}
