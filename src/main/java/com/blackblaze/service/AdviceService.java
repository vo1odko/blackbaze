package com.blackblaze.service;

import com.blackblaze.model.AdviceEntity;
import com.blackblaze.model.CaseEntity;
import com.blackblaze.repository.AdviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdviceService {
    private final Logger logger;
    private final AdviceRepository adviceRepository;

    public AdviceService(AdviceRepository serviceRepository) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.adviceRepository = serviceRepository;
    }

    public List<AdviceEntity> getAllServices() {
        return adviceRepository.findAll();
    }

    public AdviceEntity getServiceById(Long id) {
        return adviceRepository.findById(id).orElse(null);
    }


    public void deleteService(Long id) {
        adviceRepository.deleteById(id);
    }

    public Map<String, String> getAdviceForPage(String page) {
        return Map.of("serviceName", page, "serviceDescription", page, "serviceDuration", page, "servicePrice", page);
    }

    public Object getAllCase() {
        return adviceRepository.findAll();
    }

    public Object getCaseById(Long caseId) {
        return adviceRepository.findById(caseId).orElse(null);
    }
}