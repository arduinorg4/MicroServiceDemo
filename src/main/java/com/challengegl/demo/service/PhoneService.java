package com.challengegl.demo.service;

import com.challengegl.demo.model.Phone;
import com.challengegl.demo.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public Phone createPhone(Phone phone) {
        return phoneRepository.save(phone);
    }

}
