package fr.iut_orsay.transverse.models;

import java.util.*;

public class Maison {

    //---------------------------------------------------
    // ATTRIBUTS
    //---------------------------------------------------
    private Collection<Etudiant> lesEtudiants;
    private Collection<Evenement> lesEvenements;
    private String nom;
    private String adresse;
    private int capaciteMax;
    private String nationalitePrincipale;
    private String directeur;
    private Collection<Etudiant> listeAttente;

    //---------------------------------------------------
    // CONSTRUCTEUR
    //---------------------------------------------------
    public Maison(String nom, String adresse, int capaciteMax, String nationalitePrincipale, String directeur) {
        this.nom = nom;
        this.adresse = adresse;
        this.capaciteMax = capaciteMax;
        this.nationalitePrincipale = nationalitePrincipale;
        this.directeur = directeur;
        this.lesEtudiants = new ArrayList<>(); // Initialisation de la collection des étudiants
        this.listeAttente = new ArrayList<>(); // Initialisation de la liste d'attente
        this.lesEvenements = new ArrayList<>(); // Initialisation de la collection des événements
    }

    //---------------------------------------------------
    // METHODES
    //---------------------------------------------------
    public void inscrireEtudiant(Etudiant etudiant) {
        if (!estPleine()) {
            lesEtudiants.add(etudiant); // Ajout de l'étudiant si la maison n'est pas pleine
            System.out.println("L'étudiant " + etudiant.getNom() + " a été inscrit.");
        } else {
            listeAttente.add(etudiant); // Ajout de l'étudiant en liste d'attente si la maison est pleine
            System.out.println("La maison est pleine. L'étudiant " + etudiant.getNom() + " a été mis en liste d'attente.");
        }
    }
    
    public void supprimerEtudiant(Etudiant e) {
        if (lesEtudiants.remove(e)) { // Si l'étudiant est supprimé de la liste des étudiants
            if (!listeAttente.isEmpty()) { // Si la liste d'attente n'est pas vide
                Etudiant etudiantAttente = listeAttente.iterator().next(); // Récupère le premier étudiant de la liste d'attente
                lesEtudiants.add(etudiantAttente); // Ajoute l'étudiant de la liste d'attente à la maison
                listeAttente.remove(etudiantAttente); // Retire l'étudiant de la liste d'attente
                System.out.println("L'étudiant " + etudiantAttente.getNom() + " a été ajouté à la maison depuis la liste d'attente.");
            }
            System.out.println("L'étudiant " + e.getNom() + " a été supprimé de la maison.");
        } else {
            throw new IllegalArgumentException("L'étudiant " + e.getNom() + " n'a pas été trouvé dans la maison.");
        }
    }


    public boolean estPleine() {
        return lesEtudiants.size() >= capaciteMax; // Vérifie si le nombre d'étudiants dépasse la capacité maximale
    }

    public void afficherListeEtudiants() {
        System.out.println("Liste des étudiants dans la maison " + nom + ":");
        for (Etudiant e : lesEtudiants) {
            System.out.println("Nom : " + e.getNom() + ", Prénom : " + e.getPrenom());
        }
    }

    public void afficherListeAttente() {
        System.out.println("Liste d'attente de la maison " + nom + ":");
        for (Etudiant e : listeAttente) {
            System.out.println("Nom : " + e.getNom() + ", Prénom : " + e.getPrenom());
        }
    }

    public void afficherCaracteristiques() {
        System.out.println("La maison est : " + nom);
        System.out.println("L'adresse de la maison est : " + adresse);
        System.out.println("La capacité max de la maison est : " + capaciteMax);
        System.out.println("La nationalité principale de la maison est : " + nationalitePrincipale);
        System.out.println("Le directeur de la maison est : " + directeur);
        System.out.println("Le nombre d'étudiants dans la maison est : " + lesEtudiants.size());
    }

    //---------------------------------------------------
    // ACCESSEURS
    //---------------------------------------------------
    public String getNom() {
        return this.nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public int getCapaciteMax() {
        return this.capaciteMax;
    }

    public String getNationalitePrincipale() {
        return this.nationalitePrincipale;
    }

    public Collection<Etudiant> getListeEtudiant() {
        return new ArrayList<>(lesEtudiants); // Retourne une nouvelle ArrayList pour éviter de modifier directement l'attribut
    }

    public Collection<Etudiant> getListeAttente() {
        return new ArrayList<>(listeAttente); // Retourne une nouvelle ArrayList pour éviter de modifier directement l'attribut
    }
}