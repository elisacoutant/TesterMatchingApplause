package com.bbtutorials.users.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.bbtutorials.users.TesterDevices;
import com.bbtutorials.users.Testers;
import com.bbtutorials.users.entity.ResultTester;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbtutorials.users.links.AppLinks;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/")
public class TestersController {

    @PostMapping(value =  AppLinks.LIST_TESTERS)
    public ResponseEntity<?> getTesters(@RequestBody String search) throws IOException, ParseException {
        TesterDevices validTesters = new TesterDevices();
        List<ResultTester> resource = new ArrayList<ResultTester>();

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(search);

        List<String> countries = (ArrayList<String>)json.get("country");
        List<String> devices   = (ArrayList<String>)json.get("device");

        if(countries.size() > 0 && devices.size() > 0) {
            resource = validTesters.searchTesters(countries, devices);
        }
        return ResponseEntity.ok(resource);
    }

    @GetMapping(path = AppLinks.GET_COUNTRIES)
    public ResponseEntity<?> getCountries() {
        Set<String> resource = Testers.countries;
        return ResponseEntity.ok(resource);
    }

}
