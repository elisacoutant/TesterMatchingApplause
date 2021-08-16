package com.bbtutorials.users;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import java.io.*;


@Component
@Configurable
public class Startup {

    public void runAfterStartup() throws IOException {
        Bugs bg = new Bugs();
        Devices d = new Devices();
        Testers t = new Testers();
        TesterDevices td = new TesterDevices();

        bg.parseCSV();
        d.parseCSV();
        t.parseCSV();
        td.parseCSV();
    }
}