package com.tricol.service;

import com.tricol.model.Fournisseur;
import java.util.List;

public interface FournisseurService {
    Fournisseur saveFournisseur(Fournisseur fournisseur);
    List<Fournisseur> getAllFournisseurs();
    Fournisseur getFournisseurById(Long id);
}