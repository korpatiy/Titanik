package org.home.reader_api;

import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.List;

/**
 * Предоставляет методы для чтения построчно
 */
public interface MyCSVLineReader extends MyCSVReader {

    /**
     * Выполняет чтение, начиная с указанной строки
     * и преобразует данные в список {@link T}
     *
     * @param fileName имя файла
     * @param line     указываемая строка
     * @return список пассажиров
     */
    <T> List<T> readAllFromLine(String fileName, int line) throws IOException, CsvException;
}
