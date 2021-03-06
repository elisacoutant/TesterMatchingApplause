package com.bbtutorials.testers;

import com.bbtutorials.testers.entity.ResultTester;
import com.bbtutorials.testers.entity.Tester;
import com.bbtutorials.testers.entity.TesterDevice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TesterDevices {

    public static List<TesterDevice> testerDevices = new ArrayList<>();

    public List<ResultTester> searchTesters(List<String> countries, List<String> devices){
        List<ResultTester> validTesters = new ArrayList<ResultTester>();

        //Handle case for all
        if(countries.contains("All")){
            countries.clear();
            countries.addAll(Testers.countries);
        }

        //Handle case for all
        if(devices.contains("All")){
            devices.clear();
            devices.addAll(Devices.devices.values());
        }

        //Iterate through testers to get the ones from a certain country
        List<Integer> testerCountryIDs = getTesterCountries(countries);

        //Get all the devices a user can test on
        Map<Integer, List<Integer>> testerDevices = getTesterDevices(testerCountryIDs, devices);

        for(int testerId : testerDevices.keySet()){
            List<Integer> possibleDevices = testerDevices.get(testerId);

            if(Bugs.bugs.get(testerId) != null){
                HashMap<Integer, Integer> numberOfBugsOnDevice = Bugs.bugs.get(testerId);
                if(possibleDevices != null && numberOfBugsOnDevice != null) {
                    for (int devs = 0; devs < possibleDevices.size(); devs++) {
                        int currDeviceID = possibleDevices.get(devs);
                        if (numberOfBugsOnDevice.containsKey(currDeviceID)) {
                            String name = Testers.testers.get(testerId).getFirstName() + " " + Testers.testers.get(testerId).getLastName();
                            String deviceName = Devices.devices.get(currDeviceID);
                            ResultTester result = new ResultTester(testerId, deviceName, numberOfBugsOnDevice.get(currDeviceID), name);
                            validTesters.add(result);
                        }
                    }
                }
            }
        }

        validTesters.sort(ResultTester.testerComparator);

        return validTesters;
    }

    public List<Integer> getTesterCountries(List<String> countries){
        //Iterate through testers to get the ones from a certain country
        List<Integer> testerCountryIDs = new ArrayList<Integer>();
        for(int testerID: Testers.testers.keySet()){
            Tester t = Testers.testers.get(testerID);
            if(countries.contains(t.getCountry())){
                testerCountryIDs.add(t.getId());
            }
        }

        return testerCountryIDs;
    }

    public HashMap<Integer, List<Integer>> getTesterDevices(List<Integer> testerCountryIDs, List<String> searchDevices){
        HashMap<Integer, List<Integer>> searchTesterDevices = new HashMap<Integer, List<Integer>>();

        for(int y = 0 ; y < TesterDevices.testerDevices.size(); y ++){
            TesterDevice d = TesterDevices.testerDevices.get(y);

            if(testerCountryIDs.contains(d.getTesterID())){
                if(testerDevices.get(d.getTesterID()) != null) {
                    List<Integer> devices = searchTesterDevices.get(d.getTesterID());
                    if (searchDevices.contains(Devices.devices.get(d.getDeviceID()))) {
                        if (devices != null) {
                            devices.add(d.getDeviceID());
                            searchTesterDevices.put(d.getTesterID(), devices);
                        } else {
                            List<Integer> newDevicesList = new ArrayList<Integer>();
                            newDevicesList.add(d.getDeviceID());
                            searchTesterDevices.put(d.getTesterID(), newDevicesList);
                        }
                    }
                }
            }
        }

        return searchTesterDevices;
    }

    public void parseCSV() throws IOException {

        String line = "";
        String splitBy = ",";
        Boolean firstLine = true;
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        try {
            BufferedReader br = new BufferedReader(new FileReader(s + "/src/main/java/com/bbtutorials/testers/csv/tester_device.csv"));
            while ((line = br.readLine()) != null)
            {
                if(!firstLine) {
                    String[] bug = line.split(splitBy);
                    int testerId =  Integer.parseInt(bug[0].replace("\"", ""));
                    int deviceId =  Integer.parseInt(bug[1].replace("\"", ""));

                    TesterDevice t = new TesterDevice(testerId, deviceId);
                    testerDevices.add(t);
                }
                firstLine = false;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
