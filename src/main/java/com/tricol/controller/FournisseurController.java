package com.tricol.controller;

import com.tricol.model.Fournisseur;
import com.tricol.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fournisseurs")
public class FournisseurController {

    private final FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    // GET /api/v1/fournisseurs - Get all fournisseurs
    @GetMapping
    public ResponseEntity<List<Fournisseur>> getAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurService.getAllFournisseurs();
        return ResponseEntity.ok(fournisseurs);
    }

    // GET /api/v1/fournisseurs/{id} - Get one fournisseur by ID
    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable Long id) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(id);
        if (fournisseur != null) {
            return ResponseEntity.ok(fournisseur);
        }
        return ResponseEntity.notFound().build();
    }

    // POST /api/v1/fournisseurs - Create a new fournisseur
    @PostMapping
    public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur) {
        Fournisseur saved = fournisseurService.saveFournisseur(fournisseur);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT /api/v1/fournisseurs/{id} - Update a fournisseur
    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(
            @PathVariable("id") Long id,
            @RequestBody Fournisseur fournisseur) {

        Fournisseur existing = fournisseurService.getFournisseurById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        fournisseur.setId(id);
        Fournisseur updated = fournisseurService.saveFournisseur(fournisseur);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/v1/fournisseurs/{id} - Delete a fournisseur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable("id") Long id) {
        Fournisseur existing = fournisseurService.getFournisseurById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        fournisseurService.deleteFournisseur(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<Fournisseur> getContact(@PathVariable("name") String name) {
        Fournisseur fournisseur = fournisseurService.getByContact(name);
        if (fournisseur != null) {
            return ResponseEntity.ok(fournisseur);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Fournisseur>> getByEmail(@PathVariable("email") String email) {
        List<Fournisseur> list = fournisseurService.getByDomainName(email);
        if (list != null) {
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.notFound().build();
    }


}