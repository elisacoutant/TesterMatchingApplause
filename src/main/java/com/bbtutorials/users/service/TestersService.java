package com.bbtutorials.users.service;

import java.io.IOException;
import java.util.List;

import com.bbtutorials.users.CSV;
import com.bbtutorials.users.entity.Tester;
import com.bbtutorials.users.repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
public class TestersService {

	private TesterRepository testerRepository;

    public TestersService(TesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    public void save(MultipartFile file) {
        try {
            List<Tester> testers = CSV.parseCSV(file.getInputStream());
            testerRepository.saveAll(testers);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public List<Tester> getAllTesters() {
        return testerRepository.findAll();
    }

}
