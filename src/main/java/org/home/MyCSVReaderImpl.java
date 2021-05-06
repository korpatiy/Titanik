package org.home;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.home.entity.Passenger;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyCSVReaderImpl implements MyCSVReader {

    private List<Passenger> passengers;
    private CSVReader reader;

    @Override
    public List<Passenger> readAllFromLine(String fileName, int line) throws IOException, CsvException {
        reader = new CSVReaderBuilder(new FileReader(fileName))
                .withSkipLines(line)
                .build();
        readToList();
        return passengers;
    }

    /*@Override
    public void readToBean(String fileName) throws IOException {
        Reader reader = Files.newBufferedReader(Path.of(fileName));
        passengers = new CsvToBeanBuilder(reader)
                .withType(Passenger.class)
                .build()
                .parse();
    }*/

    /**
     * Построчно читает файл, преобразуя строку в {@link Passenger}
     */
    private void readToList() throws IOException, CsvException {
        String[] line;
        passengers = new ArrayList<>();
        while ((line = reader.readNext()) != null) {
            Passenger p = new Passenger();
            p.setSurvived(Integer.parseInt(line[1]));
            p.setName(line[3]);
            p.setSex(line[4]);
            p.setAge((tryParseInt(line[5])));
            passengers.add(p);
        }
        reader.close();
    }

    /**
     * Проверяет строку на пустоту
     *
     * @param value входящая строка
     * @return приведенное значение или -1 по умолчанию (чтобы не учитывать таких пассажиров)
     */
    private int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
