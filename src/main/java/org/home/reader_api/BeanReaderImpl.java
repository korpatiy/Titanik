package org.home.reader_api;

import com.opencsv.bean.CsvToBeanBuilder;
import org.home.reader_api.MyCSVBeanReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Реализация чтения в бин
 */
public class BeanReaderImpl implements MyCSVBeanReader {

    @Override
    public <T> List<T> readToBean(String fileName, Class<T> tClass) throws IOException {
        List<T> tList = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(tClass)
                .build()
                .parse();
        return tList;
    }
}
