package com.bbtutorials.users;

import com.bbtutorials.users.entity.Bug;
import com.bbtutorials.users.entity.Device;
import com.bbtutorials.users.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Devices {

    public static Map<Integer, String> devices =  new HashMap<Integer, String>();


    public void parseCSV() throws IOException {

        String line = "";
        String splitBy = ",";
        Boolean firstLine = true;
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        try {
            BufferedReader br = new BufferedReader(new FileReader(s + "/src/main/java/com/bbtutorials/users/devices.csv"));
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
