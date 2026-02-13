package fr.iut_orsay.transverse.models;

import java.util.*;

public class MaisonInternationale {

    //---------------------------------------------------
    // ATTRIBUTS
    //---------------------------------------------------
    private Collection<Service> services;
    private String adresse;

    //---------------------------------------------------
    // CONSTRUCTEUR
    //---------------------------------------------------
    public MaisonInternationale(String adresse) {
        this.adresse = adresse;
        this.services = new ArrayList<>(); // Initialisation de la collection des services
    }
    
    //---------------------------------------------------
    // METHODES
    //---------------------------------------------------
    public void ajouterService(Service service) {
        services.add(service); // Ajoute un service à la collection des services de la maison
    }

    public void afficherServices() {
        if (services.isEmpty()) { // Vérifie si la collection de services est vide.
            System.out.println("Aucun service disponible.");
        } else {
            System.out.println("Services disponibles dans la Maison Internationale :");
            for (Service service : services) {
                service.afficherInfos();  // Appelle la méthode afficherInfos() sur chaque objet service pour afficher ses détails.
            }
        }
    }
    
    //---------------------------------------------------
    // ACCESSEURS
    //---------------------------------------------------
    public String getAdresse() {
        return this.adresse;
    }

    public Etudiant[] getListeEtudiants() {
        return new Etudiant[0]; 
    }

    public Service[] getListeServices() {
        return services.toArray(new Service[0]); // Convertit la collection de services en tableau d'objets Service
    }
}
