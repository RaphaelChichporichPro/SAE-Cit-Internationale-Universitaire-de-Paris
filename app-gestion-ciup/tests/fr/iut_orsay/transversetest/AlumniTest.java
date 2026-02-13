package fr.iut_orsay.transversetest;

import java.util.Arrays;

import fr.iut_orsay.transverse.models.Alumni;

public class AlumniTest {

    private Alumni alumni;

    private void setup() {
        alumni = new Alumni("Dupont", "Jean", 2020, "Ingénieur", "TechCorp", "jean.dupont@example.com", Arrays.asList(2018, 2019, 2020));
    }

    //------------------------------------------------------------------------------------
    // TEST POUR LA METHODE mettreAJourInfos
    //------------------------------------------------------------------------------------
    
    public void mettreAJourInfos_NormalInput_ExpectedUpdatedValues() {
        setup();
        try {
            alumni.mettreAJourInfos("Directeur", "InnoTech", "jean.dupont@innotech.com");
            assert "Directeur".equals(alumni.getProfession()) : "Profession should be updated.";
            assert "InnoTech".equals(alumni.getEntreprise()) : "Entreprise should be updated.";
            assert "jean.dupont@innotech.com".equals(alumni.getContact()) : "Contact should be updated.";
            System.out.println("mettreAJourInfos_NormalInput_ExpectedUpdatedValues passed.");
        } catch (AssertionError | Exception e) {
            System.out.println("mettreAJourInfos_NormalInput_ExpectedUpdatedValues failed: " + e.getMessage());
        }
    }

    public void mettreAJourInfos_EmptyInput_ExpectedEmptyValues() {
        setup();
        try {
            alumni.mettreAJourInfos("", "", "");
            assert "".equals(alumni.getProfession()) : "Profession should be empty.";
            assert "".equals(alumni.getEntreprise()) : "Entreprise should be empty.";
            assert "".equals(alumni.getContact()) : "Contact should be empty.";
            System.out.println("mettreAJourInfos_EmptyInput_ExpectedEmptyValues passed.");
        } catch (AssertionError | Exception e) {
            System.out.println("mettreAJourInfos_EmptyInput_ExpectedEmptyValues failed: " + e.getMessage());
        }
    }

    public void mettreAJourInfos_NullInput_ExpectedNullValues() {
        setup();
        try {
            alumni.mettreAJourInfos(null, null, null);
            assert alumni.getProfession() == null : "Profession should be null.";
            assert alumni.getEntreprise() == null : "Entreprise should be null.";
            assert alumni.getContact() == null : "Contact should be null.";
            System.out.println("mettreAJourInfos_NullInput_ExpectedNullValues passed.");
        } catch (AssertionError | Exception e) {
            System.out.println("mettreAJourInfos_NullInput_ExpectedNullValues failed: " + e.getMessage());
        }
    }
    
    public void mettreAJourInfos_SameValues_ExpectedNoChangeInBehavior() {
        setup();
        try {
            alumni.mettreAJourInfos("Ingénieur", "TechCorp", "jean.dupont@example.com");
            assert "Ingénieur".equals(alumni.getProfession()) : "Profession should remain the same.";
            assert "TechCorp".equals(alumni.getEntreprise()) : "Entreprise should remain the same.";
            assert "jean.dupont@example.com".equals(alumni.getContact()) : "Contact should remain the same.";
            System.out.println("mettreAJourInfos_SameValues_ExpectedNoChangeInBehavior passed.");
        } catch (AssertionError | Exception e) {
            System.out.println("mettreAJourInfos_SameValues_ExpectedNoChangeInBehavior failed: " + e.getMessage());
        }
    }


    //------------------------------------------------------------------------------------
    // TEST POUR LA METHODE addAlumni
    //------------------------------------------------------------------------------------
    
    public void addAlumni_NormalInput_ExpectedAddedStatus() {
        setup();
        try {
            alumni.addAlumni();
            assert alumni != null : "Alumni should not be null after addAlumni.";
            assert "Dupont".equals(alumni.getNom()) : "Nom should be Dupont.";
            System.out.println("addAlumni_NormalInput_ExpectedAddedStatus passed.");
        } catch (AssertionError | Exception e) {
            System.out.println("addAlumni_NormalInput_ExpectedAddedStatus failed: " + e.getMessage());
        }
    }

    public void addAlumni_SpecialCharacters_ExpectedNoCrash() {
        alumni = new Alumni("D'Angelo", "Zoë", 2021, "Artiste", "StudioX", "zoe@example.com", Arrays.asList(2019, 2020, 2021));
        try {
            alumni.addAlumni();
            assert "D'Angelo".equals(alumni.getNom()) : "Nom should be D'Angelo.";
            assert "Zoë".equals(alumni.getPrenom()) : "Prenom should be Zoë.";
            System.out.println("addAlumni_SpecialCharacters_ExpectedNoCrash passed.");
        } catch (AssertionError | Exception e) {
            System.out.println("addAlumni_SpecialCharacters_ExpectedNoCrash failed: " + e.getMessage());
        }
    }

    public void addAlumni_EmptyName_ExpectedNoCrash() {
        alumni = new Alumni("", "Jean", 2020, "Prof", "Lycée", "contact@example.com", Arrays.asList(2017, 2018));
        try {
            alumni.addAlumni();
            assert "".equals(alumni.getNom()) : "Nom should be empty.";
            assert "Jean".equals(alumni.getPrenom()) : "Prenom should be Jean.";
            System.out.println("addAlumni_EmptyName_ExpectedNoCrash passed.");
        } catch (AssertionError | Exception e) {
            System.out.println("addAlumni_EmptyName_ExpectedNoCrash failed: " + e.getMessage());
        }
    }

    public void addAlumni_LongName_ExpectedNoCrash() {
        String longName = "JeanMichelSuperLongNomAvecBeaucoupDeCaracteres";
        alumni = new Alumni(longName, "TrèsLongPrenomAussi", 2020, "Dev", "BigCorp", "contact@example.com", Arrays.asList(2018, 2019));
        try {
            alumni.addAlumni();
            assert longName.equals(alumni.getNom()) : "Nom should match long name.";
            assert "TrèsLongPrenomAussi".equals(alumni.getPrenom()) : "Prenom should match long prenom.";
            System.out.println("addAlumni_LongName_ExpectedNoCrash passed.");
        } catch (AssertionError | Exception e) {
            System.out.println("addAlumni_LongName_ExpectedNoCrash failed: " + e.getMessage());
        }
    }
}
