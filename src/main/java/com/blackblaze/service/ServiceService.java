package com.blackblaze.service;

import com.blackblaze.model.ServiceEntity;
import com.blackblaze.repository.ServiceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    private final Logger logger;
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.logger = LoggerFactory.getLogger(this.getClass());
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceEntity> getAllServices() {
        var data = serviceRepository.findAll();
        logger.info("Result Data -> {}", data);
        return data;
    }

    public ServiceEntity getServiceById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }

    public void saveService(ServiceEntity service) {
        serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}