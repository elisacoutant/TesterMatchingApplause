package com.bbtutorials.users.service;

import com.bbtutorials.users.CSV;
import com.bbtutorials.users.entity.Bug;
import com.bbtutorials.users.repository.BugRepository;
import com.bbtutorials.users.repository.TesterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component

public class BugService {

    @Autowired
    private BugRepository bugRepository;

    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public void save(List<Bug> bugs) {
        bugRepository.saveAll(bugs);
    }

//    public List<Tester> getAllTesters() {
//        return testerRepository.findAll();
//    }
}
