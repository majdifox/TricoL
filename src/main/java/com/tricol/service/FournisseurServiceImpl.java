package com.tricol.service;

import com.tricol.model.Fournisseur;
import com.tricol.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    private final FournisseurRepository repository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository repository) {
        this.repository = repository;
    }

    @Override
    public Fournisseur saveFournisseur(Fournisseur fournisseur) {
        return repository.save(fournisseur);
    }

    @Override
    public List<Fournisseur> getAllFournisseurs() {
        return repository.findAll();
    }

    @Override
    public Fournisseur getFournisseurById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteFournisseur(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Fournisseur getByContact(String contact){

        return repository.findByContact(contact);


    }



    @Override
    public List<Fournisseur> getByDomainName(String domain){

        return repository.findByEmailEndingWith(domain);
    }





}