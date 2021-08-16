package com.bbtutorials.testers;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class Devices {

    public static Map<Integer, String> devices =  new HashMap<Integer, String>();


    public void parseCSV()  {

        String line = "";
        String splitBy = ",";
        Boolean firstLine = true;
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        try {
            BufferedReader br = new BufferedReader(new FileReader(s + "/src/main/java/com/bbtutorials/testers/csv/devices.csv"));
            while ((line = br.readLine()) != null)
            {
                if(!firstLine) {
                    String[] device = line.split(splitBy);
                    int deviceId =  Integer.parseInt(device[0].replace("\"", ""));
                    String description =  device[1].replace("\"", "");

                    devices.put(deviceId, description);
                }
                firstLine = false;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }




}
