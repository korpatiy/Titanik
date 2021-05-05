package org.home;

import com.opencsv.exceptions.CsvException;
import org.home.entity.Passenger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {
        MyCSVReader reader = new MyCSVReaderImpl();
        List<Passenger> passengers = reader.readAllFromLine("src/main/resources/data.csv", 1);
        MyCSVWorker worker = new MyCSVWorkerImpl();
        Map<Integer, Integer> nameCountMap = worker.getNameCountMap(passengers);
        System.out.println(worker.getAvgAgeBy(passengers, "male"));
        System.out.println(worker.getAvgAgeBy(passengers, "female"));
    }
}
