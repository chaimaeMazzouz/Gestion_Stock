package presentation;

import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Commande;
import entities.Demande;
import entities.Fournisseur;
import entities.LigneCommande;
import entities.LigneDemande;
import entities.Produit;
import services.ClientService;
import services.CommandeService;
import services.DemandeService;
import services.FournisseurService;
import services.ProduitService;
import connexion.Connexion;

public class Test {
    private static Scanner scanner = new Scanner(System.in);
    private static ClientService clientService = new ClientService();
    private static ProduitService produitService = new ProduitService();
    private static CommandeService commandeService = new CommandeService();
    private static FournisseurService fournisseurService = new FournisseurService();
    private static DemandeService demandeService = new DemandeService();

    public static void main(String[] args) {
        /*
         * produitService.create(new Produit("Clavier", 1000));
         * produitService.create(new Produit("USB", 200));
         * clientService.create(new Client("mazzouz", "060342340", "bouti@gmail.com"));
         * clientService.create(new Client("Issam", "063623440", "mazzouz@gmail.com"));
         * Commande commande1 = new Commande(new Date(), clientService.findById(1));
         * commande1.getLigneCommandes().add(new LigneCommande(10, 1000, commande1,
         * produitService.findById(1)));
         * Commande commande2 = new Commande(new Date(), clientService.findById(2));
         * commande2.getLigneCommandes().add(new LigneCommande(10, 1100, commande2,
         * produitService.findById(1)));
         * commande2.getLigneCommandes().add(new LigneCommande(20, 2000, commande2,
         * produitService.findById(2)));
         * 
         * commandeService.create(commande1);
         * commandeService.create(commande2);
         */

        boolean quite = false;
        while (true) {
            if (quite)
                break;
            System.out.println("1 => Gestion Produit");
            System.out.println("2 => Gestion Client");
            System.out.println("3 => Gestion Command");
            System.out.println("4 => Gestion Fournisseur");
            System.out.println("5 => Gestion Demande");
            System.out.println("6 => Quitter");
            String choix = scanner.next();
            switch (choix) {
                case "1":
                    gestionProduits();
                    break;
                case "2":
                    gestionClients();
                    break;
                case "3":
                    gestionCommands();
                    break;
                case "4":
                    gestionFournisseur();
                    break;
                case "5":
                    gestionDemandes();
                    break;
                case "6":
                    quite = true;
                    break;
                default:
                    System.out.println("Choix Invalid ");
                    break;
            }
        }
    }

    public static void gestionProduits() {
        boolean backToMain = false;
        while (true) {
            if (backToMain)
                break;
            System.out.println("----------------- Gestion Produit -----------------");
            System.out.println("1 - Ajouter Produit");
            System.out.println("2 - Supprimer Produit");
            System.out.println("3 - Modifier Produit");
            System.out.println("4 - Afficher Produits");
            System.out.println("5 - Quitter");
            String choix = scanner.next();
            switch (choix) {
                case "1":
                    System.out.println("=>Entrer les informations de Produit : ");
                    System.out.println("Entrer Designation  => ");
                    String designation = scanner.next();
                    System.out.println("Entrer Prix Achat => ");
                    float prixAchat = scanner.nextFloat();
                    boolean resultCreate = produitService.create(new Produit(designation, prixAchat));
                    if (resultCreate)
                        System.out.println("Ajout Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "2":
                    System.out.println("Entrer Id Produit => ");
                    int idToDelete = scanner.nextInt();
                    boolean resultDelete = produitService.delete(produitService.findById(idToDelete));
                    if (resultDelete)
                        System.out.println("Supprission Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "3":
                    System.out.println("=>Entrer Id Produit A Modifier => ");
                    int idToModify = scanner.nextInt();
                    System.out.println("Entrer Designation  => ");
                    String newDesignation = scanner.next();
                    System.out.println("Entrer Prix Achat => ");
                    float newPrixAchat = scanner.nextFloat();
                    Produit updatedProduit = new Produit(newDesignation, newPrixAchat);
                    updatedProduit.setId(idToModify);
                    boolean resultUpdate = produitService.update(updatedProduit);
                    if (resultUpdate)
                        System.out.println("Modification Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "4":
                    System.out.println(produitService);
                    break;
                case "5":
                    backToMain = true;
                    break;
                default:
                    System.out.println("Choix Invalide");
                    break;
            }
        }
    }

    public static void gestionClients() {
        boolean backToMain = false;
        while (true) {
            if (backToMain)
                break;
            System.out.println("1 - Ajouter Client");
            System.out.println("2 - Supprimer Client");
            System.out.println("3 - Modifier Client");
            System.out.println("4 - Afficher Clients");
            System.out.println("5 - Quitter");
            String choix = scanner.next();
            switch (choix) {
                case "1":
                    System.out.println("=>Entrer les Informations de Client : ");
                    System.out.println("Entrer Nom  => ");
                    String nom = scanner.next();
                    System.out.println("Entrer Telephone => ");
                    String telephone = scanner.next();
                    System.out.println("Entrer Email => ");
                    String email = scanner.next();
                    boolean resultCreate = clientService.create(new Client(nom, telephone, email));
                    if (resultCreate)
                        System.out.println("Ajout Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "2":
                    System.out.println("=>Entrer Id Client : ");
                    int idToDelete = scanner.nextInt();
                    boolean resultDelete = clientService.delete(clientService.findById(idToDelete));
                    if (resultDelete)
                        System.out.println("Supprission Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "3":
                    System.out.println("=>Entrer Id Client A Modifier : ");
                    int idToModify = scanner.nextInt();
                    System.out.println("=>Entrer Nouveau Informations : ");
                    System.out.println("Entrer Nom  : ");
                    String newNom = scanner.next();
                    System.out.println("Entrer Telephone : ");
                    String newTelephone = scanner.next();
                    System.out.println("Entrer Email : ");
                    String newEmail = scanner.next();
                    Client updatedClient = new Client(newNom, newTelephone, newEmail);
                    updatedClient.setId(idToModify);
                    boolean resultUpdate = clientService.update(updatedClient);
                    if (resultUpdate)
                        System.out.println("Modification Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "4":
                    System.out.println(clientService);
                    break;
                case "5":
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid Choix");
                    break;
            }
        }
    }

    public static void gestionCommands() {
        boolean backToMain = false;
        while (true) {
            if (backToMain)
                break;
            System.out.println("1 - Ajouter Command");
            System.out.println("2 - Supprimer Command");
            System.out.println("3 - Modifier Command");
            System.out.println("4 - Afficher Command");
            System.out.println("5 - Back To Main");
            String choix = scanner.next();
            switch (choix) {
                case "1":
                    System.out.println("ClientId  => ");
                    int commandClientId = scanner.nextInt();
                    Commande newCommande = new Commande(new Date(), clientService.findById(commandClientId));
                    System.out.println("Entrer Les LigneCommande ");
                    myWhile: while (true) {
                        System.out.println("1 - Ajouter LigneCommande");
                        System.out.println("2 - Terminer");
                        String choixNewLigne = scanner.next();
                        switch (choixNewLigne) {
                            case "1":
                                System.out.println("Produit Id  => ");
                                int ligneProduitId = scanner.nextInt();
                                System.out.println("Qte  => ");
                                int ligneQte = scanner.nextInt();
                                newCommande.getLigneCommandes()
                                        .add(new LigneCommande(ligneQte,
                                                produitService.findById(ligneProduitId).getPrixAchat(),
                                                newCommande, produitService.findById(ligneProduitId)));
                                break;
                            case "2":
                                break myWhile;
                        }
                    }
                    boolean resultatCreateCommande = commandeService.create(newCommande);
                    if (resultatCreateCommande)
                        System.out.println("Ajout Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "2":
                    System.out.println("Entrer Id Commande => ");
                    int idToDelete = scanner.nextInt();
                    boolean resultDelete = commandeService.delete(commandeService.findById(idToDelete));
                    if (resultDelete)
                        System.out.println("Supprission Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "3":
                    System.out.println("Entrer Id Commande A Modifier => ");
                    int idToModify = scanner.nextInt();

                    System.out.println("Client Id  => ");
                    int updatedClientId = scanner.nextInt();
                    Commande updatedCommand = new Commande(new Date(), clientService.findById(updatedClientId));
                    updatedCommand.setId(idToModify);
                    System.out.println("Entrer Les Nouveaux LigneCommande ");
                    myWhile: while (true) {
                        System.out.println("1 - Ajouter LigneCommande");
                        System.out.println("2 - Terminer");
                        String choixNewLigne = scanner.next();
                        switch (choixNewLigne) {
                            case "1":
                                System.out.println("Produit Id  => ");
                                int ligneProduitId = scanner.nextInt();
                                System.out.println("Qte  => ");
                                int ligneQte = scanner.nextInt();
                                updatedCommand.getLigneCommandes()
                                        .add(new LigneCommande(ligneQte,
                                                produitService.findById(ligneProduitId).getPrixAchat(),
                                                updatedCommand, produitService.findById(ligneProduitId)));
                                break;
                            case "2":
                                break myWhile;
                        }
                    }
                    boolean resultUpdate = commandeService.update(updatedCommand);
                    if (resultUpdate)
                        System.out.println("Modification Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "4":
                    System.out.println(commandeService);
                    break;
                case "5":
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid Choix");
                    break;
            }
        }
    }

    public static void gestionDemandes() {
        boolean backToMain = false;
        while (true) {
            if (backToMain)
                break;
            System.out.println("1 - Ajouter Demande");
            System.out.println("2 - Supprimer Demande");
            System.out.println("3 - Modifier Demande");
            System.out.println("4 - Afficher Demande");
            System.out.println("5 - Back To Main");
            String choix = scanner.next();
            switch (choix) {
                case "1":
                    System.out.println("FournisseurId  => ");
                    int commandFournisseurId = scanner.nextInt();
                    Demande newDemande = new Demande(new Date(), fournisseurService.findById(commandFournisseurId));
                    System.out.println("Entrer Les LigneDemande ");
                    myWhile: while (true) {
                        System.out.println("1 - Ajouter LigneDemande");
                        System.out.println("2 - Terminer");
                        String choixNewLigne = scanner.next();
                        switch (choixNewLigne) {
                            case "1":
                                System.out.println("Produit Id  => ");
                                int ligneProduitId = scanner.nextInt();
                                System.out.println("Qte  => ");
                                int ligneQte = scanner.nextInt();
                                newDemande.getLigneDemandes()
                                        .add(new LigneDemande(ligneQte,
                                                produitService.findById(ligneProduitId).getPrixAchat(),
                                                newDemande, produitService.findById(ligneProduitId)));
                                break;
                            case "2":
                                break myWhile;
                        }
                    }
                    boolean resultatCreateDemande = demandeService.create(newDemande);
                    if (resultatCreateDemande)
                        System.out.println("Ajout Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "2":
                    System.out.println("Entrer Id Demande => ");
                    int idToDelete = scanner.nextInt();
                    boolean resultDelete = demandeService.delete(demandeService.findById(idToDelete));
                    if (resultDelete)
                        System.out.println("Supprission Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "3":
                    System.out.println("Entrer Id Demande A Modifier => ");
                    int idToModify = scanner.nextInt();

                    System.out.println("Fournisseur Id  => ");
                    int updatedFournisseurId = scanner.nextInt();
                    Demande updatedDemande = new Demande(new Date(), fournisseurService.findById(updatedFournisseurId));
                    updatedDemande.setId(idToModify);
                    System.out.println("Entrer Les Nouveaux LigneDemande ");
                    myWhile: while (true) {
                        System.out.println("1 - Ajouter LigneDemande");
                        System.out.println("2 - Terminer");
                        String choixNewLigne = scanner.next();
                        switch (choixNewLigne) {
                            case "1":
                                System.out.println("Produit Id  => ");
                                int ligneProduitId = scanner.nextInt();
                                System.out.println("Qte  => ");
                                int ligneQte = scanner.nextInt();
                                updatedDemande.getLigneDemandes()
                                        .add(new LigneDemande(ligneQte,
                                                produitService.findById(ligneProduitId).getPrixAchat(),
                                                updatedDemande, produitService.findById(ligneProduitId)));
                                break;
                            case "2":
                                break myWhile;
                        }
                    }
                    boolean resultUpdate = demandeService.update(updatedDemande);
                    if (resultUpdate)
                        System.out.println("Modification Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "4":
                    System.out.println(demandeService);
                    break;
                case "5":
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid Choix");
                    break;
            }
        }
    }

    public static void gestionFournisseur() {
        boolean backToMain = false;
        while (true) {
            if (backToMain)
                break;
            System.out.println("1 - Ajouter Fournisseur");
            System.out.println("2 - Supprimer Fournisseur");
            System.out.println("3 - Modifier Fournisseur");
            System.out.println("4 - Afficher Fournisseurs");
            System.out.println("5 - Quitter");
            String choix = scanner.next();
            switch (choix) {
                case "1":
                    System.out.println("=>Entrer les Informations de Fournisseur : ");
                    System.out.println("Entrer Nom  => ");
                    String nom = scanner.next();
                    System.out.println("Entrer Telephone => ");
                    String telephone = scanner.next();
                    System.out.println("Entrer Email => ");
                    String email = scanner.next();
                    boolean resultCreate = fournisseurService.create(new Fournisseur(nom, telephone, email));
                    if (resultCreate)
                        System.out.println("Ajout Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "2":
                    System.out.println("=>Entrer Id Fournisseur : ");
                    int idToDelete = scanner.nextInt();
                    boolean resultDelete = fournisseurService.delete(fournisseurService.findById(idToDelete));
                    if (resultDelete)
                        System.out.println("Supprission Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "3":
                    System.out.println("=>Entrer Id Fournisseur A Modifier : ");
                    int idToModify = scanner.nextInt();
                    System.out.println("=>Entrer Nouveau Informations : ");
                    System.out.println("Entrer Nom  : ");
                    String newNom = scanner.next();
                    System.out.println("Entrer Telephone : ");
                    String newTelephone = scanner.next();
                    System.out.println("Entrer Email : ");
                    String newEmail = scanner.next();
                    Fournisseur updatedFournisseur = new Fournisseur(newNom, newTelephone, newEmail);
                    updatedFournisseur.setId(idToModify);
                    boolean resultUpdate = fournisseurService.update(updatedFournisseur);
                    if (resultUpdate)
                        System.out.println("Modification Effectue");
                    else
                        System.out.println("Erreur");
                    break;
                case "4":
                    System.out.println(fournisseurService);
                    break;
                case "5":
                    backToMain = true;
                    break;
                default:
                    System.out.println("Invalid Choix");
                    break;
            }
        }
    }
}