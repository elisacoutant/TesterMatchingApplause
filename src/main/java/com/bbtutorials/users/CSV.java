package com.bbtutorials.users;


import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.bbtutorials.users.entity.Tester;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSV {
    public static String TYPE = "text/csv";
    static String[] TESTER_HEADERS = { "testerId", "firstName", "lastName", "country", "lastLogin" };

    public static List<Tester> parseCSV(InputStream is){
        try{
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));

             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

            List<Tester> testers = new ArrayList<Tester>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                System.out.println(csvRecord.toString());
                Tester tester = new Tester(
                        Integer.parseInt(csvRecord.get("testerId")),
                        csvRecord.get("firstName"),
                        csvRecord.get("lastName"),
                        csvRecord.get("country"),
                        csvRecord.get("lastLogin")
                );

                testers.add(tester);
            }

            System.out.println("TESTERS" + testers);

            return testers;
        } catch (IOException  e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }


}
