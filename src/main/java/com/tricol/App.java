package com.tricol;

import com.tricol.model.Fournisseur;
import com.tricol.service.FournisseurService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Load Spring configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/web.xml");

        // Get the service from Spring
        FournisseurService service = context.getBean(FournisseurService.class);

        // Create a new Fournisseur
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setSociete("TechSupply SARL");
        fournisseur.setAdresse("123 Rue Mohammed V");
        fournisseur.setContact("Ahmed Benali");
        fournisseur.setEmail("contact@techsupply.ma");
        fournisseur.setTelephone("0522123456");
        fournisseur.setVille("Casablanca");
        fournisseur.setIce("001234567891234");

        // Save to database
        System.out.println("=== Saving Fournisseur ===");
        Fournisseur savedFournisseur = service.saveFournisseur(fournisseur);
        System.out.println("Saved with ID: " + savedFournisseur.getId());

        // Retrieve all fournisseurs
        System.out.println("\n=== All Fournisseurs ===");
        List<Fournisseur> fournisseurs = service.getAllFournisseurs();
        for (Fournisseur f : fournisseurs) {
            System.out.println("ID: " + f.getId() +
                    ", Société: " + f.getSociete() +
                    ", Ville: " + f.getVille());
        }

        // Retrieve by ID
        System.out.println("\n=== Get Fournisseur by ID ===");
        Fournisseur found = service.getFournisseurById(savedFournisseur.getId());
        if (found != null) {
            System.out.println("Found: " + found.getSociete() +
                    " - " + found.getEmail());
        }
    }
}