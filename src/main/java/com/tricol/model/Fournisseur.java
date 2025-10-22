package com.tricol.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fournisseurs")

public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String societe;
    private String adresse;
    private String contact;
    private String email;
    private String telephone;
    private String ville;

    @Column(unique = true)
    private String ice;

//constructor
public Fournisseur(){

}


}
