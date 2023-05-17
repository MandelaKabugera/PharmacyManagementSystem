package com.example.serviceImplementation;

import com.example.model.Medecine;
import com.example.repository.MedecineRepository;
import com.example.service.MedecineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class MedecineImplementationService implements MedecineService {
    @Autowired
    MedecineRepository repo;
    @Override
    public Medecine saveMedecine(Medecine medecine) {
        return repo.save(medecine);
    }

    @Override
    public List<Medecine> displayMedecines() {
        return repo.findAll();
    }

    @Override
    public Medecine findMedecineById(Medecine medecine) {
        return repo.findById(medecine.getId()).orElse(null);
    }

    @Override
    public Medecine updateMedecine(Medecine medecine) {
        Medecine savedMedecine = repo.findById(medecine.getId()).orElse(null);
        if (savedMedecine!=null){
            savedMedecine.setMedecine_name(medecine.getMedecine_name());
            savedMedecine.setMedecine_number(medecine.getMedecine_number());
            savedMedecine.setMedecine_price(medecine.getMedecine_price());
            savedMedecine.setMedecine_price(medecine.getMedecine_price());
            savedMedecine.setManfactured_date(medecine.getManfactured_date());
            return repo.save(savedMedecine);
        }
        return repo.save(medecine);
    }

    @Override
    public void deleteMedecine(Medecine medecine) {
        Medecine savedMedecine = repo.findById(medecine.getId()).orElse(null);
        if (savedMedecine!=null){
            repo.delete(savedMedecine);
        }
    }
}
