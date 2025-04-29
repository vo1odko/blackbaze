package com.blackblaze.service;

import com.blackblaze.model.CaseEntity;
import com.blackblaze.repository.AdviceRepository;
import com.blackblaze.repository.CaseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {
    private final Logger logger;
    private final CaseRepository adviceRepository;

    public CaseService(CaseRepository serviceRepository) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.adviceRepository = serviceRepository;
    }

    public List<CaseEntity> getAllServices() {
        return adviceRepository.findAll();
    }

    public CaseEntity getServiceById(Long id) {
        return adviceRepository.findById(id).orElse(null);
    }

    public void saveService(CaseEntity service) {
        adviceRepository.save(service);
    }

    public void deleteService(Long id) {
        adviceRepository.deleteById(id);
    }

    public Object getAdviceForPage(String page) {
        return null;
    }

    public Object getAllCase() {
        return adviceRepository.findAll();
    }

    public Object getCaseById(Long caseId) {
        return adviceRepository.findById(caseId).orElse(null);
    }
}