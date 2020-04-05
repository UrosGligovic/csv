/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ugligovic.csvparser;

import rs.ugligovic.csvparser.exception.BadCsvException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author UrosGligovic
 */
public class Csv {

    private Stream<Map<String, String>> stream;
    private String delimiter = ",";
    private final Map<Integer, String> columnIndexMap = new HashMap<>();

    public Csv(String path) throws BadCsvException, IOException {
        this(path, null);
    }

    public Csv(String path, String userDelimiter) throws BadCsvException, IOException {
        this(path, userDelimiter, StandardCharsets.UTF_8);
    }

    public Csv(String path, String userDelimiter, Charset charset) throws BadCsvException, IOException {

        String firstLine = Files.lines(Paths.get(path), charset).findFirst().orElse(null);

        if (firstLine == null || firstLine.equals("")) {
            System.out.println("First line of the file at " + path + " is empty");
            throw new BadCsvException("First line of the file at " + path + " is empty, columns need to be specified");
        }

        if (userDelimiter != null) {
            delimiter = userDelimiter;
        }

        String[] firstLineSplitted = firstLine.split(delimiter);
        for (int i = 0; i < firstLineSplitted.length; i++) {
            columnIndexMap.put(i, firstLineSplitted[i]);
        }

        this.stream = Files.lines(Paths.get(path), charset)
                .skip(1)
                .map(x -> x.split(delimiter))
                .map(x -> mapToColumnMap(x));

    }

    public Stream<Map<String, String>> stream() {
        return this.stream;
    }

    public ArrayList<String> getColumns() {
        return new ArrayList(this.columnIndexMap.values());
    }

    private Map<String, String> mapToColumnMap(String[] row) {

        Map<String, String> resultMap = new HashMap<>();

        for (int i = 0; i < row.length; i++) {
            resultMap.put(columnIndexMap.get(i), row[i]);
        }
        return resultMap;
    }
}
