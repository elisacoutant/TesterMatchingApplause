package com.bbtutorials.users;

import com.bbtutorials.users.entity.Bug;
import com.bbtutorials.users.repository.BugRepository;
import com.bbtutorials.users.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Bugs {

    //Map of testerID to the map of ( device : number of bugs)
    public static HashMap<Integer, HashMap<Integer, Integer>> bugs =  new HashMap<Integer, HashMap<Integer, Integer>>();

    @Autowired
    BugService bugService;

    public void parseCSV() throws IOException {

        String line = "";
        String splitBy = ",";
        Boolean firstLine = true;
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        try {
            BufferedReader br = new BufferedReader(new FileReader(s + "/src/main/java/com/bbtutorials/users/bugs.csv"));
            while ((line = br.readLine()) != null)
            {
                if(!firstLine) {
                    String[] bug = line.split(splitBy);
                    int bugId =  Integer.parseInt(bug[0].replace("\"", ""));
                    int deviceId =  Integer.parseInt(bug[1].replace("\"", ""));
                    int testerId =  Integer.parseInt(bug[2].replace("\"", ""));

                    //tester is already in the map
                    if(bugs.get(testerId) != null){
                        HashMap<Integer, Integer> devicesToBugs = bugs.get(testerId);
                        if(devicesToBugs.get(deviceId) != null){
                            int numberOfBugs = devicesToBugs.get(deviceId) + 1;
                            devicesToBugs.put(deviceId, numberOfBugs);
                        }
                        else{
                            devicesToBugs.put(deviceId, 1);
                        }
                        bugs.put(testerId, devicesToBugs);
                    }
                    //tester is not in the map
                    else{
                        HashMap<Integer, Integer> devicesToBugs =  new HashMap<Integer, Integer>();
                        devicesToBugs.put(deviceId, 1);

                        bugs.put(testerId, devicesToBugs);
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
