package org.home;

import com.opencsv.exceptions.CsvException;
import org.home.entity.Passenger;

import java.io.IOException;
import java.util.List;

public interface MyCSVReader {

    /**
     * Выполняет чтение, начиная с указанной строки
     * и преобразует данные в список {@link Passenger}
     *
     * @param fileName имя файла
     * @param line     указываемая строка
     * @return список пассажиров
     */
    List<Passenger> readAllFromLine(String fileName, int line) throws IOException, CsvException;

    //void readToBean(String fileName) throws IOException;
}
