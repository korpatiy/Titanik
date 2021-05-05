package org.home;

import org.home.entity.Passenger;

import java.util.List;
import java.util.Map;

public interface MyCSVWorker {

    /**
     * Пробегается по данным, собирая кол-во символов в имени и кол-во таких имен в Map
     *
     * @param passengers лист пассажиров
     * @return Map, где ключ - количество символов в имени, а значение - количество таких имен.
     */
    Map<Integer, Integer> getNameCountMap(List<Passenger> passengers);

    /**
     * Выполняет подсчет среднего возраста по полу
     * @param passengers лист пассажиров
     * @param sex пол
     * @return средний возраст
     */
    int getAvgAgeBy(List<Passenger> passengers, String sex);
}
