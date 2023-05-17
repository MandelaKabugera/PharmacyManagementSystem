package com.example.service;

import com.example.model.Medecine;

import java.util.List;

public interface MedecineService {
    Medecine saveMedecine(Medecine medecine);
    List<Medecine> displayMedecines();
    Medecine findMedecineById(Medecine medecine);
    Medecine updateMedecine(Medecine medecine);
    void deleteMedecine(Medecine medecine);
}
