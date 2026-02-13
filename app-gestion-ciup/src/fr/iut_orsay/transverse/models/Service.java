package fr.iut_orsay.transverse.models;

import java.util.ArrayList;

public class Service {

    //---------------------------------------------------
    // ATTRIBUTS
    //---------------------------------------------------
    
    private String nom;
    private String horaires;
    private String lieu;
    private String detailsSpecifique;
    private ArrayList<String> reservations;  // Stocke les données
    private int compteurReservation;

    //----------------------------------------------------
    // Constructeur
    //----------------------------------------------------

    public Service(String nom, String horaires, String lieu, String detailsSpecifique) {
        this.nom = nom;
        this.horaires = horaires;
        this.lieu = lieu;
        this.detailsSpecifique = detailsSpecifique;
        this.reservations = new ArrayList<>();  // Initialisation de l'ArrayList
        this.compteurReservation = 1;
    }

    //-----------------------------------------------------
    // METHODES
    //-----------------------------------------------------

    public void afficherInfos() {
        System.out.println("Nom du service: " + nom);
        System.out.println("Horaires: " + horaires);
        System.out.println("Lieu: " + lieu);
        System.out.println("Détails spécifiques: " + detailsSpecifique);
    }

    public boolean reserverServices(String details) {
        reservations.add(details);  // Ajoute la réservation à la fin de la liste
        System.out.println("Réservation confirmée avec l'ID: " + compteurReservation);
        compteurReservation++;  // Incrémente l'id de reservation
        return true;
    }

    public void annulerReservation(int idReservation) {
        if (idReservation <= reservations.size() && idReservation > 0) {
            String reservationAnnulee = reservations.remove(idReservation - 1);  // Supprime l'élément à l'index idReservation - 1
            System.out.println("Réservation " + idReservation + " annulée avec succès : " + reservationAnnulee);
        } else {
            System.out.println("Aucune réservation trouvée avec l'ID: " + idReservation);
        }
    }

    public String getHoraires() {
        return this.horaires;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }
    public ArrayList<String> getReservations() {
        return reservations;
    }
}
