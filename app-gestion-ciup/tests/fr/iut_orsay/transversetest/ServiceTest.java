package fr.iut_orsay.transversetest;

import fr.iut_orsay.transverse.models.Service;

public class ServiceTest {

    private Service service;

    private void setup() {
        service = new Service("Bibliothèque", "9h-18h", "Campus", "Accès libre");
    }

    //------------------------------------------------------------------------------------
    // TEST POUR LA METHODE reserverServices
    //------------------------------------------------------------------------------------

    public void reserverServices_NormalInput_ExpectedReservationSuccess() {
        setup();
        try {
            boolean result = service.reserverServices("Réservation pour une salle de lecture");
            assert result : "La réservation devrait réussir.";
            System.out.println("reserverServices_NormalInput_ExpectedReservationSuccess passed.\n");
        } catch (Exception e) {
            System.out.println("reserverServices_NormalInput_ExpectedReservationSuccess failed: " + e.getMessage());
        }
    }

    public void reserverServices_EmptyInput_ExpectedReservationSuccess() {
        setup();
        try {
            boolean result = service.reserverServices("");
            assert result : "La réservation devrait réussir même avec des détails vides.";
            System.out.println("reserverServices_EmptyInput_ExpectedReservationSuccess passed.\n");
        } catch (Exception e) {
            System.out.println("reserverServices_EmptyInput_ExpectedReservationSuccess failed: " + e.getMessage());
        }
    }

    public void reserverServices_TwoReservations_ExpectedListSizeTwo() {
        setup();
        try {
            service.reserverServices("Réservation pour une salle de lecture");
            service.reserverServices("Réservation pour un auditorium");
            assert service.getReservations().size() == 2 : "La taille de la liste des réservations devrait être 2.";
            System.out.println("reserverServices_TwoReservations_ExpectedListSizeTwo passed.\n");
        } catch (Exception e) {
            System.out.println("reserverServices_TwoReservations_ExpectedListSizeTwo failed: " + e.getMessage());
        }
    }

    //------------------------------------------------------------------------------------
    // TEST POUR LA METHODE annulerReservation
    //------------------------------------------------------------------------------------

    public void annulerReservation_ValidId_ExpectedSuccessfulCancellation() {
        setup();
        try {
            service.reserverServices("Réservation pour une salle de lecture");
            service.annulerReservation(1);
            System.out.println("annulerReservation_ValidId_ExpectedSuccessfulCancellation passed.\n");
        } catch (Exception e) {
            System.out.println("annulerReservation_ValidId_ExpectedSuccessfulCancellation failed: " + e.getMessage());
        }
    }

    public void annulerReservation_InvalidId_ExpectedHandledGracefully() {
        setup();
        try {
            service.reserverServices("Réservation pour une salle de lecture");
            service.annulerReservation(2); // ID 2 n'existe pas
            System.out.println("annulerReservation_InvalidId_ExpectedHandledGracefully passed.\n");
        } catch (Exception e) {
            System.out.println("annulerReservation_InvalidId_ExpectedHandledGracefully failed: " + e.getMessage());
        }
    }

    public void annulerReservation_AlreadyCancelledId_ExpectedNoCrash() {
        setup();
        try {
            service.reserverServices("Réservation pour une salle de lecture");
            service.annulerReservation(1);
            service.annulerReservation(1); // ID 1 a déjà été annulé
            System.out.println("annulerReservation_AlreadyCancelledId_ExpectedNoCrash passed.\n");
        } catch (Exception e) {
            System.out.println("annulerReservation_AlreadyCancelledId_ExpectedNoCrash failed: " + e.getMessage());
        }
    }
    
    public void annulerReservation_OneValidId_ExpectedListSizeOne() {
        setup();
        try {
            service.reserverServices("Réservation pour une salle de lecture");
            service.reserverServices("Réservation pour un auditorium");
            assert service.getReservations().size() == 2 : "La taille de la liste des réservations devrait être 2 avant annulation.";
            service.annulerReservation(1);
            assert service.getReservations().size() == 1 : "La taille de la liste des réservations devrait être 1 après annulation.";
            System.out.println("annulerReservation_OneValidId_ExpectedListSizeOne passed.\n");
        } catch (Exception e) {
            System.out.println("annulerReservation_OneValidId_ExpectedListSizeOne failed: " + e.getMessage());
        }
    }
}
