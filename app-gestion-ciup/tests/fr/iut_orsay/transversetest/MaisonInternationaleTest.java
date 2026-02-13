package fr.iut_orsay.transversetest;

import fr.iut_orsay.transverse.models.MaisonInternationale;
import fr.iut_orsay.transverse.models.Service;

public class MaisonInternationaleTest {

    public static void testAjouterService() {
        MaisonInternationale maison = new MaisonInternationale("123 Rue de l'Université");
        Service service = new Service("Bibliothèque", "9h-17h", "Bâtiment A", "Accès libre");

        maison.ajouterService(service);

        Service[] services = maison.getListeServices();
        assert services.length == 1 : " TEST FAILED ! Le nombre de services devrait être 1 après l'ajout.";
        assert services[0] == service : " TEST FAILED ! Le service ajouté devrait être le même que celui passé en argument.";

        System.out.println(" TEST PASSED ! Le Test de la méthode AjouterService est réussi.");
    }

    
}
