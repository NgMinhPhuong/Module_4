package com.codegym.phonemanagementajaxwebservice.service.impl;

import com.codegym.phonemanagementajaxwebservice.model.Smartphone;
import com.codegym.phonemanagementajaxwebservice.repository.ISmartphoneRepository;
import com.codegym.phonemanagementajaxwebservice.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class SmartphoneService implements ISmartphoneService {
    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return iSmartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartPhone) {
        Optional<Smartphone> optionalSmartphone = iSmartphoneRepository.findById(smartPhone.getId());
        if (optionalSmartphone.isPresent()) {
            Smartphone existingSmartphone = optionalSmartphone.get();
            existingSmartphone.setProducer(smartPhone.getProducer());
            existingSmartphone.setModel(smartPhone.getModel());
            existingSmartphone.setPrice(smartPhone.getPrice());
            return iSmartphoneRepository.save(existingSmartphone);
        } else {
            return iSmartphoneRepository.save(smartPhone);
        }
    }

    @Override
    public void remove(Long id) {
        iSmartphoneRepository.deleteById(id);
    }
}
