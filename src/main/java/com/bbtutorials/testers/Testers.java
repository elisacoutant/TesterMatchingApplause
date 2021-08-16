package com.bbtutorials.testers;

import com.bbtutorials.testers.entity.Tester;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Testers {

    //Map of testerId to tester object
    public static Map<Integer, Tester> testers =  new HashMap<Integer, Tester>();
    public static Set<String> countries =  new HashSet<>();

    public void parseCSV() throws IOException {

        String line = "";
        String splitBy = ",";
        Boolean firstLine = true;
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        try {
            BufferedReader br = new BufferedReader(new FileReader(s + "/src/main/java/com/bbtutorials/testers/csv/testers.csv"));
            while ((line = br.readLine()) != null)
            {
                if(!firstLine) {
                    String[] bug = line.split(splitBy);
                    int testerId =  Integer.parseInt(bug[0].replace("\"", ""));
                    String firstName =  bug[1].replace("\"", "");
                    String lastName =  bug[2].replace("\"", "");
                    String country =  bug[3].replace("\"", "");
                    String lastLogin =  bug[4].replace("\"", "");

                    Tester t = new Tester(testerId, firstName, lastName,country ,lastLogin);
                    testers.put(testerId, t);

                    if(!countries.contains(country)){
                        countries.add(country);
                    }
                }
                firstLine = false;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
