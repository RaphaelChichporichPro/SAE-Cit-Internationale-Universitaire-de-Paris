package fr.iut_orsay.transverse.models;

import java.util.*;

public class Alumni {

    //-----------------------------------------------------------------------
    // ATTRIBUTS
    //-----------------------------------------------------------------------
    
    private String nom;
    private String prenom;
    private int anneeDiplome;
    private String profession;
    private String entreprise;
    private String contact;
    private Collection<Integer> anneesLogement;

    //-----------------------------------------------------------------------
    // CONSTRUCTEURS
    //-----------------------------------------------------------------------

    public Alumni(String nom, String prenom, int anneeDiplome, String profession, String entreprise, String contact, Collection<Integer> anneesLogement) {
        this.nom = nom;
        this.prenom = prenom;
        this.anneeDiplome = anneeDiplome;
        this.profession = profession;
        this.entreprise = entreprise;
        this.contact = contact;
        this.anneesLogement = new ArrayList<>(anneesLogement);
    }
     
    //------------------------------------------------------------------------
    // METHODES
    //------------------------------------------------------------------------ 
    public void afficheDescription() {
        System.out.println("Nom: " + nom);
        System.out.println("Prénom: " + prenom);
        System.out.println("Année de diplôme: " + anneeDiplome);
        System.out.println("Profession: " + profession);
        System.out.println("Entreprise: " + entreprise);
        System.out.println("Contact: " + contact);
        System.out.println("Années de logement: " + anneesLogement);
    }

    /**
     * Met à jour les informations professionnelles de l'Alumni.
     *
     * @param profession La nouvelle profession.
     * @param entreprise Le nom de l'entreprise.
     * @param contact Les coordonnées de l'Alumni.
     */
    public void mettreAJourInfos(String profession, String entreprise, String contact) { 
        this.profession = profession;
        this.entreprise = entreprise;
        this.contact = contact;
    }

    public void addAlumni() {
        System.out.println("Alumni ajouté : " + nom + " " + prenom);
    }

    //-----------------------------------------------------------------------
    // GETTERS ET SETTERS
    //-----------------------------------------------------------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnneeDiplome() {
        return anneeDiplome;
    }

    public void setAnneeDiplome(int anneeDiplome) {
        this.anneeDiplome = anneeDiplome;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

  
    public String getContact() {
        return contact;
    }

   
    public void setContact(String contact) {
        this.contact = contact;
    }

    
    public Collection<Integer> getAnneesLogement() {
        return new ArrayList<>(anneesLogement);
    }

    
    public void setAnneesLogement(Collection<Integer> anneesLogement) {
        this.anneesLogement = new ArrayList<>(anneesLogement);
    }
}
