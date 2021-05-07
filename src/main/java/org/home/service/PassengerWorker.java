package org.home.service;

import org.home.entity.Passenger;

import java.util.Map;
import java.util.function.Predicate;

/**
 * Предоставляет методы для работы с csv титаника
 */
public interface PassengerWorker extends MyCSVWorker{

    /**
     * Пробегается по данным, собирая кол-во символов в имени и кол-во таких имен в Map
     *
     * @return Map, где ключ - количество символов в имени, а значение - количество таких имен.
     */
    Map<Integer, Integer> getNameCountMap();

    /**
     * Выполняет подсчет среднего возраста по заданному предикату
     * @param predicate задаваемый предикат
     * @return среднее значение возраста int
     */
    int getAvgAgeBy(Predicate<Passenger> predicate);
}
