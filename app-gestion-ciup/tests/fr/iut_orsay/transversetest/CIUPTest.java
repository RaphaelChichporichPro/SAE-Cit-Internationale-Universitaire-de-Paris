package fr.iut_orsay.transversetest;

public class CIUPTest {
	public static void main(String[] args) {
		System.out.println("Running tests...");
		
		/// - Testing class Maison
		MaisonTest maisonTest = new MaisonTest();
		maisonTest.inscrireEtudiant_notFullHouse_studentAddedToList();
		maisonTest.inscrireEtudiant_fullHouse_studentAddedToQueue();
		maisonTest.supprimerEtudiant_notEmptyHouse_studentRemoved();
		maisonTest.supprimerEtudiant_emptyHouse_throwsError();
		maisonTest.supprimerEtudiant_fullHouse_registersNextStudentInQueue();
		
		/// - Testing class ListeMaison
		ListeMaisonTest.runTest();
		
		System.out.println("✓ All tests passed !");
		System.out.println();

		/// - Testing class Service
		ServiceTest serviceTest = new ServiceTest();
        serviceTest.reserverServices_NormalInput_ExpectedReservationSuccess();
        serviceTest.reserverServices_EmptyInput_ExpectedReservationSuccess();
        serviceTest.reserverServices_TwoReservations_ExpectedListSizeTwo();
        serviceTest.annulerReservation_ValidId_ExpectedSuccessfulCancellation();
        serviceTest.annulerReservation_InvalidId_ExpectedHandledGracefully();
        serviceTest.annulerReservation_AlreadyCancelledId_ExpectedNoCrash();
        serviceTest.annulerReservation_OneValidId_ExpectedListSizeOne();
        System.out.println("All tests passed.");
        System.out.println();

        /// - Testing class Alumni
        AlumniTest alumniTest = new AlumniTest();
        alumniTest.mettreAJourInfos_NormalInput_ExpectedUpdatedValues();
        alumniTest.mettreAJourInfos_EmptyInput_ExpectedEmptyValues();
        alumniTest.mettreAJourInfos_NullInput_ExpectedNullValues();
        alumniTest.mettreAJourInfos_SameValues_ExpectedNoChangeInBehavior();
        alumniTest.addAlumni_NormalInput_ExpectedAddedStatus();
        alumniTest.addAlumni_SpecialCharacters_ExpectedNoCrash();
        alumniTest.addAlumni_EmptyName_ExpectedNoCrash();
        alumniTest.addAlumni_LongName_ExpectedNoCrash();
        System.out.println("All tests passed.");
        
        // Test CLasse MaisonInternational
        MaisonInternationaleTest.testAjouterService();

     // Test CLasse FactoryCIUP
        // Tests de création d'étudiant
        FactoryCIUPtest.testCreerEtudiant_ValidInput_ExpectedBehavior();
        FactoryCIUPtest.testCreerEtudiant_NomNul_ExpectedBehavior();
        FactoryCIUPtest.testCreerEtudiant_NationaliteNulle_ExpectedBehavior();
        FactoryCIUPtest.testCreerEtudiant_DateNaissanceNulle_ExpectedBehavior();
        FactoryCIUPtest.testCreerEtudiant_EmailNul_ExpectedBehavior();
        FactoryCIUPtest.testCreerEtudiant_MaisonNulle_ExpectedBehavior();

        // Tests de création de maison
        FactoryCIUPtest.testCreerMaison_ValidInput_ExpectedBehavior();
        FactoryCIUPtest.testCreerMaison_NomNul_ExpectedBehavior();
        FactoryCIUPtest.testCreerMaison_AdresseNulle_ExpectedBehavior();
        FactoryCIUPtest.testCreerMaison_CapaciteMaxNulle_ExpectedBehavior();
        FactoryCIUPtest.testCreerMaison_NationalitePrincipaleNulle_ExpectedBehavior();
        FactoryCIUPtest.testCreerMaison_DirecteurNul_ExpectedBehavior();
	}
}
