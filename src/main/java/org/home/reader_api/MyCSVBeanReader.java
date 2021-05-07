package org.home.reader_api;

import java.io.IOException;
import java.util.List;

/**
 * Предоставляет универсальный преобразователь csv to bean
 */
public interface MyCSVBeanReader extends MyCSVReader {

    /**
     * Выполняет преобразование CSV файла в Bean
     *
     * @param fileName имя файла
     * @param tClass   объект, представляющий Bean
     * @param <T>      тип объекта
     * @return список объектов {@link T}
     * @throws IOException
     */
    <T> List<T> readToBean(String fileName, Class<T> tClass) throws IOException;
}
