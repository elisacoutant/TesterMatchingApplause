package com.bbtutorials.testers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.bbtutorials.testers.TesterDevices;
import com.bbtutorials.testers.Testers;
import com.bbtutorials.testers.entity.ResultTester;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bbtutorials.testers.links.AppLinks;

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

        if(countries != null && countries.size() > 0 && devices != null && devices.size() > 0) {
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
