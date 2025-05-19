package com.blackblaze.service;

import com.blackblaze.model.AdviceEntity;
import com.blackblaze.repository.AdviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AdviceService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AdviceRepository adviceRepository;

    public AdviceService(AdviceRepository adviceRepository) {
        this.adviceRepository = adviceRepository;
    }

    public List<AdviceEntity> getAllServices() {
        return adviceRepository.findAll();
    }

    public AdviceEntity getServiceById(String id) {
        return adviceRepository.findById(id).orElse(null);
    }

    public void deleteService(String id) {
        logger.info("Deleting service with ID: {}", id);
        adviceRepository.deleteById(id);
    }

    public Map<String, String> getAdviceForPage(String page) {
        logger.info("Searching for service with name: {}", page);
        Optional<AdviceEntity> serviceOpt = adviceRepository.findById(page);
        if (serviceOpt.isEmpty()) {
            logger.warn("Service not found for page: {}", page);
            return Map.of(
                    "serviceName", "Услуга не найдена",
                    "serviceDescription", "Описание недоступно",
                    "serviceDuration", "Н/Д",
                    "servicePrice", "Н/Д",
                    "img1","/images/test-1.jpg",
                    "img2","/images/test-2.jpg"
            );
        }

        AdviceEntity service = serviceOpt.get();
        logger.info("Found service: {}", service.getServiceName());

        Map<String, String> data = new HashMap<>();
        data.put("serviceName", service.getServiceName());
        data.put("serviceDescription", service.getServiceDescription());
        data.put("serviceDuration", service.getServiceDuration());
        data.put("servicePrice", service.getServicePrice());
        data.put("img1","/images/test-1.jpg");
        data.put("img2","/images/test-2.jpg");
        return data;
    }

    public List<AdviceEntity> getAllCase() {
        return adviceRepository.findAll();
    }

    public AdviceEntity getCaseById(String caseId) {
        return adviceRepository.findById(caseId).orElse(null);
    }
}