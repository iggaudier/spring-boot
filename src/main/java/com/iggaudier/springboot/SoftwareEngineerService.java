package com.iggaudier.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer updateSoftwareEngineerById(Integer id, SoftwareEngineer softwareEngineer) {
        SoftwareEngineer existing = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Software Engineer with ID " + id + " not found"));

        existing.setName(softwareEngineer.getName());
        existing.setTechStack(softwareEngineer.getTechStack());

        return softwareEngineerRepository.save(existing);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        id + " not found"));
    }

    public SoftwareEngineer deleteSoftwareEngineerById(Integer id) {
        SoftwareEngineer engineer = softwareEngineerRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException(
                        "Software Engineer with ID " + id + " not found"));

        softwareEngineerRepository.delete(engineer);
        return engineer;
    }
}
