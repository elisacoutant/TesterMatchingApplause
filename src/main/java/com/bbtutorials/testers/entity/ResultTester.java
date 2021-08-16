package com.bbtutorials.testers.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Comparator;


@Entity
public class ResultTester {

    @Id
    private String deviceName;

    private int testerId;

    private int numberOfBugs;

    private String name;


    public ResultTester(int testerId ,String deviceName, int numberOfBugs, String name) {
        this.deviceName = deviceName;
        this.testerId = testerId;
        this.numberOfBugs = numberOfBugs;
        this.name = name;

    }

    public String getDeviceId() {
        return deviceName;
    }

    public void setDeviceId(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getTesterId() {
        return testerId;
    }

    public void setTesterId(int testerId) {
        this.testerId = testerId;
    }

    public int getNumberOfBugs() {
        return numberOfBugs;
    }

    public void setNumberOfBugs(int numberOfBugs) {
        this.numberOfBugs = numberOfBugs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(int compareTester) {
        int compareQuantity = compareTester;
        return compareQuantity - compareTester ;
    }

    public static Comparator<ResultTester> testerComparator= new Comparator<ResultTester>() {


        public int compare(ResultTester tester1, ResultTester tester2) {

            Integer numOfBugs = tester1.getNumberOfBugs();
            Integer numOfBugs2 =  tester2.getNumberOfBugs();

            return numOfBugs.compareTo(numOfBugs2);
        }

    };

}

