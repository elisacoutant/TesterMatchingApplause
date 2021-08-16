package com.bbtutorials.users.controller;

import com.bbtutorials.users.Devices;
import com.bbtutorials.users.links.AppLinks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/")
public class DeviceController {

    @GetMapping(path = AppLinks.GET_DEVICES)
    public ResponseEntity<?> getDevices() {
        Map<Integer, String> resource = Devices.devices;
        return ResponseEntity.ok(resource);
    }
}
