package org.home;

import com.opencsv.exceptions.CsvException;
import org.home.reader_api.BeanReaderImpl;
import org.home.reader_api.MyCSVBeanReader;
import org.home.entity.Passenger;
import org.home.service.PassengerWorker;
import org.home.service.PassengerWorkerBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) throws IOException, CsvException {

        //Чтение построчно в бин
        /*MyCSVLineReader reader = new PassengerLineReader();
        reader.readAllFromLine("src/main/resources/data.csv", 1);*/

        //Чтение с автопарсом в бин
        MyCSVBeanReader beanReader = new BeanReaderImpl();
        List<Passenger> passengers = beanReader.readToBean("src/main/resources/data.csv", Passenger.class);

        //Хотелось сделать что-то универсальное, чтобы работать с любыми csv. Под каждый можно было бы реализовать свой api
        PassengerWorkerBuilder builder = () -> passengers;
        PassengerWorker passengerWorker = builder.build();

        Predicate<Passenger> diedMales = p -> p.getSex().equals("male") && p.getSurvived() == 0 && p.getAge() != 0;
        Predicate<Passenger> survivedFemales = p -> p.getSex().equals("female") && p.getSurvived() == 1 && p.getAge() != 0;

        Map<Integer, Integer> nameCountMap = passengerWorker.getNameCountMap();
        System.out.println(passengerWorker.getAvgAgeBy(diedMales));
        System.out.println(passengerWorker.getAvgAgeBy(survivedFemales));

        /*MyCSVWorker worker = new MyCSVWorkerImpl(passengers);
        Map<Integer, Integer> nameCountMap = worker.getNameCountMap(passengers);
        System.out.println(worker.getAvgAgeBy(passengers, "male"));
        System.out.println(worker.getAvgAgeBy(passengers, "female"));*/
    }
}
